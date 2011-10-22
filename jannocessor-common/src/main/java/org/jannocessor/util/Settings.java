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

package org.jannocessor.util;

public interface Settings {

	public static final String GENERAL_PROPERTIES = "jannocessor";

	public static final String ANNOTATIONS_PROPERTIES = "annotations";

	public static final String PROCESSORS_PROPERTIES = "processors";

	public static final String KNOWLEDGE_BASE = "knolwedge_base.bin";

	public static final String RULES_TEMPLATE_NAME = "internal/templates/rules.vm";

	public static final String OPTION_PROFILE = "profile";

	public static final String OPTION_TEMPLATES_PATH = "templates.path";

	public static final String PROCESSORS_CLASSNAME = "org.jannocessor.config.Processors";

}
