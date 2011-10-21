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

package org.jannocessor.data;

import javax.annotation.Generated;
import org.jannocessor.data.JavaTypeData;
import org.jannocessor.model.type.JavaExecutableType;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.type.JavaDeclaredType;
import org.jannocessor.model.type.JavaTypeVariable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.jannocessor.util.TypeSpecificStyle;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.jannocessor.model.util.ToStringUtil;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


@Generated("JAnnocessor-bootstraped")
public class JavaExecutableTypeData extends JavaTypeData implements JavaExecutableType {

    private PowerList<JavaType> parameterTypes;

    private JavaType returnType;

    private PowerList<JavaDeclaredType> thrownTypes;

    private PowerList<JavaTypeVariable> typeVariables;


    public PowerList<JavaType> getParameterTypes() {
        return this.parameterTypes;
    }

    public void setParameterTypes(PowerList<JavaType> value) {
        this.parameterTypes = value;
    }

    public JavaType getReturnType() {
        return this.returnType;
    }

    public void setReturnType(JavaType value) {
        this.returnType = value;
    }

    public PowerList<JavaDeclaredType> getThrownTypes() {
        return this.thrownTypes;
    }

    public void setThrownTypes(PowerList<JavaDeclaredType> value) {
        this.thrownTypes = value;
    }

    public PowerList<JavaTypeVariable> getTypeVariables() {
        return this.typeVariables;
    }

    public void setTypeVariables(PowerList<JavaTypeVariable> value) {
        this.typeVariables = value;
    }

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof JavaExecutableType)) {
			return false;
		}

		JavaExecutableType other = (JavaExecutableType) obj;
		return new EqualsBuilder()
				.appendSuper(super.equals(other))
				.append(this.getParameterTypes(), other.getParameterTypes())
				.append(this.getReturnType(), other.getReturnType())
				.append(this.getThrownTypes(), other.getThrownTypes())
				.append(this.getTypeVariables(), other.getTypeVariables())
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(this.getParameterTypes())
				.append(this.getReturnType())
				.append(this.getThrownTypes())
				.append(this.getTypeVariables())
				.toHashCode();
	}

	@Override
	public String toString() {
		TypeSpecificStyle style = new TypeSpecificStyle(JavaExecutableType.class);
		ToStringBuilder builder = new ToStringBuilder(this, style);
		appendDescription(builder);
		return builder.toString();
	}

	@Override
	protected void appendDescription(ToStringBuilder builder) {
        super.appendDescription(builder);
        builder.append("parameterTypes", ToStringUtil.describe(this.getParameterTypes()));
        builder.append("returnType", ToStringUtil.describe(this.getReturnType()));
        builder.append("thrownTypes", ToStringUtil.describe(this.getThrownTypes()));
        builder.append("typeVariables", ToStringUtil.describe(this.getTypeVariables()));
	}

	private void writeObject(ObjectOutputStream out) throws IOException {
		out.defaultWriteObject();
	}

	private void readObject(ObjectInputStream in) throws IOException,
			ClassNotFoundException {
		in.defaultReadObject();
	}

}


