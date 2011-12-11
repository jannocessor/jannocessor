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

package org.jannocessor.processor.api;

import org.jannocessor.model.JavaCodeModel;
import org.jannocessor.model.structure.AbstractJavaStructure;
import org.slf4j.Logger;

public interface ProcessingContext {

	Logger getLogger();

	void generateCode(AbstractJavaStructure model, boolean debug);

	void generateInfo(JavaCodeModel model, boolean debug);

	void generateFile(String fileName, String content);

}
