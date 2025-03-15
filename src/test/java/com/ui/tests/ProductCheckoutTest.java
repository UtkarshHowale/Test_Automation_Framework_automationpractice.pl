package com.ui.tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.constants.Size.*;
import com.ui.pages.SearchResultPage;

public class ProductCheckoutTest extends TestBase {

	private SearchResultPage searchResultPage;
	private static final String SEARCH_TERM = "Printed Summer Dress";

	@BeforeMethod(description = "Verify logged-in into the application and search for a product")
	public void setup() {

		searchResultPage = homePage.goToLoginPage().doLoginWithValidCredentials("wixeti8618@apklamp.com", "Testing@123")
				.searchForProduct(SEARCH_TERM);
	}

	@Test(description = "Verify if logged in user is able to buy a product", groups = { "e2e", "Sanity" })
	public void checkOutTest() {

		String result = searchResultPage.clickOnTheFirstProductAtIndex(2).changeSize(M).addProductToCart()
				.productToCheckout().goToConfrimAddressPage().goToShippmentPage().goToPaymentPage().makePaymentByWire()
				.getOrderConfrimMessage();

		assertTrue(result.contains("Your order on My Shop is complete."));
	}
}
