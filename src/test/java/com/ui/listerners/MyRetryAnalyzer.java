package com.ui.listerners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.constants.Environments;
import com.utility.JSONUtility;
import com.utility.PropertiesUtil;

public class MyRetryAnalyzer implements IRetryAnalyzer {

	// Get by properties file
	private static final int MAX_NUMBER_OF_ATTEMPTS = Integer
			.parseInt(PropertiesUtil.readProperty(Environments.QA, "MAX_NUMBER_OF_ATTEMPTS"));

	// Get by json
//	private static final int MAX_NUMBER_OF_ATTEMPTS = JSONUtility.readJSON(Environments.QA).getMAX_NUMBER_OF_ATTEMPTS();

	private static int currentAttempt = 1;

	@Override
	public boolean retry(ITestResult result) {

		if (currentAttempt <= MAX_NUMBER_OF_ATTEMPTS) {

			currentAttempt++;
			return true;
		}
		return false;
	}

}
