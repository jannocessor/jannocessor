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

package org.jannocessor.proxy;

import javax.annotation.Generated;
import org.jannocessor.proxy.AbstractJavaStructureProxy;
import org.jannocessor.model.structure.AbstractJavaAnnotation;
import org.jannocessor.data.AbstractJavaAnnotationData;
import org.jannocessor.model.util.ModelUtils;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.structure.JavaAnnotationAttribute;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.jannocessor.util.TypeSpecificStyle;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.jannocessor.model.util.ToStringUtil;


@Generated("JAnnocessor-bootstraped")
public class AbstractJavaAnnotationProxy extends AbstractJavaStructureProxy implements AbstractJavaAnnotation {

	private static final long serialVersionUID = 1L;

    private transient AbstractJavaAnnotation adapter;

    private AbstractJavaAnnotationData data;

    public AbstractJavaAnnotationProxy(AbstractJavaAnnotation adapter, AbstractJavaAnnotationData data) {
        super(adapter, data);
        this.adapter = adapter;
        this.data = data;
    }

	private boolean getAttributesInitialized = false;


	@Override
    public AbstractJavaAnnotation copy() {
        return ModelUtils.copy(this);
    }

	@Override
    public PowerList<JavaAnnotationAttribute> getAttributes() {
        if (!getAttributesInitialized) {
			if (adapter == null) {
				throw new IllegalStateException("Invalid model copy!");
			}
            data.setAttributes(ModelUtils.parentedList(adapter.getAttributes(), this));
			getAttributesInitialized = true;
        }

        return data.getAttributes();
    }

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof AbstractJavaAnnotation)) {
			return false;
		}

		AbstractJavaAnnotation other = (AbstractJavaAnnotation) obj;
		return new EqualsBuilder()
				.appendSuper(super.equals(other))
				.append(this.getAttributes(), other.getAttributes())
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(this.getAttributes())
				.toHashCode();
	}

	@Override
	public String toString() {
		TypeSpecificStyle style = new TypeSpecificStyle(AbstractJavaAnnotation.class);
		ToStringBuilder builder = new ToStringBuilder(this, style);
		appendDescription(builder);
		return builder.toString();
	}

	@Override
	protected void appendDescription(ToStringBuilder builder) {
        super.appendDescription(builder);
        builder.append("attributes", ToStringUtil.describe(this.getAttributes()));
	}

	@Override
	protected void loadAllData() {
		super.loadAllData();

		// load all values from the adapter to the data bean
		this.getAttributes();
	}

}


