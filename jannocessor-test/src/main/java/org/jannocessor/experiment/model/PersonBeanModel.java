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
