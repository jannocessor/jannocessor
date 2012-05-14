package org.jannocessor.extra.processor;

import java.util.List;

import org.jannocessor.collection.Power;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.structure.AbstractJavaClass;
import org.jannocessor.model.structure.JavaClass;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.util.Classes;
import org.jannocessor.model.util.New;
import org.jannocessor.processor.api.ProcessingContext;

public class DAOImplGenerator extends AbstractGenerator<AbstractJavaClass> {

	private final String daoPackage;
	private final String beanPkg;

	public DAOImplGenerator(String destPackage, String daoPackage, String beanPkg, boolean inDebugMode) {
		super(destPackage, inDebugMode);
		this.daoPackage = daoPackage;
		this.beanPkg = beanPkg;
	}

	/**
	 * Generates a DAO implementation class from the specified model.
	 */
	protected void generateCodeFrom(PowerList<AbstractJavaClass> models, ProcessingContext context) {
		for (AbstractJavaClass model : models) {
			JavaType superclass = New.type("%s.AbstractDAOImpl<%s.%s>", getDestPackage(), beanPkg,
					model.getName());
			JavaType daoInterface = New.type("%s.%sDAO", daoPackage, model.getName());
			List<JavaType> interfaces = Power.list(daoInterface);

			JavaClass dao = New.classs(Classes.PUBLIC, model.getName() + "DAOImpl", superclass, interfaces);
			generate(dao);
		}
	}
}
