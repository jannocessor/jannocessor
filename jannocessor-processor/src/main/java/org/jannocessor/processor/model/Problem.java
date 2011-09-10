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

package org.jannocessor.processor.model;

import org.jannocessor.model.JavaElement;


public class Problem {

	private final JavaElement element;

	private final String message;

	public Problem(JavaElement element, String message) {
		this.element = element;
		this.message = message;
	}

	public JavaElement getElement() {
		return element;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "Problem [element=" + element + ", message=" + message + "]";
	}

}
