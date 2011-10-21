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
import javax.tools.Diagnostic;

import org.slf4j.helpers.MarkerIgnoringBase;
import org.slf4j.helpers.MessageFormatter;

public class JannocessorLogger extends MarkerIgnoringBase {

	private static final long serialVersionUID = 4447256230980716124L;

	public static Messager messager = new ConsoleMessager();

	private final String name;

	JannocessorLogger(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public boolean isTraceEnabled() {
		return true;
	}

	@Override
	public void trace(String msg) {
		messager.printMessage(Diagnostic.Kind.OTHER, msg);
	}

	@Override
	public void trace(String format, Object arg) {
		trace(formated(format, arg));
	}

	@Override
	public void trace(String format, Object arg1, Object arg2) {
		trace(formated(format, arg1, arg2));
	}

	@Override
	public void trace(String format, Object[] argArray) {
		trace(formated(format, argArray));
	}

	@Override
	public void trace(String msg, Throwable t) {
		trace(reportError(msg, t));
	}

	@Override
	public boolean isDebugEnabled() {
		return true;
	}

	@Override
	public void debug(String msg) {
		messager.printMessage(Diagnostic.Kind.OTHER, msg);
	}

	@Override
	public void debug(String format, Object arg) {
		debug(formated(format, arg));
	}

	@Override
	public void debug(String format, Object arg1, Object arg2) {
		debug(formated(format, arg1, arg2));
	}

	@Override
	public void debug(String format, Object[] argArray) {
		debug(formated(format, argArray));
	}

	@Override
	public void debug(String msg, Throwable t) {
		debug(reportError(msg, t));
	}

	@Override
	public boolean isInfoEnabled() {
		return true;
	}

	@Override
	public void info(String msg) {
		messager.printMessage(Diagnostic.Kind.NOTE, msg);
	}

	@Override
	public void info(String format, Object arg) {
		info(formated(format, arg));
	}

	@Override
	public void info(String format, Object arg1, Object arg2) {
		info(formated(format, arg1, arg2));
	}

	@Override
	public void info(String format, Object[] argArray) {
		info(formated(format, argArray));
	}

	@Override
	public void info(String msg, Throwable t) {
		info(reportError(msg, t));
	}

	@Override
	public boolean isWarnEnabled() {
		return true;
	}

	@Override
	public void warn(String msg) {
		messager.printMessage(Diagnostic.Kind.WARNING, msg);
	}

	@Override
	public void warn(String format, Object arg) {
		warn(formated(format, arg));
	}

	@Override
	public void warn(String format, Object[] argArray) {
		warn(formated(format, argArray));
	}

	@Override
	public void warn(String format, Object arg1, Object arg2) {
		warn(formated(format, arg1, arg2));
	}

	@Override
	public void warn(String msg, Throwable t) {
		warn(reportError(msg, t));
	}

	@Override
	public boolean isErrorEnabled() {
		return true;
	}

	@Override
	public void error(String msg) {
		messager.printMessage(Diagnostic.Kind.ERROR, msg);
	}

	@Override
	public void error(String format, Object arg) {
		error(formated(format, arg));
	}

	@Override
	public void error(String format, Object arg1, Object arg2) {
		error(formated(format, arg1, arg2));
	}

	@Override
	public void error(String format, Object[] argArray) {
		error(formated(format, argArray));
	}

	@Override
	public void error(String msg, Throwable t) {
		error(reportError(msg, t));
	}

	private String formated(String format, Object... args) {
		return MessageFormatter.arrayFormat(format, args).getMessage();
	}

	private String reportError(String msg, Throwable t) {
		t.printStackTrace();
		return formated("Exception: {}", t.getMessage()); // FIXME improve
	}

}
