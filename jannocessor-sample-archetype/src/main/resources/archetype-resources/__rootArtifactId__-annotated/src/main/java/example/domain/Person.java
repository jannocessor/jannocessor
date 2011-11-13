package example.domain;

import java.util.Date;

import example.annotation.GenerateBuilder;


@GenerateBuilder
public class Person {

	private String firstName;

	private String lastName;

	private Date birthDate;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName
				+ ", birthDate=" + birthDate + "]";
	}

}
