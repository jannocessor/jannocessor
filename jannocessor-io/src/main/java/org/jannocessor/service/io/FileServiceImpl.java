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

package org.jannocessor.service.io;

import java.io.File;
import java.net.URI;

import org.apache.commons.io.FileUtils;
import org.drools.io.ResourceFactory;
import org.drools.io.impl.ClassPathResource;
import org.jannocessor.service.api.FileService;

public class FileServiceImpl implements FileService {

	@Override
	public String readClasspathFile(String filename) {
		try {
			ClassPathResource resource = (ClassPathResource) ResourceFactory
					.newClassPathResource(filename);
			URI uri = resource.getURL().toURI();
			return FileUtils.readFileToString(new File(uri));
		} catch (Exception e) {
			throw new RuntimeException("Cannot read file: " + filename);
		}
	}

}
