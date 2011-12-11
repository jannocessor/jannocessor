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

/*
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import java.io.File;
import java.util.List;

import org.apache.maven.model.Resource;
import org.apache.maven.project.MavenProject;

/**
 * @goal process
 * @requiresDependencyResolution compile
 * @phase compile
 */
public class MainJAnnocessorProcessMojo extends AbstractJAnnocessorProcessMojo {

	/**
	 * project classpath
	 *
	 * @parameter expression = "${project.compileClasspathElements}"
	 * @required
	 * @readonly
	 */
	@SuppressWarnings("rawtypes")
	private List classpathElements;

	/**
	 * project sourceDirectory
	 *
	 * @parameter expression = "${project.build.sourceDirectory}"
	 * @required
	 */
	private File sourceDirectory;

	/**
	 * Set the destination directory for class files (same behaviour of -d
	 * option)
	 *
	 * @parameter expression="${project.build.outputDirectory}"
	 */
	private File outputClassDirectory;

	@Override
	public File getSourceDirectory() {
		return sourceDirectory;
	}

	@Override
	protected File getOutputClassDirectory() {
		return outputClassDirectory;
	}

	protected void addCompileSourceRoot(MavenProject project, String dir) {
		project.addCompileSourceRoot(dir);
	}

	@Override
	@SuppressWarnings("unchecked")
	protected java.util.Set<String> getClasspathElements(java.util.Set<String> result) {
		List<Resource> resources = project.getResources();

		if (resources != null) {
			for (Resource r : resources) {
				result.add(r.getDirectory());
			}
		}

		result.addAll(classpathElements);

		return result;
	}

}
