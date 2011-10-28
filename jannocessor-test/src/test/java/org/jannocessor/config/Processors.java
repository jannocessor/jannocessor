/**
 * Copyright 2011 Nikolche Mihajlovski
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jannocessor.config;

import org.jannocessor.annotation.Annotated;
import org.jannocessor.annotation.Types;
import org.jannocessor.bootstrapped.annotation.AnotherAnnotation;
import org.jannocessor.bootstrapped.annotation.BeanModel;
import org.jannocessor.bootstrapped.annotation.MyAnnotation;
import org.jannocessor.experiment.processor.ExperimentProcessor;
import org.jannocessor.experiment.processor.MirrorProcessor;
import org.jannocessor.experiment.processor.MyProcessor;
import org.jannocessor.model.structure.JavaAnnotation;
import org.jannocessor.model.structure.JavaClass;
import org.jannocessor.model.structure.JavaEnum;
import org.jannocessor.model.structure.JavaInterface;

public class Processors {

	@Annotated(BeanModel.class)
	@Types(JavaClass.class)
	public ExperimentProcessor experimentProcessor() {
		return new ExperimentProcessor();
	}

	@Annotated({ BeanModel.class, AnotherAnnotation.class })
	@Types({ JavaInterface.class, JavaEnum.class, JavaAnnotation.class })
	public MirrorProcessor mirrorProcessor() {
		return new MirrorProcessor();
	}

	@Annotated(MyAnnotation.class)
	@Types(JavaClass.class)
	public MyProcessor willProcessMyAnnotatedClasses() {
		return new MyProcessor();
	}

}
