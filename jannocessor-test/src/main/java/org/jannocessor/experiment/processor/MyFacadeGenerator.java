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

package org.jannocessor.experiment.processor;

import javax.annotation.Resource;

import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.executable.JavaMethod;
import org.jannocessor.model.structure.JavaClass;
import org.jannocessor.model.structure.JavaInterface;
import org.jannocessor.model.util.New;
import org.jannocessor.model.variable.JavaField;
import org.jannocessor.processor.api.CodeProcessor;
import org.jannocessor.processor.api.ProcessingContext;

public class MyFacadeGenerator implements CodeProcessor<JavaInterface> {

	/**
	 * Processes all interfaces annotated as target for Facade source code
	 * generation.
	 */
	public void process(PowerList<JavaInterface> targets, ProcessingContext context) {
		JavaClass facade = New.classs("Calculator2");

		for (JavaInterface target : targets) {
			String delegateName = target.getName().getUncapitalized();
			JavaField delegate = New.field(target.getType(), delegateName);

			delegate.getMetadata().add(New.metadata(Resource.class));
//			facade.getFields().add(delegate);

			for (JavaMethod method : target.getMethods()) {
				  //facade.getMethods().add(Methods.delegator(method, delegate));
			}
		}

		New.packagee("org.jannocessor.example.calculator.facade").getClasses().add(facade);
		context.generateCode(facade, true);
	}

}
