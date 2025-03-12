package com.ui.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ com.ui.listerners.TestListerner.class })
public final class InvalidCreadLoginTest extends TestBase {

	private static final String INVALID_EMAIL_ADDRESS = "wixeti8618@apklamp.com";
	private static final String INVALID_PASSWORD = "test@1234";

	@Test(description = "Verify if the proper error message is shown for the user when they enter invalid credentials", groups = {
			"sanity", "smoke" }, retryAnalyzer = com.ui.listerners.MyRetryAnalyzer.class)
	public void loginTestWithInvalidCredentials() {

		assertEquals(homePage.goToLoginPage().doLoginWithInvalidCredentials(INVALID_EMAIL_ADDRESS, INVALID_PASSWORD)
				.getErrorMessage(), "Authentication failed.");
	}
}
