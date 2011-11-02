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

package org.jannocessor.model;

import java.io.Serializable;

import org.jannocessor.annotation.Calculated;

public interface Name extends Serializable {

	@Calculated
	Name copy();

	String[] getParts();

	Name deleteParts(int... positions);

	Name insertPart(int position, String part);

	Name appendPart(String part);

	Name replacePart(int position, String part);

	String getText();

	void assign(String name);

	String getCapitalized();

	String getUncapitalized();

	boolean containsParts(String... parts);

}
