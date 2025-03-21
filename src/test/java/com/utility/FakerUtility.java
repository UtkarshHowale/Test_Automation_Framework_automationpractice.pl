package com.utility;

import java.util.Locale;

import com.github.javafaker.Faker;
import com.ui.pojo.AddressPOJO;
import com.ui.pojo.RegistrationPOJO;
import com.ui.pojo.LoginPOJO;

public class FakerUtility {

	public static AddressPOJO getFakeAddress() {

		Faker faker = new Faker(Locale.US);

		AddressPOJO addressPOJO = new AddressPOJO(faker.company().name(), faker.address().buildingNumber(),
				faker.address().streetAddress(), faker.address().city(), faker.numerify("#####"),
				faker.phoneNumber().cellPhone(), faker.phoneNumber().cellPhone(), "other", "office address",
				faker.address().state());

		return addressPOJO;
	}

	public static RegistrationPOJO getRegistrationDetails() {

		Faker faker = new Faker();
		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();
		String password = faker.name().firstName() + "@123";
		RegistrationPOJO registrationPOJO = new RegistrationPOJO(firstName, lastName, password);

		return registrationPOJO;
	}

	public static LoginPOJO getEmailDetails() {

		Faker faker = new Faker();
		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();
		String emailAddress = firstName + lastName + "@gmail.com";
		LoginPOJO loginPOJO = new LoginPOJO(emailAddress);
		return loginPOJO;
	}
}
