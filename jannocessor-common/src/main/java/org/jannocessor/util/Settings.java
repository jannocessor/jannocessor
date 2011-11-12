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

	public static final String CUSTOM_TEMPLATE = "customize.vm";

	public static final String[] VM_LIBRARY_FILES = { "_global_macros_.vm",
			"annotation_attribute.vm", "annotation.vm", "class.vm",
			"constructor.vm", "enum_constant.vm", "enum.vm",
			"exception_parameter.vm", "executable_body.vm", "field.vm",
			"instance_init.vm", "interface.vm", "local_variable.vm",
			"metadata.vm", "method.vm", "nested_annotation.vm",
			"nested_class.vm", "nested_enum.vm", "nested_interface.vm",
			"package.vm", "parameter.vm", "static_init.vm",
			"type_parameter.vm", "type_variable.vm", "type.vm", "variable.vm" };

}
