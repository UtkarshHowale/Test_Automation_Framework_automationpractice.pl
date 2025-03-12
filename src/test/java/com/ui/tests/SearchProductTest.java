package com.ui.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;

public final class SearchProductTest extends TestBase {

	private MyAccountPage myAccountPage;
	private static final String SEARCH_TERM = "Printed Summer Dress";

	@BeforeMethod(description = "Verify valid user logged-in into the application.")
	public void setup() {

		myAccountPage = homePage.goToLoginPage().doLoginWithValidCredentials("wixeti8618@apklamp.com", "Testing@123");
	}

	@Test(description = "Verify user able to search for a product and correct product search result is displayed", groups = {
			"somke" })
	public void productSearchTest() {

		boolean actualResult = myAccountPage.searchForProduct(SEARCH_TERM)
				.isSearchTermPresentInProductList(SEARCH_TERM);
		assertEquals(actualResult, true);
	}

}
