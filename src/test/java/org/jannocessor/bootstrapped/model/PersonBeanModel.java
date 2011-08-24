package org.jannocessor.bootstrapped.model;

import java.util.Date;

import org.jannocessor.bootstrapped.annotation.AnotherAnnotation;
import org.jannocessor.bootstrapped.annotation.BeanModel;

@AnotherAnnotation(a=3, b="2")
@BeanModel
public class PersonBeanModel {

	String name;

	int age;

	Date birthday;

	java.sql.Date smartImportTestDate;

}
