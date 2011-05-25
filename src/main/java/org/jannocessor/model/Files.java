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

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Files {

	private Map<FileIdentity, File> files = new HashMap<FileIdentity, File>();

	public File file(String _package, String name, String extension,
			String template) {
		FileIdentity fileId = new FileIdentity(_package, name, extension);

		File file = files.get(fileId);
		if (file == null) {
			file = new File(_package, name, extension, template);
			files.put(fileId, file);
		}

		return file;
	}

	public Collection<File> getAll() {
		return Collections.unmodifiableCollection(files.values());
	}

	private static class FileIdentity {

		private String _package;

		private String name;

		private String extension;

		FileIdentity(String _package, String name, String extension) {
			this._package = _package;
			this.name = name;
			this.extension = extension;
		}

		public String toString() {
			return "FileIdentity [_package=" + _package + ", name=" + name
					+ ", extension=" + extension + "]";
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
			FileIdentity other = (FileIdentity) obj;
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
	}
}
