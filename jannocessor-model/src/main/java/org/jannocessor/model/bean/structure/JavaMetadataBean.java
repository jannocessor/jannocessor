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

package org.jannocessor.model.bean.structure;

import java.util.Map;

import org.jannocessor.collection.Power;
import org.jannocessor.data.JavaMetadataData;
import org.jannocessor.model.structure.JavaMetadata;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.util.New;

public class JavaMetadataBean extends JavaMetadataData implements JavaMetadata {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8788201421847960314L;

	public JavaMetadataBean(JavaType annotation,
			Map<String, ? extends Object> attributes) {
		this.setAnnotation(annotation);
		this.setValues(Power.map(attributes));

		// FIXME: not implemented
		this.setValuesWithDefaults(Power.map(String.class, Object.class));

		this.setCode(New.code(JavaMetadata.class));
	}

}
