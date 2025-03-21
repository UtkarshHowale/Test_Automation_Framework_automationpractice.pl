package com.ui.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.AddressPage;
import com.ui.pages.MyAccountPage;
import com.ui.pojo.AddressPOJO;
import com.ui.pojo.LoginPOJO;
import com.ui.pojo.RegistrationPOJO;
import com.utility.FakerUtility;

public final class AddAddressTest extends TestBase {

	private MyAccountPage myAccountPage;
	private AddressPOJO addressPOJO;
	private RegistrationPOJO registrationPOJO;
	private LoginPOJO loginPOJO;

	@BeforeMethod(description = "Verify new user able to create account into the application.")
	public void setup() {

		loginPOJO = FakerUtility.getEmailDetails();
		registrationPOJO = FakerUtility.getRegistrationDetails();
		myAccountPage = homePage.goToLoginPage().goToAccountRegistrationPage(loginPOJO)
				.registerNewUser(registrationPOJO, 0, "16", "April ", "1999");
		addressPOJO = FakerUtility.getFakeAddress();

	}

	@Test(description = "Verify new user able to add address for the account.")
	public void addNewAddress() {

		String newAddress = myAccountPage.goToAddAddressPage().saveAddress(addressPOJO);
		assertEquals(newAddress, addressPOJO.getAddressAlias().toUpperCase());
	}

}
