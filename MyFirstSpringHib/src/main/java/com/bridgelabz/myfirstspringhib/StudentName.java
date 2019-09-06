package com.bridgelabz.myfirstspringhib;

import javax.persistence.Embeddable;

/* 
 * To embed the first name, mid nam and last name to Student name.
 */
@Embeddable
public class StudentName {
	private String firstName;
	private String midName;
	private String lastName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMidName() {
		return midName;
	}

	public void setMidName(String midName) {
		this.midName = midName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "StudentName [firstName=" + firstName + ", midName=" + midName + ", lastName=" + lastName + "]";
	}

}
