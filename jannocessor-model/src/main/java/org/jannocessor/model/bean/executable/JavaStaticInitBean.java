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

import org.jannocessor.data.JavaStaticInitData;
import org.jannocessor.model.JavaElementKind;
import org.jannocessor.model.code.JavaBody;
import org.jannocessor.model.executable.JavaStaticInit;
import org.jannocessor.model.util.New;

public class JavaStaticInitBean extends JavaStaticInitData implements
		JavaStaticInit {

	
	private static final long serialVersionUID = -3349176451260341355L;

	public JavaStaticInitBean(JavaBody body) {
		this.setBody(body);

		this.setKind(JavaElementKind.STATIC_INIT);
		this.setCode(New.code(JavaStaticInit.class));
		this.setExtraCode(New.code());
	}

}
