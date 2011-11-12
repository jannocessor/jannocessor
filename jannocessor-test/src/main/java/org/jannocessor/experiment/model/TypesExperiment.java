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

package org.jannocessor.experiment.model;

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
