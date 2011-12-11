/**
 * Copyright 2011 Nikolche Mihajlovski
 *
 * This file is derived from a source code from Bartolomeo Sorrentino
 * published under GNU LGPL in the project "maven-annotation-plugin".
 * (URL: http://code.google.com/p/maven-annotation-plugin/)
 *
 * This file is part of JAnnocessor.
 *
 * JAnnocessor is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JAnnocessor is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with JAnnocessor.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.jannocessor.maven.plugin;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticListener;
import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import org.apache.maven.artifact.Artifact;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.FileUtils;
import org.codehaus.plexus.util.StringUtils;

public abstract class AbstractJAnnocessorMojo extends AbstractMojo {

	private static final String PROCESSOR = "org.jannocessor.processor.JannocessorProcessor";

	private Map<String, String> oldSystemProperties = new HashMap<String, String>();

	private String buildCompileClasspath() {

		java.util.Set<String> pathElements = new java.util.LinkedHashSet<String>();

		if (getPluginArtifacts() != null) {

			for (Artifact a : getPluginArtifacts()) {

				if ("compile".equalsIgnoreCase(a.getScope())
						|| "runtime".equalsIgnoreCase(a.getScope())) {

					java.io.File f = a.getFile();

					if (f != null)
						pathElements.add(a.getFile().getAbsolutePath());
				}

			}
		}

		getClasspathElements(pathElements);

		StringBuilder result = new StringBuilder();

		for (String elem : pathElements) {
			result.append(elem).append(File.pathSeparator);
		}
		return result.toString();
	}

	public void execute() throws MojoExecutionException {
		if ("pom".equalsIgnoreCase(getProject().getPackaging())) {
			return;
		}

		try {
			checkPreconditions();

			List<File> files = getFiles();

			Iterable<? extends JavaFileObject> compilationUnits1 = null;

			String compileClassPath = buildCompileClasspath();

			List<String> options = getOptions(compileClassPath);

			DiagnosticListener<JavaFileObject> dl = getDiagnostics();

			setSystemProperties();

			compile(files, compilationUnits1, options, dl);

			restoreSystemProperties();
		} catch (Exception e1) {
			e1.printStackTrace();
			this.getLog().error("error on execute: ", e1);
			if (getFailOnError()) {
				throw new MojoExecutionException("Error executing", e1);
			}
		}

	}

	private void checkPreconditions() {
		// add source dir if needed
		final Boolean add = getProcessOutputSources();
		if (add == null || add.booleanValue()) {
			getLog().info("Source directory: " + getOutputDirectory() + " added");
			addCompileSourceRoot(getProject(), getOutputDirectory().getAbsolutePath());
		}

		// create the folders if needed
		final File f = getOutputDirectory();
		if (!f.exists()) {
			f.mkdirs();
		}
		if (!getOutputClassDirectory().exists()) {
			getOutputClassDirectory().mkdirs();
		}

		// check preconditions
		File sourceDir = getSourceDirectory();
		if (sourceDir == null) {
			getLog().warn(
					"Source directory cannot be read (null returned)! Processor task will be skipped");
			return;
		}
		if (!sourceDir.exists()) {
			getLog().warn("source directory doesn't exist! Processor task will be skipped");
			return;
		}
		if (!sourceDir.isDirectory()) {
			getLog().warn("source directory is invalid! Processor task will be skipped");
			return;
		}
	}

	private void setSystemProperties() {
		for (Map.Entry<String, String> property : getSystemProperties().entrySet()) {
			info("setting system property: %s = %s", property.getKey(), property.getValue());

			// keep the old values
			String oldValue = System.getProperty(property.getKey());
			oldSystemProperties.put(property.getKey(), oldValue);

			// set the new value
			System.setProperty(property.getKey(), property.getValue());
		}
	}

	private void restoreSystemProperties() {
		for (Map.Entry<String, String> property : oldSystemProperties.entrySet()) {
			info("restoring system property: %s = %s", property.getKey(), property.getValue());

			// set the new value
			System.setProperty(property.getKey(), property.getValue());
		}
	}

	private DiagnosticListener<JavaFileObject> getDiagnostics() {
		DiagnosticListener<JavaFileObject> dl = null;
		if (getOutputDiagnostics()) {
			dl = new DiagnosticListener<JavaFileObject>() {
				public void report(Diagnostic<? extends JavaFileObject> diagnostic) {
					getLog().info("diagnostic " + diagnostic);
				}
			};
		} else {
			dl = new DiagnosticListener<JavaFileObject>() {
				public void report(Diagnostic<? extends JavaFileObject> diagnostic) {
				}
			};
		}
		return dl;
	}

	private List<String> getOptions(String compileClassPath) {
		List<String> options = new ArrayList<String>();

		options.add("-cp");
		options.add(compileClassPath);
		options.add("-proc:only");

		addCompilerArguments(options);

		options.add("-processor");
		options.add(PROCESSOR);

		options.add("-d");
		options.add(getOutputClassDirectory().getPath());

		options.add("-s");
		options.add(getOutputDirectory().getPath());

		for (String option : options) {
			getLog().info("javac option: " + option);
		}
		return options;
	}

	private void compile(List<File> files, Iterable<? extends JavaFileObject> compilationUnits1,
			List<String> options, DiagnosticListener<JavaFileObject> dl) throws Exception {
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

		if (compiler == null) {
			getLog().error(
					"JVM is not suitable for processing annotation! ToolProvider.getSystemJavaCompiler() is null.");
			return;
		}

		StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);

		if (files != null && !files.isEmpty()) {
			compilationUnits1 = fileManager.getJavaFileObjectsFromFiles(files);

		} else {
			getLog().warn("no source file(s) detected! Processor task will be skipped");
			return;
		}

		CompilationTask task = compiler.getTask(new PrintWriter(System.out), fileManager, dl,
				options, null, compilationUnits1);

		// Perform the compilation task.
		if (!task.call()) {
			throw new Exception("error during compilation");
		}
	}

	@SuppressWarnings("unchecked")
	private List<File> getFiles() throws IOException {
		final String includesString = (getIncludes() == null || getIncludes().length == 0) ? "**/*.java"
				: StringUtils.join(getIncludes(), ",");
		final String excludesString = (getExcludes() == null || getExcludes().length == 0) ? null
				: StringUtils.join(getExcludes(), ",");

		return FileUtils.getFiles(getSourceDirectory(), includesString, excludesString);
	}

	private void addCompilerArguments(List<String> options) {
		if (!StringUtils.isEmpty(getCompilerArguments())) {
			for (String arg : getCompilerArguments().split(" ")) {
				if (!StringUtils.isEmpty(arg)) {
					arg = arg.trim();
					getLog().info("Adding compiler arg: " + arg);
					options.add(arg);
				}
			}
		}

		String opt = String.format("-A%s=%s", "templates.path", getFilePath(getTemplatesDirectory()));
		options.add(opt);
		getLog().info("Adding compiler arg: " + opt);
	}

	protected String getFilePath(File file) {
		try {
			return file.getCanonicalPath();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	protected String getRelativePath(String path) {
		try {
			return getProject().getBasedir().getCanonicalPath() + path;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	protected String getParentRelativePath(String path) {
		try {
			return getProject().getParent().getBasedir().getCanonicalPath() + path;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	protected void info(String message, Object... arguments) {
		getLog().info(String.format(message, arguments));
	}

	protected void debug(String message, Object... arguments) {
		getLog().debug(String.format(message, arguments));
	}

	protected abstract List<Artifact> getPluginArtifacts();

	protected abstract Set<String> getClasspathElements(Set<String> result);

	protected abstract void addCompileSourceRoot(MavenProject project, String dir);

	protected abstract File getSourceDirectory();

	protected abstract File getTemplatesDirectory();

	protected abstract File getOutputClassDirectory();

	protected abstract MavenProject getProject();

	protected abstract Boolean getFailOnError();

	protected abstract File getOutputDirectory();

	protected abstract String[] getIncludes();

	protected abstract String[] getExcludes();

	protected abstract boolean getOutputDiagnostics();

	protected abstract Map<String, String> getSystemProperties();

	protected abstract String getCompilerArguments();

	protected abstract Boolean getProcessOutputSources();

}