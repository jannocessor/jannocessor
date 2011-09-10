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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.jannocessor.model.JavaElement;

public class Problems {

	private List<Problem> errors = new ArrayList<Problem>();

	private List<Problem> warnings = new ArrayList<Problem>();

	private void addError(JavaElement element, String message, Object... args) {
		String msg = String.format(message, args);
		Problem error = new Problem(element, msg);
		errors.add(error);
	}

	private void addWarning(JavaElement element, String message, Object... args) {
		String msg = String.format(message, args);
		Problem warning = new Problem(element, msg);
		warnings.add(warning);
	}

	public List<Problem> getErrors() {
		return Collections.unmodifiableList(errors);
	}

	public List<Problem> getWarnings() {
		return Collections.unmodifiableList(warnings);
	}

	public void error(JavaElement element, String message) {
		addError(element, message);
	}

	public void error(JavaElement element, String message, Object arg1) {
		addError(element, message, arg1);
	}

	public void error(JavaElement element, String message, Object arg1,
			Object arg2) {
		addError(element, message, arg1, arg2);
	}

	public void error(JavaElement element, String message, Object arg1,
			Object arg2, Object arg3) {
		addError(element, message, arg1, arg2, arg3);
	}

	public void error(JavaElement element, String message, Object arg1,
			Object arg2, Object arg3, Object arg4) {
		addError(element, message, arg1, arg2, arg3, arg4);
	}

	public void error(JavaElement element, String message, Object arg1,
			Object arg2, Object arg3, Object arg4, Object arg5) {
		addError(element, message, arg1, arg2, arg3, arg4, arg5);
	}

	public void warning(JavaElement element, String message) {
		addWarning(element, message);
	}

	public void warning(JavaElement element, String message, Object arg1) {
		addWarning(element, message, arg1);
	}

	public void warning(JavaElement element, String message, Object arg1,
			Object arg2) {
		addWarning(element, message, arg1, arg2);
	}

	public void warning(JavaElement element, String message, Object arg1,
			Object arg2, Object arg3) {
		addWarning(element, message, arg1, arg2, arg3);
	}

	public void warning(JavaElement element, String message, Object arg1,
			Object arg2, Object arg3, Object arg4) {
		addWarning(element, message, arg1, arg2, arg3, arg4);
	}

	public void warning(JavaElement element, String message, Object arg1,
			Object arg2, Object arg3, Object arg4, Object arg5) {
		addWarning(element, message, arg1, arg2, arg3, arg4, arg5);
	}

}
