package org.jannocessor.extra.processor;

import org.jannocessor.collection.Power;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.structure.AbstractJavaClass;
import org.jannocessor.model.structure.JavaInterface;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.util.New;
import org.jannocessor.processor.api.ProcessingContext;

public class DAOGenerator extends AbstractGenerator<AbstractJavaClass> {

	private final String beanPkg;

	public DAOGenerator(String destPackage, String beanPkg, boolean inDebugMode) {
		super(destPackage, inDebugMode);
		this.beanPkg = beanPkg;
	}

	/**
	 * Generates a DAO interface from the specified model.
	 */
	protected void generateCodeFrom(PowerList<AbstractJavaClass> models, ProcessingContext context) {
		for (AbstractJavaClass model : models) {
			JavaType superInterface = New.type("%s.AbstractDAO<%s.%s>", getDestPackage(), beanPkg,
					model.getName());
			PowerList<JavaType> superTypes = Power.list(superInterface);

			JavaInterface dao = New.interfacee(model.getName() + "DAO", superTypes, New.NO_METHODS);
			generate(dao);
		}
	}
}
