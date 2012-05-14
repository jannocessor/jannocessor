package org.jannocessor.extra.processor;

import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.structure.AbstractJavaClass;
import org.jannocessor.model.structure.JavaClass;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.util.Classes;
import org.jannocessor.model.util.Fields;
import org.jannocessor.model.util.Methods;
import org.jannocessor.model.util.New;
import org.jannocessor.model.variable.JavaField;
import org.jannocessor.processor.api.ProcessingContext;

public class BeanGenerator extends AbstractGenerator<AbstractJavaClass> {

	public BeanGenerator(String destPackage, boolean inDebugMode) {
		super(destPackage, inDebugMode);
	}

	/**
	 * Generates a JavaBean class from the specified model.
	 */
	protected void generateCodeFrom(PowerList<AbstractJavaClass> models, ProcessingContext context) {
		for (AbstractJavaClass model : models) {
			JavaClass bean = New.classs(Classes.PUBLIC, model.getName().toString());

			// iterate the model fields (e.g. firstName, lastName... in Person)
			for (JavaField property : model.getFields()) {
				// construct the field
				JavaType type = replaceModel(property.getType(), getDestPackage() + ".", "");
				JavaField field = New.field(Fields.PRIVATE, type, property.getName().toString());

				// add getter and setter
				bean.getMethods().addAll(Methods.getter(field), Methods.setter(field));

				// remove the field annotations
				field.getMetadata().clear();

				// add the fields to the bean
				bean.getFields().add(field);
			}

			// generate the JavaBean class (e.g. Person)
			generate(bean);
		}
	}
}
