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

package org.jannocessor.model.bean.modifier;

import java.util.Arrays;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.jannocessor.model.modifier.AnnotationModifiers;
import org.jannocessor.model.modifier.value.AnnotationModifierValue;
import org.jannocessor.util.TypeSpecificStyle;

public class AnnotationModifiersBean implements AnnotationModifiers {

	private AnnotationModifierValue[] values;

	public AnnotationModifiersBean(AnnotationModifierValue[] values) {
		this.values = values;
	}

	@Override
	public AnnotationModifierValue[] getValues() {
		return values;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof AnnotationModifiers)) {
			return false;
		}

		AnnotationModifiers other = (AnnotationModifiers) obj;
		EqualsBuilder builder = new EqualsBuilder();
		return builder.append(getValues(), other.getValues()).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getValues()).toHashCode();
	}

	@Override
	public String toString() {
		TypeSpecificStyle style = new TypeSpecificStyle(AnnotationModifiers.class);
		return new ToStringBuilder(this, style).append("values",
				Arrays.toString(getValues())).toString();
	}

}
