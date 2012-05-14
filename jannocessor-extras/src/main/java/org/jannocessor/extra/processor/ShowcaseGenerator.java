package org.jannocessor.extra.processor;

import javax.annotation.Generated;

import org.jannocessor.collection.Power;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.extra.merge.MarkedCodeSegmentMerger;
import org.jannocessor.model.executable.JavaConstructor;
import org.jannocessor.model.executable.JavaMethod;
import org.jannocessor.model.structure.JavaClass;
import org.jannocessor.model.structure.JavaMetadata;
import org.jannocessor.model.structure.JavaNestedEnum;
import org.jannocessor.model.util.Constructors;
import org.jannocessor.model.util.Fields;
import org.jannocessor.model.util.Methods;
import org.jannocessor.model.util.New;
import org.jannocessor.model.variable.JavaEnumConstant;
import org.jannocessor.model.variable.JavaField;
import org.jannocessor.model.variable.JavaParameter;
import org.jannocessor.processor.api.CodeMerger;
import org.jannocessor.processor.api.ProcessingContext;

@SuppressWarnings("all")
public class ShowcaseGenerator extends AbstractGenerator<JavaClass> {

	public ShowcaseGenerator(boolean debugMode) {
		super("org.jannocessor.showcase", debugMode);
	}

	@Override
	protected void generateCodeFrom(PowerList<JavaClass> models, ProcessingContext context) {
		JavaClass showcase = New.classs("JAnnocessor");
		showcase.getName().appendPart("Showcase");

		JavaMetadata meta1 = New.metadata(SuppressWarnings.class, "all");
		showcase.getMetadata().add(meta1);

		JavaMethod method1 = New.method(Methods.PUBLIC, String.class, "cool");
		method1.getBody().setHardcoded("return \"COOL!\";");
		showcase.getMethods().add(method1);

		showcase.getInstanceInits().add(New.instanceInit(New.body("// init")));
		showcase.getStaticInits().add(New.staticInit(New.body("// static init")));

		JavaField x = New.field(Fields.PRIVATE, boolean.class, "x", New.literal(true));
		JavaMetadata meta2 = New.metadata(SuppressWarnings.class, "unused");
		x.getMetadata().add(meta2);

		showcase.getFields().add(x);

		JavaEnumConstant value1 = New.enumConstant("A");
		value1.getValues().addAll(New.expression("\"foo\""), New.expression("11"));

		JavaEnumConstant value2 = New.enumConstant("B", New.literal("bar"), New.literal(13));

		JavaNestedEnum enum1 = New.nestedEnum("MyEnum", Power.list(value1, value2));

		JavaParameter param1 = New.parameter(String.class, "a");
		JavaParameter param2 = New.parameter(int.class, "b");
		JavaConstructor constr1 = New.constructor(Constructors.PRIVATE, param1, param2);
		enum1.getConstructors().add(constr1);

		showcase.getNestedEnums().add(enum1);

		JavaConstructor constr2 = New.constructor(New.parameter(String.class, "param1"));
		showcase.getConstructors().add(constr2);

		showcase.getExtraCode().assign(New.customization());

		CodeMerger merger = new MarkedCodeSegmentMerger();
		generate(showcase, merger);
	}

}
