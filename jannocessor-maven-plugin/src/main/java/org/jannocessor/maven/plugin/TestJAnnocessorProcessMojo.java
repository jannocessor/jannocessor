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
import java.util.List;

import org.apache.maven.model.Resource;
import org.apache.maven.project.MavenProject;

/**
 *
 * @goal process-test
 * @requiresDependencyResolution test
 * @phase generate-test-sources
 */
public class TestJAnnocessorProcessMojo extends AbstractJAnnocessorProcessMojo {

	/**
	 * project classpath
	 *
	 * @parameter expression = "${project.testClasspathElements}"
	 * @required
	 * @readonly
	 */
	@SuppressWarnings("rawtypes")
	private List classpathElements;

	/**
	 *
	 * @parameter expression = "${project.build.testSourceDirectory}"
	 * @required
	 */
	private File sourceDirectory;

	/**
	 * Set the destination directory for class files (same behaviour of -d
	 * option)
	 *
	 * @parameter expression="${project.build.testOutputDirectory}"
	 */
	private File outputClassDirectory;

	@Override
	public File getSourceDirectory() {
		return sourceDirectory;
	}

	protected void addCompileSourceRoot(MavenProject project, String dir) {
		project.addTestCompileSourceRoot(dir);
	}

	@Override
	protected File getOutputClassDirectory() {
		return outputClassDirectory;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected java.util.Set<String> getClasspathElements(java.util.Set<String> result) {
		List<Resource> resources = project.getTestResources();

		if (resources != null) {
			for (Resource r : resources) {
				result.add(r.getDirectory());
			}
		}

		result.addAll(classpathElements);

		return result;
	}

}
