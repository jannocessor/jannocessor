package org.jannocessor.config;

import org.jannocessor.extra.annotation.GenerateBean;
import org.jannocessor.extra.annotation.GenerateBuilder;
import org.jannocessor.extra.annotation.GenerateDAO;
import org.jannocessor.extra.annotation.GenerateDTO;
import org.jannocessor.extra.annotation.GenerateFacade;
import org.jannocessor.extra.annotation.GenerateMapper;
import org.jannocessor.extra.annotation.GenerateShowcase;
import org.jannocessor.extra.processor.BeanGenerator;
import org.jannocessor.extra.processor.BuilderGenerator;
import org.jannocessor.extra.processor.DAOGenerator;
import org.jannocessor.extra.processor.DAOImplGenerator;
import org.jannocessor.extra.processor.DTOGenerator;
import org.jannocessor.extra.processor.FacadeGenerator;
import org.jannocessor.extra.processor.MapperGenerator;
import org.jannocessor.extra.processor.ShowcaseGenerator;
import org.jannocessor.model.structure.AbstractJavaClass;
import org.jannocessor.model.structure.JavaInterface;
import org.jannocessor.processor.annotation.Annotated;
import org.jannocessor.processor.annotation.Types;
import org.jannocessor.processor.api.CodeProcessor;

/**
 * This is a configuration class and it must have the name "org.jannocessor.config.Processors" by convention.
 * 
 * This is the entry point of the annotation processor and contains a list of code processors, as well as their
 * target source code elements, defined by annotation and kind.
 */
public class Processors {

	private static final boolean DEBUG_MODE = true;

	private static final String PKG_BEAN = "example.bean";
	private static final String PKG_BUILDER = "example.builder";
	private static final String PKG_DAO = "example.dao";
	private static final String PKG_DAO_IMPL = "example.dao.impl";
	private static final String PKG_DTO = "example.dto";
	private static final String PKG_MAPPER = "example.mapper";
	private static final String PKG_FACADE = "example.facade";

	@Annotated(GenerateBean.class)
	@Types(AbstractJavaClass.class)
	public BeanGenerator generateBean() {
		return new BeanGenerator(PKG_BEAN, DEBUG_MODE);
	}

	@Annotated(GenerateBuilder.class)
	@Types(AbstractJavaClass.class)
	public BuilderGenerator generateBuilder() {
		return new BuilderGenerator(PKG_BUILDER, PKG_BEAN, DEBUG_MODE);
	}

	@Annotated(GenerateDAO.class)
	@Types(AbstractJavaClass.class)
	public DAOGenerator generateDAO() {
		return new DAOGenerator(PKG_DAO, PKG_BEAN, DEBUG_MODE);
	}

	@Annotated(GenerateDAO.class)
	@Types(AbstractJavaClass.class)
	public DAOImplGenerator generateDAOImpl() {
		return new DAOImplGenerator(PKG_DAO_IMPL, PKG_DAO, PKG_BEAN, DEBUG_MODE);
	}

	@Annotated(GenerateDTO.class)
	@Types(AbstractJavaClass.class)
	public DTOGenerator generateDTO() {
		return new DTOGenerator(PKG_DTO, DEBUG_MODE);
	}

	@Annotated(GenerateMapper.class)
	@Types(AbstractJavaClass.class)
	public MapperGenerator generateMapper() {
		return new MapperGenerator(PKG_MAPPER, PKG_BEAN, PKG_DTO, "", "DTO", DEBUG_MODE);
	}

	@Annotated(GenerateFacade.class)
	@Types(JavaInterface.class)
	public CodeProcessor<JavaInterface> generateFacade() {
		return new FacadeGenerator(PKG_FACADE, "Calculator", DEBUG_MODE);
	}

	@Annotated(GenerateShowcase.class)
	@Types(AbstractJavaClass.class)
	public ShowcaseGenerator experiment() {
		return new ShowcaseGenerator(DEBUG_MODE);
	}

}
