package org.jannocessor.extra.processor;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jannocessor.collection.Power;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.collection.transform.api.Transformation;
import org.jannocessor.model.JavaElement;
import org.jannocessor.model.structure.AbstractJavaStructure;
import org.jannocessor.model.structure.JavaAnnotation;
import org.jannocessor.model.structure.JavaClass;
import org.jannocessor.model.structure.JavaEnum;
import org.jannocessor.model.structure.JavaInterface;
import org.jannocessor.model.structure.JavaPackage;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.util.Annotations;
import org.jannocessor.model.util.New;
import org.jannocessor.model.util.Transform;
import org.jannocessor.processor.api.CodeMerger;
import org.jannocessor.processor.api.CodeProcessor;
import org.jannocessor.processor.api.ProcessingContext;

public abstract class AbstractGenerator<T extends JavaElement> implements CodeProcessor<T> {

	private static final String GENERATED_BY = "Easily with JAnnocessor :)";

	private final String destPackage;

	private final boolean inDebugMode;

	private ProcessingContext context;

	private JavaPackage destPkg;

	private PowerList<T> models;

	public AbstractGenerator(String destPackage, boolean inDebugMode) {
		this.destPackage = destPackage;
		this.inDebugMode = inDebugMode;
	}

	public void process(PowerList<T> models, ProcessingContext context) {
		this.models = models;
		this.context = context;
		generateCodeFrom(models, context);
	}

	protected abstract void generateCodeFrom(PowerList<T> models, ProcessingContext context);

	protected JavaPackage getDestinationPackage() {
		if (destPkg == null) {
			destPkg = New.packagee(destPackage);
		}
		return destPkg;
	}

	protected void generate(AbstractJavaStructure structure, CodeMerger merger) {
		if (structure.getParent() == null) {
			addToDestPackage(structure);
		}

		// annotate the generated class as: @Generated("...")
		structure.getMetadata().add(Annotations.generated(GENERATED_BY));

		// finally, generate the source code
		// if inDebugMode was set to true, the JAnnocessor UI will be displayed
		context.generateCode(structure, merger, inDebugMode);
	}

	protected void generate(AbstractJavaStructure structure) {
		generate(structure, null);
	}

	private void addToDestPackage(AbstractJavaStructure structure) {
		switch (structure.getKind()) {
		case INTERFACE:
			getDestinationPackage().getInterfaces().add((JavaInterface) structure);
			break;
		case CLASS:
			getDestinationPackage().getClasses().add((JavaClass) structure);
			break;
		case ENUM:
			getDestinationPackage().getEnums().add((JavaEnum) structure);
			break;
		case ANNOTATION:
			getDestinationPackage().getAnnotations().add((JavaAnnotation) structure);
			break;
		default:
			throw new IllegalStateException("Cannot put element of kind +" + structure.getKind()
					+ " into a package!");
		}
	}

	@SuppressWarnings("unchecked")
	protected <S extends AbstractJavaStructure> PowerList<S> findTypeParts(JavaType type,
			PowerList<S> typeParts) {
		PowerList<S> ss = Power.list();

		for (AbstractJavaStructure typePart : typeParts) {
			String typeName = typePart.getType().getCanonicalName();
			Pattern p = Pattern.compile("^.*\\b(" + typeName + ")\\b.*$");

			Matcher m = p.matcher(type.getCanonicalName());
			while (m.find()) {
				ss.add((S) typePart);
			}
		}

		return ss;
	}

	protected JavaType replaceTypeParts(JavaType type, List<? extends AbstractJavaStructure> typeParts,
			Transformation<String, String> replacement) {
		String fullType = type.getCanonicalName();

		for (AbstractJavaStructure typePart : typeParts) {
			String typeName = typePart.getType().getCanonicalName();
			Pattern p = Pattern.compile("^.*\\b(" + typeName + ")\\b.*$");

			Matcher m = p.matcher(fullType);
			while (m.find()) {
				String simpleTypeName = New.type(m.group(1)).getSimpleName().toString();
				fullType = fullType.substring(0, m.start(1)) + replacement.transform(simpleTypeName)
						+ fullType.substring(m.end(1));
				m = p.matcher(fullType);
			}
		}

		return New.type(fullType);
	}

	protected String getDestPackage() {
		return destPackage;
	}

	protected boolean isInDebugMode() {
		return inDebugMode;
	}

	@SuppressWarnings("unchecked")
	protected JavaType replaceModel(JavaType type, String prefix, String suffix) {
		return replaceTypeParts(type, (List<? extends AbstractJavaStructure>) models,
				Transform.surround(prefix, suffix));
	}

}
