//BaseClass.java
package base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.Section50PageElementsBo;
import utils.ElementFetch;
import utils.SeleniumUtils;

public abstract class Section50Base {
	ElementFetch ele = new ElementFetch();

	public String fillBusinessDetails(String partyId, String businessEmail) {
		try {
			// Fill in the application start date
			ele.getWebElement("ID", Section50PageElementsBo.businessSearchInputField).sendKeys(businessEmail);
			ele.getWebElement("XPATH", Section50PageElementsBo.businessDetailsSearchButton).click();
			ele.getWebElement("ID", Section50PageElementsBo.businessModalSearchButton).click();
			SeleniumUtils.someDelay(2000);
			ele.getWebElement("XPATH", Section50PageElementsBo.businessModalSelectButton2(partyId, businessEmail))
					.click();

			return "Success: Customer search successfully";
		} catch (Exception e) {
			// Handle thread interruption gracefully
			Thread.currentThread().interrupt();
			return "Error: Some error occured " + e.getMessage();

		}
	}

	public abstract String confirmInfoIsTrue(WebDriver driver);

	public String fillApplicationDates(WebDriver driver, String startDate, String endDate) {
		try {
			SeleniumUtils.someDelay(2000);
			// Scroll to the application section for better visibility
			SeleniumUtils.scrollToElement(driver, "xpath", Section50PageElementsBo.applicationSectionLabel);

			// Wait for a short period to ensure page stability
			Thread.sleep(3000);

			// Fill in the application start date
			ele.getWebElement("XPATH", Section50PageElementsBo.applicationStartDate).sendKeys(startDate);

			// Fill in the application end date
			ele.getWebElement("XPATH", Section50PageElementsBo.applicationEndDate).sendKeys(endDate);
			// Return success message
			return String.format("Success: Application dates filled successfully. Start date: %s End date: %s",
					startDate, endDate);

		} catch (Exception e) {
			// Handle thread interruption gracefully
			Thread.currentThread().interrupt();
			return "Error: Some error occured " + e.getMessage();

		}
	}

	public String fillSiteDetails(WebDriver driver, String streetNamePostcode, String streetNamePostcodeOption) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3)); // 10 seconds wait time
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath(Section50PageElementsBo.siteDetailsSection)));

			// This is for send values to be searched on 'Street name or postcode'
			ele.getWebElement("XPATH", Section50PageElementsBo.streetNamePoostcodeInput).sendKeys(streetNamePostcode);
			SeleniumUtils.someDelay(2000);
			// this is for select options from dropdown
			ele.getWebElement("XPATH", Section50PageElementsBo.streetNamePostCodeOption(streetNamePostcodeOption))
					.click();
			ele.getWebElement("ID", Section50PageElementsBo.locationInputField).sendKeys("test location");
			Thread.sleep(2000);

			uploadDocument(driver, "C:\\Users\\Gaurav\\Desktop\\blank.png",Section50PageElementsBo.trafficPlanBrowseFile);

			return String.format("Success: Site details filled successfully.");

		} catch (Exception e) {
			// Handle any unexpected exceptions
			return "Error: Unexpected error occurred - " + e.getMessage();
		}

	}

	public String supervisorDetails(WebDriver driver) {
		try {
			// Scroll to the application section for better visibility
			SeleniumUtils.scrollToElement(driver, "xpath", Section50PageElementsBo.supervisorDetailsLabel);
			SeleniumUtils.someDelay(2000);
			ele.getWebElement("ID", Section50PageElementsBo.addSupervisorDetailsButton).click();
			SeleniumUtils.someDelay(1000);
			ele.getWebElement("ID", Section50PageElementsBo.supervisorFirstNameInput).sendKeys("1234First_name");
			ele.getWebElement("ID", Section50PageElementsBo.supervisorSurnameInput).sendKeys("1234Surname");
			ele.getWebElement("ID", Section50PageElementsBo.supervisorTelephoneInput).sendKeys("98353423874563");
			ele.getWebElement("ID", Section50PageElementsBo.supervisorNrwsaCardInput).sendKeys("2345");
			uploadDocument(driver, "C:\\Users\\Gaurav\\Desktop\\blank.png",Section50PageElementsBo.supervisorChooseFile);

			return "Success: Supervisor details filled successfully";
		} catch (Exception e) {
			return "Error: Unexpected error occurred - " + e.getMessage();
		}
	}

	public String operatorDetails(WebDriver driver) {
		try {
			// Scroll to the application section for better visibility
			SeleniumUtils.scrollToElement(driver, "xpath", Section50PageElementsBo.operatorDetailsLabel);
			SeleniumUtils.someDelay(3000);
			ele.getWebElement("ID", Section50PageElementsBo.addoperatorDetailsButton).click();
			SeleniumUtils.someDelay(1000);
			ele.getWebElement("ID", Section50PageElementsBo.operatorFirstNameInput).sendKeys("1234First_name");
			ele.getWebElement("ID", Section50PageElementsBo.operatorSurnameInput).sendKeys("1234Surname");
			ele.getWebElement("ID", Section50PageElementsBo.operatorTelephoneInput).sendKeys("98353423874563");
			ele.getWebElement("ID", Section50PageElementsBo.operatorNrwsaCardInput).sendKeys("2345");
			uploadDocument(driver, "C:\\Users\\Gaurav\\Desktop\\blank.png",Section50PageElementsBo.operatorChooseFile);
			return "Success: Operator details filled successfully";
		} catch (Exception e) {
			return "Error: Unexpected error occurred - " + e.getMessage();
		}
	}

	public String aboutTheWork(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3)); // 10 seconds wait time
		try {
			// Check element is visible
			wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath(Section50PageElementsBo.aboutTheWorkLabel)));
			ele.getWebElement("ID", Section50PageElementsBo.aboutTheWorkDescription).sendKeys("Test work description");
			ele.getWebElement("ID", Section50PageElementsBo.aboutTheWorkFootwayOption).click();
			ele.getWebElement("XPATH", Section50PageElementsBo.aboutTheWorkRoadClosureNoOption).click();
			ele.getWebElement("ID", Section50PageElementsBo.aboutTheWorkTrafficDescription)
					.sendKeys("Test description of traffic management");
			return "Success: About the work filled successfully";
		} catch (Exception e) {
			return "Error: Unexpected error occurred - " + e.getMessage();
		}
	}

	public String fillDeclaration(WebDriver driver) {
		try {
			// Scroll to the application section for better visibility
			SeleniumUtils.scrollToElement(driver, "xpath", Section50PageElementsBo.declarationHeading);
			SeleniumUtils.someDelay(2000);
			ele.getWebElement("XPATH", Section50PageElementsBo.addDeclarationButton).click();
			SeleniumUtils.someDelay(2000);

			ele.getWebElement("XPATH", Section50PageElementsBo.addDeclarationModalTermsAndConditionCheckBox).click();
			SeleniumUtils.someDelay(2000);
			ele.getWebElement("XPATH", Section50PageElementsBo.addDeclarationModalFullName).sendKeys("test name");
			ele.getWebElement("XPATH", Section50PageElementsBo.addDeclarationModalConfirmationCheckBox).click();
			ele.getWebElement("XPATH", Section50PageElementsBo.addDeclarationModalCompanyName)
					.sendKeys("test company name");
			ele.getWebElement("XPATH", Section50PageElementsBo.addDeclarationModalPosition).sendKeys("test position");
			ele.getWebElement("XPATH", Section50PageElementsBo.saveDeclarationButton).click();
			SeleniumUtils.someDelay(1000);
			ele.getWebElement("XPATH", Section50PageElementsBo.declarationDataProtectionToggleButton).click();
			return "Success: Declarations filled successfully";
		} catch (Exception e) {
			return "Error: Unexpected error occurred - " + e.getMessage();
		}
	}

	public abstract String payApplicationFee(WebDriver driver, String paymentMethod);

	public void uploadDocument(WebDriver driver, String fullFilePath, String elementLocatorValue) {
		if (elementLocatorValue.equals("traffic_plan_input")) {
			ele.getWebElement("ID", elementLocatorValue).sendKeys(fullFilePath);
			ele.getWebElement("ID", Section50PageElementsBo.trafficPlanDescriptionInputField).sendKeys("Test");
			ele.getWebElement("ID", Section50PageElementsBo.trafficPlanUploadButton).click();
		} else if (elementLocatorValue.equals("supervisor_card_input")) {
			ele.getWebElement("ID", elementLocatorValue).sendKeys(fullFilePath);
			ele.getWebElement("ID", Section50PageElementsBo.supervisorCardSide).click();
			ele.getWebElement("XPATH", Section50PageElementsBo.supervisorCardSideOption).click();
			ele.getWebElement("ID", Section50PageElementsBo.supervisorUploadButton).click();
			// for backcard
			ele.getWebElement("ID", Section50PageElementsBo.supervisorCardSide).click();
			ele.getWebElement("XPATH", Section50PageElementsBo.supervisorBackCardSideOption).click();
			ele.getWebElement("ID", Section50PageElementsBo.supervisorUploadButton).click();
			SeleniumUtils.someDelay(3000);
			ele.getWebElement("ID", Section50PageElementsBo.supervisorSaveDetailsButton).click();
		} else if (elementLocatorValue.equals("operator_card_input")) {
			ele.getWebElement("ID", elementLocatorValue).sendKeys(fullFilePath);
			ele.getWebElement("ID", Section50PageElementsBo.operatorCardSide).click();
			ele.getWebElement("XPATH", Section50PageElementsBo.operatorCardSideOption).click();
			ele.getWebElement("ID", Section50PageElementsBo.operatorUploadButton).click();
			// for backcard
			ele.getWebElement("ID", Section50PageElementsBo.operatorCardSide).click();
			ele.getWebElement("XPATH", Section50PageElementsBo.operatorBackCardSideOption).click();
			ele.getWebElement("ID", Section50PageElementsBo.operatorUploadButton).click();
			SeleniumUtils.someDelay(3000);
			ele.getWebElement("ID", Section50PageElementsBo.operatororSaveDetailsButton).click();
		}
	}

}
