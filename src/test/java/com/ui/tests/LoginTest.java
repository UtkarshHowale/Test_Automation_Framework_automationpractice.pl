package com.ui.tests;

import static com.constants.Browser.*;
import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pojo.User;
import com.utility.BrowserUtility;
import com.utility.LoggerUtility;

@Listeners({ com.ui.listerners.TestListerner.class })
public class LoginTest extends TestBase {

	@Test(description = "Verify valid user is login to the application.", groups = {
			"sanity" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestJSONDataProvider", retryAnalyzer = com.ui.listerners.MyRetryAnalyzer.class)
	public void loginJSONDataTest(User user) {

		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
				"Utkarsh Testing");
	}

	@Test(description = "Verify valid user is login to the application.", groups = {
			"sanity" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestCSVDataProvider", retryAnalyzer = com.ui.listerners.MyRetryAnalyzer.class)
	public void loginCSVDataTest(User user) {

		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
				"Utkarsh Testing");
	}

	@Test(description = "Verify valid user is login to the application.", groups = {
			"sanity" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestExcelDataProvider", retryAnalyzer = com.ui.listerners.MyRetryAnalyzer.class)
	public void loginExcelDataTest(User user) {

		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
				"Utkarsh Testing");
	}
}
