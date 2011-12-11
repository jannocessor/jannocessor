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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.maven.artifact.Artifact;
import org.apache.maven.project.MavenProject;

/**
 * @threadSafe
 */
public abstract class AbstractJAnnocessorProcessMojo extends AbstractJAnnocessorMojo {

	/**
	 * @parameter expression = "${project}"
	 * @readonly
	 * @required
	 */
	protected MavenProject project;

	/**
	 * @parameter expression="${plugin.artifacts}"
	 * @readonly
	 */
	java.util.List<Artifact> pluginArtifacts;

	/**
	 * Specify the directory where to place generated source files (same
	 * behaviour of -s option)
	 *
	 * @parameter
	 */
	File outputDirectory;

	/**
	 * Additional compiler arguments
	 *
	 * @parameter
	 *
	 */
	String compilerArguments;

	/**
	 * Name of the module containing the generated source code
	 *
	 * @parameter
	 */
	protected String outputModule;

	/**
	 * Name of the directory containing the templates
	 *
	 * @parameter
	 */
	File templatesDirectory;

	/**
	 * Name of the module containing the templates
	 *
	 * @parameter
	 */
	protected String templatesModule;

	/**
	 * Controls whether or not the output directory is added to compilation
	 */
	Boolean processOutputSources;

	/**
	 * Indicates whether the build will continue even if there are compilation
	 * errors; defaults to true.
	 *
	 * @parameter default-value="true" expression = "${annotation.failOnError}"
	 * @required
	 */
	Boolean failOnError = true;

	/**
	 * Indicates whether the compiler output should be visible, defaults to
	 * true.
	 *
	 * @parameter expression = "${annotation.outputDiagnostics}"
	 *            default-value="true"
	 * @required
	 */
	boolean outputDiagnostics = true;

	/**
	 * System properties set before processor invocation.
	 *
	 * @parameter
	 *
	 */
	java.util.Map<String, String> systemProperties = new HashMap<String, String>();

	/**
	 * includes pattern
	 *
	 * @parameter
	 */
	String[] includes;

	/**
	 * excludes pattern
	 *
	 * @parameter
	 */
	String[] excludes;

	public MavenProject getProject() {
		return project;
	}

	public List<Artifact> getPluginArtifacts() {
		return pluginArtifacts;
	}

	public File getOutputDirectory() {
		if (outputDirectory != null) {
			return outputDirectory;
		} else {
			if (outputModule == null) {
				return getSourceDirectory();
			} else {
				return new File(getParentRelativePath("/" + outputModule + "/src/main/java"));
			}
		}
	}

	public File getTemplatesDirectory() {
		if (templatesDirectory != null) {
			return templatesDirectory;
		} else {
			if (templatesModule == null) {
				return new File(getRelativePath("/src/main/resources"));
			} else {
				return new File(getParentRelativePath("/" + templatesModule + "/src/main/resources"));
			}
		}
	}

	public String getCompilerArguments() {
		return compilerArguments;
	}

	public Boolean getProcessOutputSources() {
		return processOutputSources;
	}

	public Boolean getFailOnError() {
		return failOnError;
	}

	public boolean getOutputDiagnostics() {
		return outputDiagnostics;
	}

	public Map<String, String> getSystemProperties() {
		return systemProperties;
	}

	public String[] getIncludes() {
		return includes;
	}

	public String[] getExcludes() {
		return excludes;
	}

}
