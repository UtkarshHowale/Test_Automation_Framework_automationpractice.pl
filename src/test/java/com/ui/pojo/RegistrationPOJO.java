package com.ui.pojo;

public class RegistrationPOJO {

	private String firstName;
	private String lastName;
	private String password;

	public RegistrationPOJO(String firstName, String lastName, String password) {
		super();

		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPassword() {
		return password;
	}

}
