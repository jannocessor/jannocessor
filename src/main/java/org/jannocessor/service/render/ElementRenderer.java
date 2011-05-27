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

package org.jannocessor.service.render;

import java.util.Locale;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.stringtemplate.v4.AttributeRenderer;

public class ElementRenderer implements AttributeRenderer {

	private final BeanUtilsBean utils = new BeanUtilsBean();

	@SuppressWarnings("unchecked")
	@Override
	public String toString(Object obj, String arg1, Locale arg2) {
		try {
			Map<Object, Object> properties = utils.describe(obj);
			return properties.toString();
		} catch (Exception e) {
			return String.valueOf(obj);
		}
	}

}
