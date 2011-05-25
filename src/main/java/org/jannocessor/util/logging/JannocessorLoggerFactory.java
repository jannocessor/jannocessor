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

package org.jannocessor.util.logging;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

public class JannocessorLoggerFactory implements ILoggerFactory {

	final static JannocessorLoggerFactory INSTANCE = new JannocessorLoggerFactory();

	private Map<String, Logger> loggerMap = new HashMap<String, Logger>();

	public Logger getLogger(String name) {
		Logger slogger = null;
		// protect against concurrent access of the loggerMap
		synchronized (this) {
			slogger = (Logger) loggerMap.get(name);
			if (slogger == null) {
				slogger = new JannocessorLogger(name);
				loggerMap.put(name, slogger);
			}
		}
		return slogger;
	}
}
