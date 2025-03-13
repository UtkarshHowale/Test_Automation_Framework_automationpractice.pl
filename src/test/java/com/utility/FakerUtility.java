package com.utility;

import java.util.Locale;

import com.github.javafaker.Faker;
import com.ui.pojo.AddressPOJO;

public class FakerUtility {

	public static AddressPOJO getFakeAddress() {

		Faker faker = new Faker(Locale.US);

		AddressPOJO addressPOJO = new AddressPOJO(faker.company().name(), faker.address().buildingNumber(),
				faker.address().streetAddress(), faker.address().city(), faker.numerify("#####"),
				faker.phoneNumber().cellPhone(), faker.phoneNumber().cellPhone(), "other", "office address",
				faker.address().state());

		return addressPOJO;
	}
}
