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

package org.jannocessor.util.logging;

import javax.annotation.processing.Messager;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.Element;
import javax.tools.Diagnostic.Kind;

import org.slf4j.helpers.MessageFormatter;

public class ConsoleMessager implements Messager {

	@Override
	public void printMessage(Kind kind, CharSequence msg) {
		message("{} - {}", kind, msg);
	}

	@Override
	public void printMessage(Kind kind, CharSequence msg, Element e) {
		message("{} - {}: {}", kind, msg, e);
	}

	@Override
	public void printMessage(Kind kind, CharSequence msg, Element e,
			AnnotationMirror a) {
		message("{} - {}: {}, {}", kind, msg, e, a);
	}

	@Override
	public void printMessage(Kind kind, CharSequence msg, Element e,
			AnnotationMirror a, AnnotationValue v) {
		message("{} - {}: {}, {}, {}", kind, msg, e, a, v);
	}

	private void message(String format, Object... args) {
		String msg = MessageFormatter.arrayFormat(format, args).getMessage();
		System.out.println(msg);
	}

}
