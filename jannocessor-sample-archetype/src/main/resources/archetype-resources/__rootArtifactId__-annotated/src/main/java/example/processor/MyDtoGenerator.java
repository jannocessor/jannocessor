package example.processor;

import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.executable.JavaMethod;
import org.jannocessor.model.structure.JavaClass;
import org.jannocessor.model.util.Annotations;
import org.jannocessor.model.util.Classes;
import org.jannocessor.model.util.Methods;
import org.jannocessor.model.util.New;
import org.jannocessor.model.variable.JavaField;
import org.jannocessor.processor.context.CodeProcessor;
import org.jannocessor.processor.context.ProcessingContext;

public class MyDtoGenerator implements CodeProcessor<JavaClass> {

	private final boolean inDebugMode;

	public MyDtoGenerator(boolean inDebugMode) {
		this.inDebugMode = inDebugMode;
	}

	/**
	 * Processes a list of annotated domain model classes (e.g. Person),
	 * generating a Domain Transfer Object (DTO) class for each of them.
	 */
	public void process(PowerList<JavaClass> classes, ProcessingContext context) {
		for (JavaClass model : classes) {
			JavaClass dto = New.classs(Classes.PUBLIC, model.getName() + "Dto");

			// iterate the model fields (e.g. firstName, lastName... in Person)
			for (JavaField field : model.getFields()) {
				JavaMethod getter = Methods.getter(field);
				JavaMethod setter = Methods.setter(field);

				dto.getMethods().addAll(getter, setter);

				field.getMetadata().clear();
				dto.getFields().add(field);
			}

			dto.getMetadata().add(Annotations.generated("JAnnocessor"));

			New.packagee(model.getParent().getName() + ".dto").getClasses().add(dto);
			context.generateCode(dto, inDebugMode);
		}
	}
}
