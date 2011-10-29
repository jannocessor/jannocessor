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

package org.jannocessor.adapter.structure;

import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

import org.jannocessor.collection.Power;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.collection.filter.api.Condition;
import org.jannocessor.collection.filter.api.Criteria;
import org.jannocessor.model.CodeNode;
import org.jannocessor.model.bean.modifier.EnumModifiersBean;
import org.jannocessor.model.executable.JavaMethod;
import org.jannocessor.model.modifier.EnumModifiers;
import org.jannocessor.model.modifier.MethodModifiers;
import org.jannocessor.model.modifier.value.EnumModifierValue;
import org.jannocessor.model.structure.JavaEnum;
import org.jannocessor.model.util.Methods;
import org.jannocessor.model.util.ModelUtils;
import org.jannocessor.model.variable.JavaParameter;

public final class JavaEnumAdapter extends AbstractJavaEnumAdapter implements
		JavaEnum {

	private static final long serialVersionUID = 7553112665612022952L;

	private static final Criteria<JavaMethod> IMPLICIT_METHODS;

	@SuppressWarnings("unused")
	private final TypeElement tenum;

	static {
		IMPLICIT_METHODS = Power.criteria(new Condition<JavaMethod>() {
			@Override
			public boolean satisfies(JavaMethod method) {
				String name = method.getName().getText();
				PowerList<JavaParameter> params = method.getParameters();
				MethodModifiers modifiers = method.getModifiers();

				boolean isImplicitValues = name.equals("values")
						&& modifiers.contains(Methods.STATIC)
						&& params.size() == 0;

				boolean isImplicitValueOf = name.equals("valueOf")
						&& modifiers.contains(Methods.STATIC)
						&& params.size() == 1
						&& params.get(0).getType().getSimpleName().getText()
								.equals("String");

				return isImplicitValues || isImplicitValueOf;
			}
		});
	}

	public JavaEnumAdapter(TypeElement tenum, Elements elementUtils,
			Types typeUtils) {
		super(tenum, elementUtils, typeUtils);

		this.tenum = tenum;
	}

	@Override
	public EnumModifiers getModifiers() {
		return new EnumModifiersBean(getModifierValues(EnumModifierValue.class,
				"FINAL"));
	}

	@Override
	public PowerList<JavaMethod> getMethods() {
		PowerList<JavaMethod> methods = super.getMethods();

		methods.remove(IMPLICIT_METHODS);

		return methods;
	}

	@Override
	protected Class<? extends JavaEnum> getAdaptedInterface() {
		return JavaEnum.class;
	}

	@Override
	public PowerList<CodeNode> getChildren() {
		return ModelUtils.getChildren(this);
	}

}
