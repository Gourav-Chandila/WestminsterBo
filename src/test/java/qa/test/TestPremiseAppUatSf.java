package qa.test;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTest;
import junit.framework.Assert;
import pageEvents.LoginPageEvents;
import pageEvents.PremiseAppSfEvents;
import utils.Constants;
import utils.SeleniumUtils;

public class TestPremiseAppUatSf extends BaseTest {
	LoginPageEvents loginPg = new LoginPageEvents();
	PremiseAppSfEvents premise = new PremiseAppSfEvents();

	@BeforeTest
	@Parameters("browser")
	public void beforeTestMethod(String browser) {
		// Override the report name and document title for this class
		reportName = "PremiseApplicationUatSf.html";
		documentTitle = "PremiseApplication Front Office";
		// Call the base class setup
		super.beforeTestMethod(browser);
	}

	@Test(priority = '1', enabled = true)
	public void openLa_03LoginUrl(Method methodName) {
		logger = extent.createTest(methodName.getName());

		// Opening Westminster backoffice login page url
		driver.get(Constants.La_03UatSfLoginUrl);
		String loginMessage = loginPg.enterLoginCredentials(driver, "donchandila334@gmail.com", "Gourav@334");
		Assert.assertEquals(loginMessage, "Login successful");
		logger.info(loginMessage);
		logger.info("Enter Premise application url :");
		SeleniumUtils.someDelay(1000);
		driver.get(Constants.La_03PremiseAppUatSf);
		SeleniumUtils.someDelay(1000);
		logger.info("Current url is : " + driver.getCurrentUrl());
	}

	@Test(priority = '2', enabled = true)
	public void confirmInformationTrue(Method methodName) {
		logger = extent.createTest(methodName.getName());
		String Message = premise.confirmInfoIsTrue(driver);
		String expectedMessage = "Please confirm the above is true : Clicked";
		Assert.assertEquals(expectedMessage, Message);
		logger.info(Message);
	}
	@Test(priority = '3', enabled = true)
	public void fillingLicenceDuration(Method methodName) {
		logger = extent.createTest(methodName.getName());
		String startDate = "21/05/2024";
		String endDate = "30/05/2024";
		String applicationDatesMessage = premise.fillLicenceDuration(driver, startDate, endDate);
		String expectedMessage = "Success: Licence duration dates filled successfully. Start date: " + startDate
				+ " End date: " + endDate;
		Assert.assertEquals(expectedMessage, applicationDatesMessage);
		logger.info(applicationDatesMessage);
	}
	
}
