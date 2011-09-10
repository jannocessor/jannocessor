package org.jannocessor.bootstrapped.model.jpa;

import org.jannocessor.bootstrapped.annotation.AnotherAnnotation;
import org.jannocessor.bootstrapped.annotation.BeanModel;
import org.jannocessor.bootstrapped.model.PersonBeanModel;

@AnotherAnnotation(a = 105, b = "xx")
@BeanModel
public class BookJpaModel {

	String title;

	PersonBeanModel author;
}
