package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;

import com.constants.Browser;

public abstract class BrowserUtility {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	Logger logger = LoggerUtility.getLogger(this.getClass());

	public WebDriver getDriver() {
		return driver.get();
	}

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);
	}

	public BrowserUtility(Browser browserName) {

		logger.info("Lounching Browser for " + browserName);

		if (browserName == Browser.CHROME) {

			driver.set(new ChromeDriver());
		} else if (browserName == Browser.EDGE) {

			driver.set(new EdgeDriver());

		} else if (browserName == Browser.FIREFOX) {

			driver.set(new FirefoxDriver());
		} else {

			logger.error("Invalid Browser Name...!!! Please select browser name - Chrome, Edge, Firefox only");
			System.err.println("Invalid Browser Name...!!! Please select browser name - Chrome, Edge, Firefox only");
		}
	}

	public BrowserUtility(Browser browserName, boolean isHeadless) {

		logger.info("Lounching Browser for " + browserName);

		if (browserName == Browser.CHROME) {

			if (isHeadless) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				options.addArguments("--window-size=1920,1080");
				options.addArguments("disable-gpu");
				driver.set(new ChromeDriver(options));
			} else {
				driver.set(new ChromeDriver());
			}
		} else if (browserName == Browser.EDGE) {

			if (isHeadless) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless");
				options.addArguments("--window-size=1920,1080");
				options.addArguments("disable-gpu");
				driver.set(new EdgeDriver(options));
			} else {
				driver.set(new EdgeDriver());
			}

		} else if (browserName == Browser.FIREFOX) {

			if (isHeadless) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless");
				options.addArguments("disable-gpu");
				options.addArguments("--window-size=1920,1080");
				driver.set(new FirefoxDriver(options));
			} else {
				driver.set(new FirefoxDriver());
			}

		} else {

			logger.error("Invalid Browser Name...!!! Please select browser name - Chrome, Edge, Firefox only");
			System.err.println("Invalid Browser Name...!!! Please select browser name - Chrome, Edge, Firefox only");
		}
	}

	public BrowserUtility(String browserName) {

		logger.info("Lounching Browser for " + browserName);

		if (browserName.equalsIgnoreCase("Chrome")) {

			driver.set(new ChromeDriver());

		} else if (browserName.equalsIgnoreCase("Edge")) {

			driver.set(new EdgeDriver());
		} else if (browserName.equalsIgnoreCase("FireFox")) {

			driver.set(new FirefoxDriver());

		} else {

			logger.error("Invalid Browser Name...!!! Please select browser name - Chrome, Edge, Firefox only");
			System.err.println("Invalid Browser Name...!!! Please select browser name - Chrome, Edge, Firefox");
		}
	}

	public void goToWebsite(String url) {

		logger.info("Visiting the website " + url);
		driver.get().get(url);
	}

	public void maximizeWindow() {

		logger.info("Maximize the browser window");
		driver.get().manage().window().maximize();
	}

	public void clickOn(By locator) {

		logger.info("Finding element with the locator " + locator);
		WebElement element = driver.get().findElement(locator);
		logger.info("Element found and now performing click");
		element.click();
	}

	public void enterText(By locator, String textToEnter) {

		logger.info("Finding element with the locator " + locator);
		WebElement element = driver.get().findElement(locator);
		logger.info("Element found and now entering the text: " + textToEnter);
		element.sendKeys(textToEnter);
	}

	public void clearText(By textBoxlocator) {

		logger.info("Finding element with the locator " + textBoxlocator);
		WebElement element = driver.get().findElement(textBoxlocator);
		logger.info("Element found and now clearing the text box fild");
		element.clear();
	}

	public void enterKey(By locator, Keys keysToEnter) {

		logger.info("Finding element with the locator " + locator);
		WebElement element = driver.get().findElement(locator);
		logger.info("Element found and now entering the keys: " + keysToEnter);
		element.sendKeys(keysToEnter);
	}

	public String getVisibleText(By locator) {

		logger.info("Finding all elements with the locator " + locator);
		WebElement element = driver.get().findElement(locator);
		logger.info("Element found and now returning the visible text: " + element.getText());
		return element.getText();
	}

	public List<String> getAllVisibleText(By locator) {

		logger.info("Finding element with the locator " + locator);
		List<WebElement> elementList = driver.get().findElements(locator);
		logger.info("Elements found and now printing the list of elements");

		List<String> visibleTextList = new ArrayList<String>();
		for (WebElement element : elementList) {

			System.out.println(getVisibleText(element));
			visibleTextList.add(getVisibleText(element));
		}
		return visibleTextList;

	}

	public String getVisibleText(WebElement element) {

		logger.info("Returning the visible text: " + element.getText());
		return element.getText();
	}

	public void selectFromDropDown(By dropDownLocator, String optionToSelect) {

		logger.info("Finding all elements with the locator " + dropDownLocator);
		WebElement element = driver.get().findElement(dropDownLocator);
		Select select = new Select(element);
		logger.info("Option to select " + optionToSelect);
		select.selectByVisibleText(optionToSelect);

	}

	public void closeTheBrowser() {

		logger.info("Closing the browser window");
		driver.get().quit();
		logger.info("Browser window is closed");
	}

	public String takeScreenShot(String testName) {

		TakesScreenshot screenshot = (TakesScreenshot) driver.get();
		File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		String timestamp = simpleDateFormat.format(date);
		String filePath = "./screenshots/" + testName + " - " + timestamp + ".png";
		File screenshotFile = new File(filePath);
		try {
			FileUtils.copyFile(screenshotData, screenshotFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return filePath;
	}
}
