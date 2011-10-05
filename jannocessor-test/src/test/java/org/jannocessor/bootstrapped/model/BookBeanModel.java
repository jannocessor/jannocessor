package org.jannocessor.bootstrapped.model;

import org.jannocessor.bootstrapped.annotation.AnotherAnnotation;
import org.jannocessor.bootstrapped.annotation.BeanModel;

@AnotherAnnotation(a = 105, b = "xx")
@BeanModel
public class BookBeanModel {

	private transient String title;

	public static PersonBeanModel author;

	{
		System.err.println("hi!");
	}

}
