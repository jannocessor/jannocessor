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
