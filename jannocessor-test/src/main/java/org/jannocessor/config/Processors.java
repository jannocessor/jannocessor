/**
 * Copyright 2011 Nikolche Mihajlovski
 *
 * This file is part of JAnnocessor.
 *
 * JAnnocessor is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JAnnocessor is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with JAnnocessor.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.jannocessor.config;

import org.jannocessor.bootstrapped.annotation.AnotherAnnotation;
import org.jannocessor.bootstrapped.annotation.BeanModel;
import org.jannocessor.bootstrapped.annotation.MyAnnotation;
import org.jannocessor.experiment.processor.ExperimentProcessor;
import org.jannocessor.experiment.processor.MirrorProcessor;
import org.jannocessor.experiment.processor.MyProcessor;
import org.jannocessor.extra.annotation.BuilderModel;
import org.jannocessor.extra.annotation.DtoModel;
import org.jannocessor.extra.annotation.GenerateFacade;
import org.jannocessor.extra.processor.BuilderGenerator;
import org.jannocessor.extra.processor.DtoGenerator;
import org.jannocessor.extra.processor.FacadeGenerator;
import org.jannocessor.extra.processor.MapperGenerator;
import org.jannocessor.model.JavaElement;
import org.jannocessor.model.structure.JavaAnnotation;
import org.jannocessor.model.structure.JavaClass;
import org.jannocessor.model.structure.JavaEnum;
import org.jannocessor.model.structure.JavaInterface;
import org.jannocessor.processor.annotation.Annotated;
import org.jannocessor.processor.annotation.Types;
import org.jannocessor.processor.api.CodeProcessor;

public class Processors {

	private static final boolean DEBUG_MODE = false;

	@Annotated(BeanModel.class)
	@Types(JavaClass.class)
	public CodeProcessor<? extends JavaElement> experimentProcessor() {
		return new ExperimentProcessor(DEBUG_MODE);
	}

	@Annotated({ BeanModel.class, AnotherAnnotation.class })
	@Types({ JavaInterface.class, JavaEnum.class, JavaAnnotation.class })
	public CodeProcessor<? extends JavaElement> mirrorProcessor() {
		return new MirrorProcessor(DEBUG_MODE);
	}

	@Annotated(MyAnnotation.class)
	@Types(JavaClass.class)
	public CodeProcessor<? extends JavaElement> processMyAnnotatedClasses() {
		return new MyProcessor(DEBUG_MODE);
	}

}
