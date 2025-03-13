package com.ui.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.AddressPage;
import com.ui.pages.MyAccountPage;
import com.ui.pojo.AddressPOJO;
import com.utility.FakerUtility;

public final class AddFirstAddressTest extends TestBase {

	private MyAccountPage myAccountPage;
	private AddressPOJO addressPOJO;

	@BeforeMethod(description = "Verify valid first time user logged-in into the application.")
	public void setup() {

		myAccountPage = homePage.goToLoginPage().doLoginWithValidCredentials("wixeti8618@apklamp.com", "Testing@123");
		addressPOJO = FakerUtility.getFakeAddress();
	}

	@Test
	public void addNewAddress() {

		String newAddress = myAccountPage.goToAddAddressPage().saveAddress(addressPOJO);
		assertEquals(newAddress, addressPOJO.getAddressAlias().toUpperCase());
	}

}
