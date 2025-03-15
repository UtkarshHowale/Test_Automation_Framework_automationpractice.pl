package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class ConfrimAddressPage extends BrowserUtility {

	public ConfrimAddressPage(WebDriver driver) {
		super(driver);
	}

	private static final By PROCCED_TO_CHECKOUT_BUTTON_LOCATOR = By.name("processAddress");

	public ShippmentPage goToShippmentPage() {

		clickOn(PROCCED_TO_CHECKOUT_BUTTON_LOCATOR);
		return new ShippmentPage(getDriver());
	}

}
