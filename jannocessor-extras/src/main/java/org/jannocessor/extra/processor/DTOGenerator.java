package org.jannocessor.extra.processor;

import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.executable.JavaMethod;
import org.jannocessor.model.structure.AbstractJavaClass;
import org.jannocessor.model.structure.JavaClass;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.util.Classes;
import org.jannocessor.model.util.Methods;
import org.jannocessor.model.util.New;
import org.jannocessor.model.variable.JavaField;
import org.jannocessor.processor.api.ProcessingContext;

public class DTOGenerator extends AbstractGenerator<AbstractJavaClass> {

	public DTOGenerator(String destPackage, boolean inDebugMode) {
		super(destPackage, inDebugMode);
	}

	/**
	 * Generates a DTO class from the specified model.
	 */
	protected void generateCodeFrom(PowerList<AbstractJavaClass> models, ProcessingContext context) {
		for (AbstractJavaClass model : models) {
			JavaClass dto = New.classs(Classes.PUBLIC, model.getName() + "DTO");

			// iterate the model fields (e.g. firstName, lastName... in Person)
			for (JavaField f : model.getFields()) {
				JavaType type = replaceModel(f.getType(), getDestPackage() + ".", "DTO");
				JavaField field = New.field(type, f.getName().toString());

				JavaMethod getter = Methods.getter(field);
				JavaMethod setter = Methods.setter(field);

				dto.getMethods().addAll(getter, setter);

				field.getMetadata().clear();
				dto.getFields().add(field);
			}

			generate(dto);
		}
	}
}
