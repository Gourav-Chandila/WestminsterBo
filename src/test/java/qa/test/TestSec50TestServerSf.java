package qa.test;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTest;
import junit.framework.Assert;
import pageEvents.LoginPageEvents;
import pageEvents.Sec50UatSfEvents;
import pageEvents.Sec50UatSfboEvents;
import utils.Constants;
import utils.SeleniumUtils;

public class TestSec50TestServerSf extends BaseTest {
	LoginPageEvents loginPg = new LoginPageEvents();
	Sec50UatSfEvents sec50 = new Sec50UatSfEvents();

	@BeforeTest
	@Parameters("browser")
	public void beforeTestMethod(String browser) {
		// Override the report name and document title for this class
		reportName = "Sec50TestServerSf.html";
		documentTitle = "Section 50 Front Office";
		// Call the base class setup
		super.beforeTestMethod(browser);
	}

	@Test(priority = '1', enabled = true)
	public void OpenWestminsterBoUrl(Method methodName) {
		logger = extent.createTest(methodName.getName());

		// Opening Westminster backoffice login page url
		driver.get(Constants.westminsterTestServerSfLoginUrl);
		String loginMessage = loginPg.enterLoginCredentials(driver, "donchandila334@gmail.com", "Gourav@334");
		Assert.assertEquals(loginMessage, "Login successful");
		logger.info(loginMessage);
		logger.info("Enter section 50 url :");
		SeleniumUtils.someDelay(1000);
		driver.get(Constants.section50TestServerSfUrl);
		SeleniumUtils.someDelay(1000);
		logger.info("Current url is : " + driver.getCurrentUrl());

	}

	@Test(priority = '2', enabled = false)
	public void confirmInformationTrue(Method methodName) {
		logger = extent.createTest(methodName.getName());
		String Message = sec50.confirmInfoIsTrue(driver);
		String expectedMessage = "Please confirm the above is true : Clicked";
		Assert.assertEquals(expectedMessage, Message);
		logger.info(Message);
	}

	@Test(priority = '3', enabled = true)
	public void fillingApplicationDates(Method methodName) {
		logger = extent.createTest(methodName.getName());
		String startDate = "21/05/2024";
		String endDate = "30/05/2024";
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

	@Test(priority = '4', enabled = true)
	public void fillingSiteDetails(Method methodName) {
		logger = extent.createTest(methodName.getName());
		String streetNamePostcode = "VICTORIA EMBANKMENT";// which to be searched or SW1E6AA
		String streetNameOptionXpathValue = "VICTORIA EMBANKMENT"; // xpath value its dynamic
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

	}

	@Test(priority = '5', enabled = false)
	public void fillAboutTheWorkSection(Method methodName) {

		logger = extent.createTest(methodName.getName());
		String expectedMessage = "Success: About the work filled successfully";
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
	public void addDeclarations(Method methodName) {
		logger = extent.createTest(methodName.getName());
		String expectedMessage = "Success: Declarations filled successfully";
		String declarationDetailsMessage = sec50.fillDeclaration(driver);
		Assert.assertEquals(expectedMessage, declarationDetailsMessage);
		logger.info(expectedMessage);
	}

	@Test(priority = '9', enabled = false)
	public void payFees(Method methodName) {
		logger = extent.createTest(methodName.getName());
		String expectedMessage = "Payment successful";
		String declarationDetailsMessage = sec50.payApplicationFee(driver, "");
		Assert.assertEquals(expectedMessage, declarationDetailsMessage);
		logger.info(expectedMessage);

	}
}
