package org.jannocessor.bootstrapped.model;

import java.util.Date;
import java.util.List;

import org.jannocessor.bootstrapped.annotation.AnotherAnnotation;
import org.jannocessor.bootstrapped.annotation.BeanModel;

@AnotherAnnotation(a = 3, b = "2")
@BeanModel
public class PersonBeanModel {

	String name;

	private int age = 3;

	protected final Date birthday = null;

	java.sql.Date smartImportTestDate;

	public PersonBeanModel() {
		// TODO Auto-generated constructor stub
	}

	private <T> void doSomeStuff(String name, java.sql.Date date, T type,
			List<T> list) throws IllegalAccessError {

	}

}
