package qa.test;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTest;
import junit.framework.Assert;
import pageEvents.LoginPageEvents;
import pageEvents.PremiseAppSfEvents;
import pageEvents.PremiseAppSfboEvents;
import utils.Constants;
import utils.SeleniumUtils;

public class TestPremiseAppUatSfbo extends BaseTest {
	LoginPageEvents loginPg = new LoginPageEvents();
	PremiseAppSfboEvents premise = new PremiseAppSfboEvents();

	@BeforeTest
	@Parameters("browser")
	public void beforeTestMethod(String browser) {
		// Override the report name and document title for this class
		reportName = "PremiseApplicationUatSfbo.html";
		documentTitle = "PremiseApplication Back Office";
		// Call the base class setup
		super.beforeTestMethod(browser);
	}

	@Test(priority = '1', enabled = true)
	public void openLa_03LoginUrl(Method methodName) {
		logger = extent.createTest(methodName.getName());

		// Opening Westminster backoffice login page url
		driver.get(Constants.La_03UatSfboLoginUrl);
		String loginMessage = loginPg.enterLoginCredentials(driver, "mdickinson", "ofbiz");
		Assert.assertEquals(loginMessage, "Login successful");
		logger.info(loginMessage);
		logger.info("Enter Premise application url :");
		SeleniumUtils.someDelay(1000);
		driver.get(Constants.La_03PremiseAppUatSfbo);
		SeleniumUtils.someDelay(1000);
		logger.info("Current url is : " + driver.getCurrentUrl());
	}

	@Test(priority = '2', enabled = false)
	public void fillBusinessDetails(Method methodName) {
		logger = extent.createTest(methodName.getName());
		String businessDetailsMessage = premise.fillBusinessDetails("40283", "donchandila334@gmail.com");
		logger.info(driver.getCurrentUrl());
		logger.info(businessDetailsMessage);

	}

	@Test(priority = '3', enabled = false)
	public void confirmInformationTrue(Method methodName) {
		logger = extent.createTest(methodName.getName());
		String Message = premise.confirmInfoIsTrue(driver);
		String expectedMessage = "Please confirm the above is true : Clicked";
		Assert.assertEquals(expectedMessage, Message);
		logger.info(Message);
	}

	@Test(priority = '4', enabled = false)
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

	@Test(priority = '4', enabled = true)
	public void fillingApplicantDetails(Method methodName) {
		logger = extent.createTest(methodName.getName());
		String business="Other";//Accepts Test Business name,Other
		String otherApplicant="health_service_applicant";//individual_applicant,limited_company_applicant,partnership_applicant, unincoporated_applicant,other_applicant,recognised_club_applicant,charity_applicant,educational_applicant,health_service_applicant,registered_individual_wales_applicant,registered_individual_wales_applicant,registered_individual_england_applicant,chief_officer_applicant
		String ApplicantCheckbox="applicant_type_carry_on";//Accepts applicant_type_carry_on,applicant_type_function_discharged
		String shadowCheckbox="product_type_neither";//Accepts product_type_neither,product_type_shadow,product_type_provisional
		String Message = premise.fillApplicantDetails(driver,business,otherApplicant,ApplicantCheckbox,shadowCheckbox);// takes args Test Business
																					// name,Other
		String expectedMessage = "Applicant details filled successfully";
		Assert.assertEquals(expectedMessage, Message);
		logger.info(Message);
	}
	
	@Test(priority = '4', enabled = true)
	public void fillingDesignatedPremisesSupervisor(Method methodName) {
		logger = extent.createTest(methodName.getName());
		String Message = premise.designatedPremisesSupervisor(driver);							
		String expectedMessage = "Success: Designated Premises Supervisor filled successfully";
		Assert.assertEquals(expectedMessage, Message);
		logger.info(Message);
	}
	
	

}
