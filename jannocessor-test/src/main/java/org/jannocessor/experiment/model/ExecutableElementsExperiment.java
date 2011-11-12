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

import java.io.IOException;
import java.util.List;

import org.jannocessor.bootstrapped.annotation.AnotherAnnotation;
import org.jannocessor.bootstrapped.annotation.BeanModel;

@AnotherAnnotation(a = 1, b = "x")
@BeanModel
@SuppressWarnings("unused")
public class ExecutableElementsExperiment {

	static {
		// some static init
	}

	{
		// some instance init
	}

	public ExecutableElementsExperiment() {
	}

	public <T> ExecutableElementsExperiment(T foo) {
	}

	private <T> void doSomeStuff(String name, java.sql.Date date, T type,
			List<T> list) throws IllegalAccessError {
	}

	public final String getSomething2() throws RuntimeException, IOException {
		return null;
	}

	public static void main(String[] args) {
		new ExecutableElementsExperiment();
	}

}
