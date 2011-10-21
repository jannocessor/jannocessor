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

package org.jannocessor.model.bean.executable;

import org.jannocessor.data.JavaInstanceInitData;
import org.jannocessor.model.JavaElementKind;
import org.jannocessor.model.code.JavaBody;
import org.jannocessor.model.executable.JavaInstanceInit;
import org.jannocessor.model.util.New;

public class JavaInstanceInitBean extends JavaInstanceInitData implements
		JavaInstanceInit {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2553648591898709853L;

	public JavaInstanceInitBean(JavaBody body) {
		this.setBody(body);

		this.setKind(JavaElementKind.INSTANCE_INIT);
		this.setCode(New.code(JavaInstanceInit.class));
	}

}
