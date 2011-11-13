package example.processor;

import javax.annotation.Resource;

import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.executable.JavaMethod;
import org.jannocessor.model.structure.JavaClass;
import org.jannocessor.model.structure.JavaInterface;
import org.jannocessor.model.util.Methods;
import org.jannocessor.model.util.New;
import org.jannocessor.model.variable.JavaField;
import org.jannocessor.processor.context.CodeProcessor;
import org.jannocessor.processor.context.ProcessingContext;

public class MyFacadeGenerator implements CodeProcessor<JavaInterface> {

	private final boolean debugMode;

	public MyFacadeGenerator(boolean debugMode) {
		this.debugMode = debugMode;
	}

	/**
	 * Processes all interfaces annotated as target for Facade source code
	 * generation.
	 */
	public void process(PowerList<JavaInterface> targets, ProcessingContext context) {
		JavaClass facade = New.classs("Calculator");

		for (JavaInterface target : targets) {
			String delegateName = target.getName().getUncapitalized();
			JavaField delegate = New.field(target.getType(), delegateName);

			delegate.getMetadata().add(New.metadata(Resource.class));
			facade.getFields().add(delegate);

			for (JavaMethod method : target.getMethods()) {
				facade.getMethods().add(Methods.delegator(method, delegate));
			}
		}

		New.packagee("example.calculator.facade").getClasses().add(facade);
		context.generateCode(facade, debugMode);
	}

}
