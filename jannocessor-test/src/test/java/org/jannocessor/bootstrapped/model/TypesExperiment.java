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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jannocessor.bootstrapped.annotation.AnotherAnnotation;
import org.jannocessor.bootstrapped.annotation.BeanModel;

@SuppressWarnings("serial")
@AnotherAnnotation(a = 105, b = "xx")
@BeanModel
public class TypesExperiment<E, F> extends ArrayList<E> {

	public <T> void someMethod(
			Set<?> a,
			E b,
			Set<E> c,
			Map<List<? extends Object>, Set<? super List<? extends Serializable>>> d) {
	}

	public <T extends Serializable & List<? super Serializable>> void someMethod(
			T x) {
	}

	public <T extends Runnable & List<? extends Serializable>> void someMethod() {
	}

	public void someMethod3(List<? extends Serializable> arg) {
	}

	public void someMethod4(List<? super Serializable> arg) {
	}

}
