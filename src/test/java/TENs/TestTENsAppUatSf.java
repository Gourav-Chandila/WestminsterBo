package TENs;

import java.lang.reflect.Method;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTest;
import freemarker.core.ParseException;
import junit.framework.Assert;
import pageEvents.LoginPageEvents;
import pageEvents.TENSPageSfEvents;
import utils.Constants;
import utils.SeleniumUtils;

public class TestTENsAppUatSf extends BaseTest {
	LoginPageEvents loginPg = new LoginPageEvents();
	TENSPageSfEvents tens = new TENSPageSfEvents();

	@BeforeTest
	@Parameters("browser")
	public void beforeTestMethod(String browser) {
		// Override the report name and document title for this class
		reportName = "TENsApplicationUatSf.html";
		documentTitle = "Front Office";
		// Call the base class setup
		super.beforeTestMethod(browser);
	}

	@Test(priority = 1, enabled = true)
	public void openLa_03LoginUrl(Method methodName) {
		logger = extent.createTest(methodName.getName());

		// Opening Westminster backoffice login page url
		driver.get(Constants.La_03UatSfLoginUrl);
		String loginMessage = loginPg.enterLoginCredentials(driver, "donchandila334@gmail.com", "Gourav@334");
		Assert.assertEquals(loginMessage, "Login successful");
		logger.info(loginMessage);
		logger.info("Enter Premise application url :");
		SeleniumUtils.someDelay(1000);
		driver.get(Constants.La_03TENsAppUatSf);
		SeleniumUtils.someDelay(1000);
		logger.info("Current url is : " + driver.getCurrentUrl());
	}

	@Test(priority = 2, enabled = true)
	public void confirmInformationtrue(Method methodName) {
		logger = extent.createTest(methodName.getName());
		String Message = tens.confirmInfoIsTrue(driver);
		String expectedMessage = "Please confirm the above is true : Clicked";
		Assert.assertEquals(expectedMessage, Message);
		logger.info(Message);
	}

	@Test(priority = 3, enabled = true)
	public void fillDateTime(Method methodName) {
		logger = extent.createTest(methodName.getName());
		String startDate = "30/08/2024";// end date always same as start date you want to click on it .
		String Message = tens.fillDatesWithTime(driver, startDate);
		String expectedMessage = "Date and time filled successfully";
		Assert.assertEquals(expectedMessage, Message);
		logger.info(Message);
	}

	@Test(priority = 4, enabled = true)
	public void fillPersonalLicence(Method methodName) {
		logger = extent.createTest(methodName.getName());
		String otherRelevantDetails = "test other relevant details";
		String Message = tens.fillPersonalLicence(driver, otherRelevantDetails);
		String expectedMessage = "Personal license filled successfully";
		Assert.assertEquals(expectedMessage, Message);
		logger.info(Message);
	}

	@Test(priority = 4, enabled = true)
	public void fillLicenceActivities(Method methodName) {
		logger = extent.createTest(methodName.getName());
		String adultEntertainment = "test adult ent";
		String activityText = "The sale by retail of alcohol";// Accepts 1.The sale by retail of alcohol
		// 2.The supply of alcohol by or on behalf of a club to, or to the order of, a
		// member of the club
		// 3.The provision of regulated entertainment (Please read note 7)
		// 4.The provision of late night refreshment

		String alcoholConsumption = "Off the Premises";// Accepts On the Premises,Off the Premises
		String licensableLocation = "Indoors";// Accepts Indoors,Outdoors,Both
		String Message = tens.fillLicenceActivities(driver, adultEntertainment, activityText, alcoholConsumption,
				licensableLocation);
		String expectedMessage = "Licence activities filled successfully";
		Assert.assertEquals(expectedMessage, Message);
		logger.info(Message);
		logger.info("Adult entertainment message : " + adultEntertainment);
		if (activityText == "The provision of late night refreshment"
				|| activityText == "The provision of regulated entertainment (Please read note 7)") {
			logger.info("Activity is : " + activityText);
			logger.info("Alcohol consumption : " + alcoholConsumption);
		} else {
			logger.info("Activity is : " + activityText);
			logger.info("Licensable location : " + licensableLocation);
		}
	}

	@Test(priority = 5, enabled = true)
	public void uploadApplicaitonEvidence(Method methodName) {
		logger = extent.createTest(methodName.getName());
		String Message = tens.uploadApplicationEvidence(driver);
		String expectedMessage = "Evidence successfully uploaded";
		Assert.assertEquals(expectedMessage, Message);
		logger.info(Message);

	}

	@Test(priority = 5, enabled = true)
	public void fillPremiseEventDetails(Method methodName) {
		logger = extent.createTest(methodName.getName());
		String address = "Other Address"; // Accepts 1. your address which are logged in 2. Other Address
		String licenceAndCertificateValue = "None"; // Accepts 1.Premises 2.Club Premises 3.None
		Map<String, String> result = tens.fillPremiseEventDetails(driver, address, licenceAndCertificateValue);
		String message = result.get("message");
		String expectedMessage = "Premise/Event Details filled successfully";

		Assert.assertEquals(message, expectedMessage);
		logger.info(message);

		String addressInputValue = result.get("addressInputValue");
		logger.info("Address is : " + address);
		logger.info("Other Address input value is : " + addressInputValue);
		logger.info("Licence   is : " + licenceAndCertificateValue);
	}
	
	@Test(priority = 6, enabled = true)
	public void infoAboutProperty(Method methodName) {
		logger = extent.createTest(methodName.getName());
		String tenInSameYear="Yes";//Accepts Yes,No
		String issuer="test";
		String licenceNO="LICO000";
		String startDate="10/08/2024";
		String endDate="12/08/2024";
		Map<String, String> result= tens.infoAboutProperty(driver,tenInSameYear,issuer,licenceNO,startDate,endDate);
		String message = result.get("message");
		String expectedMessage = "Information about the property filled successfully";
		Assert.assertEquals(expectedMessage, message);
		logger.info(message);
		logger.info("Has any associate of yours given a temporary event notice for an event in the same calendar year? : "+tenInSameYear);
		//if yes prints details in report
		if(tenInSameYear.equals("Yes")) {
			logger.info("Issuer : "+issuer);
			logger.info("Licence no : "+licenceNO);
			logger.info("Licence name : "+result.get("licenceName"));
			logger.info("Start date  : "+startDate);
			logger.info("End date  : "+endDate);
		}

	}
	
	@Test(priority = 7, enabled = true)
	public void addDeclaration(Method methodName) {
		logger = extent.createTest(methodName.getName());
		String Message = tens.addDeclaration(driver);
		String expectedMessage = "Success : Declaration filled successfully";
		Assert.assertEquals(expectedMessage, Message);
		logger.info(Message);

	}
	
	@Test(priority = 8, enabled = true)
	public void addPayment(Method methodName) {
		logger = extent.createTest(methodName.getName());
		String Message = tens.addPayment(driver,"");
		String expectedMessage = "Payment successful";
		Assert.assertEquals(expectedMessage, Message);
		logger.info(Message);

	}

}
