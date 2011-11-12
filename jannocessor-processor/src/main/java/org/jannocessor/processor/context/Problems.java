/**
 * Copyright 2011 Nikolche Mihajlovski
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

package org.jannocessor.processor.context;

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
