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

package org.jannocessor.extra.processor;

import javax.annotation.Resource;

import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.executable.JavaMethod;
import org.jannocessor.model.structure.JavaClass;
import org.jannocessor.model.structure.JavaInterface;
import org.jannocessor.model.util.Methods;
import org.jannocessor.model.util.New;
import org.jannocessor.model.variable.JavaField;
import org.jannocessor.processor.api.ProcessingContext;

public class FacadeGenerator extends AbstractGenerator<JavaInterface> {

	private final String facadeName;

	public FacadeGenerator(String destPackage, String facadeName, boolean inDebugMode) {
		super(destPackage, inDebugMode);
		this.facadeName = facadeName;
	}

	/**
	 * Generates a Facade implementation class from the specified interfaces.
	 */
	protected void generateCodeFrom(PowerList<JavaInterface> targets, ProcessingContext context) {
		JavaClass facade = New.classs(facadeName);

		for (JavaInterface target : targets) {
			String delegateName = target.getName().getUncapitalized();
			JavaField delegate = New.field(target.getType(), delegateName);

			delegate.getMetadata().add(New.metadata(Resource.class));
			facade.getFields().add(delegate);

			for (JavaMethod method : target.getMethods()) {
				facade.getMethods().add(Methods.delegator(method, delegate));
			}
		}

		generate(facade);
	}

}
