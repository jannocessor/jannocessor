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

package org.jannocessor.model.bean.executable;

import org.jannocessor.data.JavaInstanceInitData;
import org.jannocessor.model.JavaElementKind;
import org.jannocessor.model.code.JavaBody;
import org.jannocessor.model.executable.JavaInstanceInit;
import org.jannocessor.model.util.New;

public class JavaInstanceInitBean extends JavaInstanceInitData implements
		JavaInstanceInit {

	
	private static final long serialVersionUID = -2553648591898709853L;

	public JavaInstanceInitBean(JavaBody body) {
		this.setBody(body);

		this.setKind(JavaElementKind.INSTANCE_INIT);
		this.setCode(New.code(JavaInstanceInit.class));
		this.setExtraCode(New.code());
	}

}
