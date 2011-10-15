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

package org.jannocessor.bootstrapped.model;

import org.jannocessor.bootstrapped.annotation.AnotherAnnotation;
import org.jannocessor.bootstrapped.annotation.BeanModel;

@AnotherAnnotation(a = 105, b = "xx")
@BeanModel
public enum TestEnum {

	A(1), B(2), C(3);

	private final int k;

	private TestEnum(int k) {
		this.k = k;
	}

	@Override
	public String toString() {
		return "E" + k;
	}

}
