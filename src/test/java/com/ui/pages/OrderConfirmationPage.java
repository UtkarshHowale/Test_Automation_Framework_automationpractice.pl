package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class OrderConfirmationPage extends BrowserUtility {

	public OrderConfirmationPage(WebDriver driver) {
		super(driver);
	}

	private static final By ALERT_SUCCESS_MESSAGE_LOCATOR = By.xpath("//p[@class=\"alert alert-success\"]");

	public String getOrderConfrimMessage() {

		return getVisibleText(ALERT_SUCCESS_MESSAGE_LOCATOR);
	}
}
