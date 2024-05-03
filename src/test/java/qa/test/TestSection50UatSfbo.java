package qa.test;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import base.BaseTest;
import junit.framework.Assert;
import pageEvents.DashboardPageEvents;
import pageEvents.HighwaysPageEvents;
import pageEvents.LoginPageEvents;

import pageEvents.Section50PageEventsBo;
import pageEvents2.LoginPageEvents2;
import pageEvents2.Section50PageEvents2;
import utils.Constants;
import utils.SeleniumUtils;

public class TestSection50UatSfbo extends BaseTest {
	@BeforeTest
	@Parameters("browser")
	public void beforeTestMethod(String browser) {
		// Set the custom report name
		reportName = "Section50BackOffice.html";
		documentTitle = "Uat Server";
		// Call the base class's method to initialize with the custom report name
		super.beforeTestMethod(browser);
	}

//	LoginPageEvents loginPg = new LoginPageEvents();
	LoginPageEvents2 loginPg = new LoginPageEvents2();
	DashboardPageEvents dashboardPg = new DashboardPageEvents();
	HighwaysPageEvents highwaysPg = new HighwaysPageEvents();
//	Section50PageEventsBo sec50 = new Section50PageEventsBo();
	Section50PageEvents2 sec50 = new Section50PageEvents2();

	@Test(priority = '1', enabled = true)
	public void OpenWestminsterBoUrl(Method methodName) {
		logger = extent.createTest(methodName.getName());

		// Opening Westminster backoffice login page url
		driver.get(Constants.westminsterUatSfboLoginUrl);
		String loginMessage = loginPg.enterLoginCredentials2(driver, "gwise", "pass@123");

		logger.info(loginMessage);
		logger.info("Enter section 50 url :");
		SeleniumUtils.someDelay(1000);
		driver.get(Constants.section50UatSfboUrl);
		SeleniumUtils.someDelay(1000);
		logger.info("Current url is : " + driver.getCurrentUrl());

	}

//	@Test(priority = '2', enabled = false)
//	public void performActionOnDashboard(Method methodName) {
//		logger = extent.createTest(methodName.getName());
//		String dashboardMessage = dashboardPg.clickOnHighwaysNavLink();
//		Assert.assertEquals("Success: Highways link clicked successfully", dashboardMessage);
//		logger.info(dashboardMessage);
//		logger.info("Current url is :" + driver.getCurrentUrl());
//	}

//	@Test(priority = '3', enabled = false)
//	public void performActionOnHighwaysPage(Method methodName) {
//		logger = extent.createTest(methodName.getName());
//		String highwaysPageMessage = highwaysPg.clickOnSection50Link(driver);
//		Assert.assertEquals("Success: Section 50 link clicked successfully", highwaysPageMessage);
//		logger.info(highwaysPageMessage);
//		logger.info("Current url is :" + driver.getCurrentUrl());
//	}

	@Test(priority = '2', enabled = true)
	public void fillBusinessDetails(Method methodName) {
		logger = extent.createTest(methodName.getName());
//		String businessDetailsMessage = sec50.fillBusinessDetails();
		String businessDetailsMessage = sec50.fillBusinessDetails("30838","test@fgl.com");
		logger.info(businessDetailsMessage);
		Assert.assertEquals(businessDetailsMessage, "Success: Customer search successfully");
		logger.info(driver.getCurrentUrl());
		logger.info(businessDetailsMessage);

	}

	@Test(priority = '4', enabled = false)
	public void fillingApplicationDates(Method methodName) {
		logger = extent.createTest(methodName.getName());
		String startDate = "25/04/2024";
		String endDate = "30/04/2024";
		String applicationDatesMessage = sec50.fillApplicationDates(driver, startDate, endDate);
		String expectedMessage = "Success: Application dates filled successfully. Start date: " + startDate
				+ " End date: " + endDate;
		logger.info(applicationDatesMessage);
		Assert.assertEquals(expectedMessage, applicationDatesMessage);

		logger.fail(
				"The end date input field accepts a date earlier than the start date. Please ensure that the end date is on or after the start date.");
		// Capture and attach screenshot
		captureAndAddScreenshot(methodName.getName());

	}

	@Test(priority = '5', enabled = false)
	public void fillingSiteDetails(Method methodName) {
		logger = extent.createTest(methodName.getName());
		String streetNamePostcode = "VICTORIA STREET";// which to be searched or SW1E6AA
		String streetNameOptionXpathValue = "VICTORIA STREET"; // xpath value its dynamic
		String siteDetailsMessage = sec50.fillSiteDetails(driver, streetNamePostcode, streetNameOptionXpathValue);

		logger.info(siteDetailsMessage);
		Assert.assertEquals("Success: Site details filled successfully.", siteDetailsMessage);
		logger.fail(
				"If you search for 'Victoria Street' on the front office page and select it, but the same selection doesn't work in the back office, you receive an error message stating 'please select a valid address or postcode'");
		logger.fail(
				"When passing SW1E6AA as the postcode, sometimes it shows SPENSER STREET, sometimes only VICTORIA STREET, and sometimes it shows many duplicate streets.");

		logger.fail(
				"Expected error message is not displayed when the user uploads a file larger than 10MB in both traffic management plan and public liability insurance and also no validation message for wrong file format.");
		logger.fail(
				"The end date input field accepts a date earlier than the start date. Please ensure that the end date is on or after the start date.");
		String screenshotPath = SeleniumUtils.captureFullPageScreenShot(driver, methodName.getName());
		logger.fail("Fullpage ScreenShot :" + logger.addScreenCaptureFromPath(screenshotPath));
	}

	@Test(priority = '6', enabled = false)
	public void fillAboutTheWorkSection(Method methodName) {
		logger = extent.createTest(methodName.getName());
		String expectedMessage = "Success: About the works filled successfully";
		String aboutTheWorkMessage = sec50.aboutTheWork(driver);
		Assert.assertEquals(expectedMessage, aboutTheWorkMessage);
		logger.info(aboutTheWorkMessage);

	}

	@Test(priority = '7', enabled = false)
	public void fillSupervisorDetails(Method methodName) {
		logger = extent.createTest(methodName.getName());
		String expectedMessage = "Success: Supervisor details filled successfully";
		String supervisorDetailsMessage = sec50.supervisorDetails(driver);
		Assert.assertEquals(expectedMessage, supervisorDetailsMessage);
		logger.info(expectedMessage);

		logger.fail(
				"First and Last Name: The system is currently accepting numeric values for both the first and last names, which is not intended. It should only accept alphabetical characters.");
		logger.fail(
				"Telephone Number: The system is permitting telephone numbers longer than the standard 11 digits and is also accepting alphabetic characters, which is erroneous. The telephone number field should strictly accept numerical values and must not exceed 11 digits.");
		logger.fail(
				"Validation Messages: There are no validation messages triggered for files that are too large or for those with invalid formats. It's crucial to provide clear feedback to users when such issues arise.");
		// Capture and attach screenshot
		captureAndAddScreenshot(methodName.getName());

	}

	@Test(priority = '8', enabled = false, invocationCount = 1)
	public void fillOperatorDetails(Method methodName) {
		logger = extent.createTest(methodName.getName());
		String expectedMessage = "Success: Operator details filled successfully";
		String opeartorDetailsMessage = sec50.operatorDetails(driver);
		Assert.assertEquals(expectedMessage, opeartorDetailsMessage);
		logger.info(expectedMessage);
		logger.fail(
				"First and Last Name: The system is currently accepting numeric values for both the first and last names, which is not intended. It should only accept alphabetical characters.");
		logger.fail(
				"Telephone Number: The system is permitting telephone numbers longer than the standard 11 digits and is also accepting alphabetic characters, which is erroneous. The telephone number field should strictly accept numerical values and must not exceed 11 digits.");
		logger.fail(
				"Validation Messages: There are no validation messages triggered for files that are too large or for those with invalid formats. It's crucial to provide clear feedback to users when such issues arise.");
		// Capture and attach screenshot
		captureAndAddScreenshot(methodName.getName());
	}

	@Test(priority = '9', enabled = false)
	public void addDeclaration(Method methodName) {
		logger = extent.createTest(methodName.getName());
		String expectedMessage = "Success: Declaration filled successfully";
		String declarationMessage = sec50.fillDeclaration(driver);
		Assert.assertEquals(expectedMessage, declarationMessage);
		logger.info(declarationMessage);

		logger.fail(
				"The full name, company name, and position fields should only accept letters, not numbers, but fields accepts numeric numbers.");

		// Capture and attach screenshot
		captureAndAddScreenshot(methodName.getName());
	}

	@Test(dependsOnMethods = { "addDeclaration" }, enabled = false)
	public void OrderSummary(Method methodName) {
		logger = extent.createTest(methodName.getName());
		String expectedMessage = "£580";
		String orderSummaryMessage = sec50.orderSummary(driver);
		Assert.assertEquals(expectedMessage, orderSummaryMessage);
		logger.info(orderSummaryMessage);

	}

	@Test(dependsOnMethods = { "OrderSummary" }, enabled = false)
	public void ProceedToPayment(Method methodName) {
		logger = extent.createTest(methodName.getName());
		String expectedMessage = "Success: Payment method successfully selected";
		// Note payment method accepted are Cash,Cheque,Bank transfer,Internal
		// recharge,Chip & pin,Telephone payment
		String paymentMessage = sec50.Payment(driver, "Cheque");
		Assert.assertEquals(expectedMessage, paymentMessage);
		logger.info(paymentMessage);

	}

}
