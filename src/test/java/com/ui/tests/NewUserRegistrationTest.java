package com.ui.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;
import com.ui.pojo.LoginPOJO;
import com.ui.pojo.RegistrationPOJO;
import com.utility.FakerUtility;

public class NewUserRegistrationTest extends TestBase {

	private MyAccountPage myAccountPage;
	private RegistrationPOJO registrationPOJO;
	private LoginPOJO loginPOJO;

	@BeforeMethod(description = "Verify user logged-in into the application.")
	public void setup() {

		loginPOJO = FakerUtility.getEmailDetails();
		registrationPOJO = FakerUtility.getRegistrationDetails();

	}

	@Test(description = "Verify new user able to create account into the application.")
	public void registerNewUser() {

		String accountCreationSuccessMessage = homePage.goToLoginPage().goToAccountRegistrationPage(loginPOJO)
				.registerNewUser(registrationPOJO, 0, "16", "April ", "1999").getAccountCreationSuccessMessage();
		assertEquals(accountCreationSuccessMessage, "Your account has been created.");
	}
}
