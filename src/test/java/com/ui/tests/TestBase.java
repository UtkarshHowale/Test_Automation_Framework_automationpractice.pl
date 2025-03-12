package com.ui.tests;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LambdaTestUtility;

public abstract class TestBase {

	protected HomePage homePage;
	private boolean isLambdaTest;

	@Parameters({ "browser", "isLambdaTest", "isHeadless" })
	@BeforeMethod(description = "Load the home page of the website")
	public void setup(@Optional("chrome") String browser, @Optional("false") boolean isLambdaTest,
			@Optional("flase") boolean isHeadless, ITestResult result) {

		this.isLambdaTest = isLambdaTest;
		WebDriver lambdaDriver;

		if (isLambdaTest) {

			// Running the tests on the cloud server (Lambda Test)
			lambdaDriver = LambdaTestUtility.initializeLambdaTestSession(browser, result.getMethod().getMethodName());
			homePage = new HomePage(lambdaDriver);
		} else {

			// Running the tests on the local machine
			homePage = new HomePage(Browser.valueOf(browser.toUpperCase()), isHeadless);
		}

	}

	@AfterMethod(description = "Tear down the browser")
	public void tearDown() {

		if (isLambdaTest) {

			LambdaTestUtility.quitSession(); // quit or close browser session on Lambda Test
		} else {
			homePage.quit(); // quit or close browser session local machine
		}

	}

	public BrowserUtility getInstance() {

		return homePage;
	}

}
