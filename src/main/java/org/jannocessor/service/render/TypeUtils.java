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

package org.jannocessor.service.render;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jannocessor.domain.JavaElementType;
import org.jannocessor.domain.Name;
import org.jannocessor.service.api.ImportOrganizer;

public class TypeUtils {

	private final ImportOrganizer importOrganizer;
	private List<String> typeImports = new ArrayList<String>();

	public TypeUtils(ImportOrganizer importOrganizer) {
		this.importOrganizer = importOrganizer;
	}

	public String useType(JavaElementType type) {
		return useType(type.getName());
	}

	public String useType(Name name) {
		return useType(name.getText());
	}

	public String useType(String type) {
		String[] imports = importOrganizer.getTypeImports(type);
		String typeUsage = importOrganizer.getTypeUsage(type);

		typeImports.addAll(Arrays.asList(imports));

		return typeUsage;
	}

	public List<String> getTypeImports() {
		return typeImports;
	}

	@Override
	public String toString() {
		return "methods=[useType($type)]";
	}
}
