package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.pojo.LoginPOJO;
import com.utility.BrowserUtility;

public final class LoginPage extends BrowserUtility {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	private static final By EMAIL_TEXT_BOX_LOCATOR = By.id("email");
	private static final By PAASWORD_TEXT_BOX_LOCATOR = By.id("passwd");
	private static final By SUBMIT_BUTTON_LOCATOR = By.id("SubmitLogin");
	private static final By ERROR_MESSAGE_LOCATOR = By.xpath("//div[contains(@class,'alert-danger')]/ol/li");
	private static final By EMAIL_CREATE_LOCATOR = By.id("email_create");
	private static final By CREATE_ACCOUNT_BUTTON_LOCATOR = By.id("SubmitCreate");

	public MyAccountPage doLoginWithValidCredentials(String emailAddress, String password) {

		enterText(EMAIL_TEXT_BOX_LOCATOR, emailAddress);
		enterText(PAASWORD_TEXT_BOX_LOCATOR, password);
		clickOn(SUBMIT_BUTTON_LOCATOR);
		return new MyAccountPage(getDriver());

	}

	public LoginPage doLoginWithInvalidCredentials(String emailAddress, String password) {

		enterText(EMAIL_TEXT_BOX_LOCATOR, emailAddress);
		enterText(PAASWORD_TEXT_BOX_LOCATOR, password);
		clickOn(SUBMIT_BUTTON_LOCATOR);
		return new LoginPage(getDriver());
	}

	public String getErrorMessage() {

		return getVisibleText(ERROR_MESSAGE_LOCATOR);
	}

	public AccountRegistrationPage goToAccountRegistrationPage(LoginPOJO loginPOJO) {

		enterText(EMAIL_CREATE_LOCATOR, loginPOJO.getEmailAddress());
		clickOn(CREATE_ACCOUNT_BUTTON_LOCATOR);
		return new AccountRegistrationPage(getDriver());
	}

}
