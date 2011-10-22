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

package org.jannocessor.experiment.model;

import java.util.Date;
import java.util.EventListener;
import java.util.List;

import org.jannocessor.bootstrapped.annotation.AnotherAnnotation;
import org.jannocessor.bootstrapped.annotation.BeanModel;

@AnotherAnnotation(a = 3, b = "2")
@BeanModel
@SuppressWarnings({ "unused", "serial" })
public class PersonBeanModel extends AbstractModel implements Runnable,
		EventListener {

	String name;

	private int age = 3;

	protected transient Date birthday = null;

	java.sql.Date smartImportTestDate;

	@AnotherAnnotation(b = "constructor")
	public PersonBeanModel() {
	}

	private <T> void doSomeStuff(String name, java.sql.Date date, T type,
			List<T> list) throws IllegalAccessError {
	}

	@Override
	@AnotherAnnotation(b = "another annotation")
	public void run() {
	}

	private String foo(@AnotherAnnotation @Deprecated int x,
			@AnotherAnnotation(a = 1, b = "param") boolean y) {
		return "aa";
	}
}
