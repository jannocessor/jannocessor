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

import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.structure.AbstractJavaStructure;
import org.jannocessor.processor.api.CodeProcessor;
import org.jannocessor.processor.api.ProcessingContext;

public class MirrorProcessor implements CodeProcessor<AbstractJavaStructure> {

	private final boolean debugMode;

	public MirrorProcessor(boolean debugMode) {
		this.debugMode = debugMode;
	}

	@Override
	public void process(PowerList<AbstractJavaStructure> elements, ProcessingContext context) {
		context.getLogger().info("Processing {} elements", elements.size());

		for (AbstractJavaStructure structure : elements) {
			// context.generateCode(structure, debugMode);
		}
	}

}
