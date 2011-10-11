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

import java.util.Date;
import java.util.List;

import org.jannocessor.bootstrapped.annotation.AnotherAnnotation;
import org.jannocessor.bootstrapped.annotation.BeanModel;

@AnotherAnnotation(a = 1, b = "x")
@BeanModel
@SuppressWarnings("unused")
public class ExecutableElementsTestModel {

	static {
		// some static init
	}

	{
		// some instance init
	}

	public ExecutableElementsTestModel() {
	}

	public <T> ExecutableElementsTestModel(T foo) {
	}

	private <T> void doSomeStuff(String name, java.sql.Date date, T type,
			List<T> list) throws IllegalAccessError {
	}

	public final String getSomething2() {
		return null;
	}

	public static void main(String[] args) {
		new ExecutableElementsTestModel();
	}
}
