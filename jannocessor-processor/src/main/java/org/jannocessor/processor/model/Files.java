/**
 * Copyright 2011 Nikolche Mihajlovski
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

package org.jannocessor.processor.model;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Files {

	private Map<FileIdentity, File> files = new HashMap<FileIdentity, File>();

	public File file(String packageName, String fileName, String content) {
		FileIdentity fileId = new FileIdentity(packageName, fileName);

		File file = files.get(fileId);
		if (file == null) {
			file = new File(packageName, fileName, content);
			files.put(fileId, file);
		}

		return file;
	}

	public Collection<File> getAll() {
		return Collections.unmodifiableCollection(files.values());
	}

	private static class FileIdentity {

		private String packageName;

		private String fileName;

		public FileIdentity(String packageName, String fileName) {
			this.packageName = packageName;
			this.fileName = fileName;
		}

		@Override
		public String toString() {
			return "FileIdentity [packageName=" + packageName + ", fileName="
					+ fileName + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((fileName == null) ? 0 : fileName.hashCode());
			result = prime * result
					+ ((packageName == null) ? 0 : packageName.hashCode());
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
			if (fileName == null) {
				if (other.fileName != null)
					return false;
			} else if (!fileName.equals(other.fileName))
				return false;
			if (packageName == null) {
				if (other.packageName != null)
					return false;
			} else if (!packageName.equals(other.packageName))
				return false;
			return true;
		}

	}

}
