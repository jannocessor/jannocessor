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

package org.jannocessor.proxy;

import javax.annotation.Generated;
import org.jannocessor.proxy.CodeNodeProxy;
import org.jannocessor.model.JavaCodeModel;
import org.jannocessor.data.JavaCodeModelData;
import org.jannocessor.model.util.ModelUtils;
import org.jannocessor.model.code.SourceCode;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.jannocessor.util.TypeSpecificStyle;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.jannocessor.model.util.ToStringUtil;


@Generated("JAnnocessor-bootstraped")
public class JavaCodeModelProxy extends CodeNodeProxy implements JavaCodeModel {

	private static final long serialVersionUID = 1L;

    private transient JavaCodeModel adapter;

    private JavaCodeModelData data;

    public JavaCodeModelProxy(JavaCodeModel adapter, JavaCodeModelData data) {
        super(adapter, data);
        this.adapter = adapter;
        this.data = data;
    }

	private boolean getCodeInitialized = false;

	private boolean getExtraCodeInitialized = false;


	@Override
    public JavaCodeModel copy() {
        return ModelUtils.copy(this);
    }

	@Override
    public SourceCode getCode() {
        if (!getCodeInitialized) {
			if (adapter == null) {
				throw new IllegalStateException("Invalid model copy!");
			}
            data.setCode(adapter.getCode());
			getCodeInitialized = true;
        }

        return data.getCode();
    }

	@Override
    public SourceCode getExtraCode() {
        if (!getExtraCodeInitialized) {
			if (adapter == null) {
				throw new IllegalStateException("Invalid model copy!");
			}
            data.setExtraCode(adapter.getExtraCode());
			getExtraCodeInitialized = true;
        }

        return data.getExtraCode();
    }

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof JavaCodeModel)) {
			return false;
		}

		JavaCodeModel other = (JavaCodeModel) obj;
		return new EqualsBuilder()
				.appendSuper(super.equals(other))
				.append(this.getCode(), other.getCode())
				.append(this.getExtraCode(), other.getExtraCode())
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(this.getCode())
				.append(this.getExtraCode())
				.toHashCode();
	}

	@Override
	public String toString() {
		TypeSpecificStyle style = new TypeSpecificStyle(JavaCodeModel.class);
		ToStringBuilder builder = new ToStringBuilder(this, style);
		appendDescription(builder);
		return builder.toString();
	}

	@Override
	protected void appendDescription(ToStringBuilder builder) {
        super.appendDescription(builder);
        builder.append("code", ToStringUtil.describe(this.getCode()));
        builder.append("extraCode", ToStringUtil.describe(this.getExtraCode()));
	}

	@Override
	protected void loadAllData() {
		super.loadAllData();

		// load all values from the adapter to the data bean
		this.getCode();
		this.getExtraCode();
	}

}


