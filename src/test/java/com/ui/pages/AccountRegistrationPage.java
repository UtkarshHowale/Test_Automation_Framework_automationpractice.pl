package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.pojo.RegistrationPOJO;
import com.utility.BrowserUtility;

public class AccountRegistrationPage extends BrowserUtility {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}

	private static final By TITLE_RADIO_BUTTON_LOCATOR = By
			.xpath("//div[@class='radio-inline']");
	private static final By FIRST_NAME_LOCATOR = By.id("customer_firstname");
	private static final By LAST_NAME_LOCATOR = By.id("customer_lastname");
	private static final By PASSWORD_LOCATOR = By.id("passwd");
	private static final By DATE_DRODOWN_LOCATOR = By.id("days");
	private static final By MONTH_DRODOWN_LOCATOR = By.id("months");
	private static final By YEAR_DRODOWN_LOCATOR = By.id("years");
	private static final By NEWS_LETTER_CHECKBOX_LOCATOR = By.id("newsletter");
	private static final By REGISTER_BUTTON_LOCATOR = By.id("submitAccount");

	public MyAccountPage registerNewUser(RegistrationPOJO registrationPOJO, int radioButtonIndex, String getDate,
			String getMonth, String getYear) {

		selectRadioButton(TITLE_RADIO_BUTTON_LOCATOR, radioButtonIndex);
		enterText(FIRST_NAME_LOCATOR, registrationPOJO.getFirstName());
		enterText(LAST_NAME_LOCATOR, registrationPOJO.getLastName());
		enterText(PASSWORD_LOCATOR, registrationPOJO.getPassword());
		selectFromDropDownByValue(DATE_DRODOWN_LOCATOR, getDate);
		selectFromDropDown(MONTH_DRODOWN_LOCATOR, getMonth);
		selectFromDropDownByValue(YEAR_DRODOWN_LOCATOR, getYear);
		selectCheckbox(NEWS_LETTER_CHECKBOX_LOCATOR);
		clickOn(REGISTER_BUTTON_LOCATOR);
		return new MyAccountPage(getDriver());

	}

}