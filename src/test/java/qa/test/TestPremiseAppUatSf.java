package qa.test;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTest;
import pageEvents.LoginPageEvents;
import utils.Constants;
import utils.SeleniumUtils;

public class TestPremiseAppUatSf extends BaseTest {
	LoginPageEvents loginPg = new LoginPageEvents();

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

		logger.info(loginMessage);
//		Assert.assertEquals(loginMessage, "Login successful");
		logger.info("Enter Premise application url :");
		SeleniumUtils.someDelay(1000);
		driver.get(Constants.La_03PremiseAppUatSf);
		SeleniumUtils.someDelay(1000);
		logger.info("Current url is : " + driver.getCurrentUrl());
	}
}
