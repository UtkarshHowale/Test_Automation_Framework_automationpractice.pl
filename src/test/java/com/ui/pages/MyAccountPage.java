package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class MyAccountPage extends BrowserUtility {

	private static final By USER_NAME_LOCATOR = By.xpath("//a[@class=\"account\"]/span");
	private static final By SEARCH_TEXT_BOX_LOCATOR = By.id("search_query_top");

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	public String getUserName() {

		return getVisibleText(USER_NAME_LOCATOR);
	}

	public SearchResultPage searchForProduct(String productName) {

		enterText(SEARCH_TEXT_BOX_LOCATOR, productName);
		enterKey(SEARCH_TEXT_BOX_LOCATOR, Keys.ENTER);
		SearchResultPage searchResultPage = new SearchResultPage(getDriver());
		return searchResultPage;
	}
}
