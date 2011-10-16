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

package org.jannocessor.model.bean;

import org.jannocessor.model.Name;

public class ReadonlyNameBean extends NameBean {

	private static final String ERROR_MSG = "Can't modify a read-only name! Try creating a copy of it.";

	public ReadonlyNameBean(String name) {
		super(name);
	}

	@Override
	public Name deleteParts(int... positions) {
		throw exception();
	}

	@Override
	public Name insertPart(int position, String part) {
		throw exception();
	}

	@Override
	public Name appendPart(String part) {
		throw exception();
	}

	@Override
	public Name replacePart(int position, String part) {
		throw exception();
	}

	@Override
	public void assign(String name) {
		throw exception();
	}

	private RuntimeException exception() {
		return new RuntimeException(ERROR_MSG);
	}

}
