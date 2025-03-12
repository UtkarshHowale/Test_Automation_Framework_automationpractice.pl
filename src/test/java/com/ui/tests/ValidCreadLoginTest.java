package com.ui.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pojo.User;

@Listeners({ com.ui.listerners.TestListerner.class })
public final class ValidCreadLoginTest extends TestBase {

	@Test(description = "Verify valid user is login to the application.", groups = {
			"sanity" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestJSONDataProvider", retryAnalyzer = com.ui.listerners.MyRetryAnalyzer.class)
	public void loginJSONDataTestWithValidCredentials(User user) {

		assertEquals(homePage.goToLoginPage().doLoginWithValidCredentials(user.getEmailAddress(), user.getPassword())
				.getUserName(), "Utkarsh Testing");
	}

	@Test(description = "Verify valid user is login to the application.", groups = {
			"sanity" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestCSVDataProvider", retryAnalyzer = com.ui.listerners.MyRetryAnalyzer.class)
	public void loginCSVDataTestWithValidCredentials(User user) {

		assertEquals(homePage.goToLoginPage().doLoginWithValidCredentials(user.getEmailAddress(), user.getPassword())
				.getUserName(), "Utkarsh Testing");
	}

	@Test(description = "Verify valid user is login to the application.", groups = {
			"sanity" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestExcelDataProvider", retryAnalyzer = com.ui.listerners.MyRetryAnalyzer.class)
	public void loginExcelDataTestWithValidCredentials(User user) {

		assertEquals(homePage.goToLoginPage().doLoginWithValidCredentials(user.getEmailAddress(), user.getPassword())
				.getUserName(), "Utkarsh Testing");
	}
}
