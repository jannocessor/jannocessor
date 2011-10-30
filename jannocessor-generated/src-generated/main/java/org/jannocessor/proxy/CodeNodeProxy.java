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
import org.jannocessor.model.CodeNode;
import org.jannocessor.model.ParentedElement;
import org.jannocessor.data.CodeNodeData;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import org.jannocessor.model.util.ModelUtils;
import org.jannocessor.collection.api.PowerList;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.jannocessor.util.TypeSpecificStyle;
import org.apache.commons.lang.builder.ToStringBuilder;


@Generated("JAnnocessor-bootstraped")
public class CodeNodeProxy implements CodeNode, ParentedElement {

	private static final long serialVersionUID = 1L;

    private transient CodeNode adapter;

    private CodeNodeData data;

    public CodeNodeProxy(CodeNode adapter, CodeNodeData data) {
        this.adapter = adapter;
        this.data = data;
    }



	private CodeNode parent;

	private boolean hasOriginalParent = true;

	@Override
	public void setParent(CodeNode parent) {
		this.parent = parent;
		hasOriginalParent = false;
	}

	@Override
	public CodeNode getParent() {
		return retrieveParent();
	}

	@SuppressWarnings("unchecked")
	protected <T> T retrieveParent() {
		if (hasOriginalParent) {
			if (parent == null) {
				parent = adapter.getParent();
			}
			return (T) parent;
		} else {
			return (T) parent;
		}
	}

	private void writeObject(ObjectOutputStream out) throws IOException {
		// avoid serialization of the parent
		CodeNode parentBackup = getParent();
		setParent(null);

		// pre-load all data for serialization
		loadAllData();

		out.defaultWriteObject();

		// restore the parent
		setParent(parentBackup);
	}

	private void readObject(ObjectInputStream in) throws IOException,
			ClassNotFoundException {
		in.defaultReadObject();
		// currently doesn't do anything extra
	}

	@Override
    public CodeNode copy() {
        return ModelUtils.copy(this);
    }


	@Override
    public PowerList<CodeNode> getChildren() {
        return ModelUtils.getChildren(this);
    }

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof CodeNode)) {
			return false;
		}

		CodeNode other = (CodeNode) obj;
		return new EqualsBuilder()
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.toHashCode();
	}

	@Override
	public String toString() {
		TypeSpecificStyle style = new TypeSpecificStyle(CodeNode.class);
		ToStringBuilder builder = new ToStringBuilder(this, style);
		appendDescription(builder);
		return builder.toString();
	}

	protected void appendDescription(ToStringBuilder builder) {
	}

	protected void loadAllData() {

		// load all values from the adapter to the data bean
	}

}


