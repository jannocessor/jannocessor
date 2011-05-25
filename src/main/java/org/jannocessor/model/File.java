/**
 * Copyright 2011 jannocessor.org
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

package org.jannocessor.model;

import org.jannocessor.util.FlexyMap;
import org.jannocessor.util.HashFlexyMap;

public class File {

	private final String _package;

	private final String name;

	private final String extension;

	private final String template;

	private final FlexyMap data = new HashFlexyMap();

	public File(String _package, String name, String extension, String template) {
		this._package = _package;
		this.name = name;
		this.extension = extension;
		this.template = template;
	}

	public String getPackage() {
		return _package;
	}

	public String getName() {
		return name;
	}

	public String getExtension() {
		return extension;
	}

	public String getTemplate() {
		return template;
	}

	public FlexyMap getData() {
		return data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((_package == null) ? 0 : _package.hashCode());
		result = prime * result
				+ ((extension == null) ? 0 : extension.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		File other = (File) obj;
		if (_package == null) {
			if (other._package != null)
				return false;
		} else if (!_package.equals(other._package))
			return false;
		if (extension == null) {
			if (other.extension != null)
				return false;
		} else if (!extension.equals(other.extension))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "File [package=" + _package + ", name=" + name + ", extension="
				+ extension + ", template=" + template + ", data=" + data + "]";
	}

}
