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

package org.jannocessor.common.processor;

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

public class FacadeGenerator implements CodeProcessor<JavaInterface> {

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

		New.packagee("org.jannocessor.example.calculator.facade").getClasses().add(facade);
		context.generateCode(facade, true);
	}

}
