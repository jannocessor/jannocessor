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

package org.jannocessor.model.bean.structure;

import java.util.Map;

import org.jannocessor.collection.Power;
import org.jannocessor.data.JavaMetadataData;
import org.jannocessor.model.structure.JavaMetadata;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.util.New;

public class JavaMetadataBean extends JavaMetadataData implements JavaMetadata {

	private static final long serialVersionUID = 8788201421847960314L;

	public JavaMetadataBean(JavaType annotation, Map<String, ? extends Object> attributes) {
		this.setAnnotation(annotation);
		this.setValues(Power.map(attributes));

		this.setCode(New.code(JavaMetadata.class));
	}

}
