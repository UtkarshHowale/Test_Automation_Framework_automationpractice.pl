package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class PaymentPage extends BrowserUtility {

	public PaymentPage(WebDriver driver) {
		super(driver);
	}

	private static final By PAYMENT_BY_WIRE_BUTTON_LOCATOR = By.xpath("//a[@title=\"Pay by bank wire\"]");
	private static final By CONFIRM_PAYMENT_BUTTON_LOCATOR = By
			.xpath("//p[@class=\"cart_navigation clearfix\"]//button");

	public OrderConfirmationPage makePaymentByWire() {

		clickOn(PAYMENT_BY_WIRE_BUTTON_LOCATOR);
		clickOn(CONFIRM_PAYMENT_BUTTON_LOCATOR);
		return new OrderConfirmationPage(getDriver());

	}
}
