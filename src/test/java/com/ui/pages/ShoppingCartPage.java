package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class ShoppingCartPage extends BrowserUtility {

	public ShoppingCartPage(WebDriver driver) {
		super(driver);

	}

	private static final By PROCCED_TO_CHECKOUT_BUTTON_LOCATOR = By
			.xpath("//p[@class=\"cart_navigation clearfix\"]//a[@title=\"Proceed to checkout\"]");

	public ConfrimAddressPage goToConfrimAddressPage() {

		clickOn(PROCCED_TO_CHECKOUT_BUTTON_LOCATOR);
		return new ConfrimAddressPage(getDriver());
	}

}
