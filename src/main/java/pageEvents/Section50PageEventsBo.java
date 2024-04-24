package pageEvents;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import base.BaseTest;
import pageObjects.Section50PageElementsBo;
import utils.ElementFetch;
import utils.SeleniumUtils;

public class Section50PageEventsBo {
	ElementFetch ele = new ElementFetch();
	BaseTest base = new BaseTest();

	public String fillBusinessDetails() {
		try {
			// Fill in the application start date
			ele.getWebElement("ID", Section50PageElementsBo.businessSearchInputField).sendKeys("test@fgl.com");
			ele.getWebElement("XPATH", Section50PageElementsBo.businessDetailsSearchButton).click();
			ele.getWebElement("ID", Section50PageElementsBo.businessModalSearchButton).click();
			SeleniumUtils.someDelay(2000);
			ele.getWebElement("XPATH", Section50PageElementsBo.businessModalSelectButton).click();

			return "Success: Customer search successfully";
		} catch (Exception e) {
			// Handle thread interruption gracefully
			Thread.currentThread().interrupt();
			return "Error: Some error occured " + e.getMessage();

		}
	}

	public String fillApplicationDates(WebDriver driver, String startDate, String endDate) {
		try {

			// Scroll to the application section for better visibility
			SeleniumUtils.scrollToElement(driver, "xpath", Section50PageElementsBo.applicationSectionLabel);

			// Wait for a short period to ensure page stability
			Thread.sleep(1000);

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

			// Scroll to the application section for better visibility
			SeleniumUtils.scrollToElement(driver, "xpath", Section50PageElementsBo.siteDetailsSection);

			// Wait for a short period to ensure page stability
			Thread.sleep(1000);
			// This is for send values to be searched on 'Street name or postcode'
			ele.getWebElement("XPATH", Section50PageElementsBo.streetNamePoostcodeInput).sendKeys(streetNamePostcode);
			Thread.sleep(2000);
			// this is for select options from dropdown
			ele.getWebElement("XPATH", Section50PageElementsBo.streetNamePostCodeOption(streetNamePostcodeOption))
					.click();

			// Scroll to the section
//			SeleniumUtils.scrollToElement(driver, "xpath", Section50PageElementsBo.locationLabelSection);
			// Wait for a short period to ensure page stability
			Thread.sleep(1000);
			ele.getWebElement("ID", Section50PageElementsBo.locationInputField).sendKeys("test location");

			SeleniumUtils.scrollToElement(driver, "xpath", Section50PageElementsBo.trafficManagementPlanSection);
			// Wait for a short period to ensure page stability
			Thread.sleep(2000);

			// function call for upload docs
			uploadDocument(driver, "\\CSS_Complete_Notes.pdf", "traffic_plan_input");
//			uploadDocument(driver, "\\java_collections.pdf", "pli_certificate_input");

			return String.format("Success: Site details filled successfully.");

		} catch (Exception e) {
			// Handle any unexpected exceptions
			return "Error: Unexpected error occurred - " + e.getMessage();
		}

	}

	public String aboutTheWork(WebDriver driver) {
		try {
			// Scroll to the application section for better visibility
			SeleniumUtils.scrollToElement(driver, "xpath", Section50PageElementsBo.aboutTheWorkLabel);
			SeleniumUtils.someDelay(1000);
			ele.getWebElement("ID", Section50PageElementsBo.aboutTheWorkDescription).sendKeys("Test work description");
			ele.getWebElement("ID", Section50PageElementsBo.aboutTheWorkFootwayOption).click();
			ele.getWebElement("ID", Section50PageElementsBo.aboutTheWorkRoadClosureNoOption).click();
			ele.getWebElement("ID", Section50PageElementsBo.aboutTheWorkTrafficDescription)
					.sendKeys("Test description of traffic management");
			return "Success: About the works filled successfully";
		} catch (Exception e) {
			return "Error: Unexpected error occurred - " + e.getMessage();
		}
	}

	public String supervisorDetails(WebDriver driver) {
		try {
			// Scroll to the application section for better visibility
			SeleniumUtils.scrollToElement(driver, "xpath", Section50PageElementsBo.supervisorDetailsLabel);
			SeleniumUtils.someDelay(3000);
			ele.getWebElement("ID", Section50PageElementsBo.addSupervisorDetailsButton).click();
			SeleniumUtils.someDelay(1000);
			ele.getWebElement("ID", Section50PageElementsBo.supervisorFirstNameInput).sendKeys("1234First_name");
			ele.getWebElement("ID", Section50PageElementsBo.supervisorSurnameInput).sendKeys("1234Surname");
			ele.getWebElement("ID", Section50PageElementsBo.supervisorTelephoneInput).sendKeys("98353423874563");
			ele.getWebElement("ID", Section50PageElementsBo.supervisorNrwsaCardInput).sendKeys("2345");

			uploadDocument(driver, "\\adhar.jpg", "supervisor_card_input");
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

			uploadDocument(driver, "\\adhar.jpg", "operator_card_input");
			return "Success: Operator details filled successfully";
		} catch (Exception e) {
			return "Error: Unexpected error occurred - " + e.getMessage();
		}
	}

	public String orderSummary(WebDriver driver) {
		try {
			// Scroll to the application section for better visibility
			SeleniumUtils.scrollToElement(driver, "xpath", Section50PageElementsBo.orderSummaryLabel);
			SeleniumUtils.someDelay(3000);
			WebElement orderPrice = ele.getWebElement("XPATH", Section50PageElementsBo.orderSummaryPrice);

			return orderPrice.getText();

		} catch (Exception e) {
			return "Error: Unexpected error occurred - " + e.getMessage();
		}
	}

	public String Payment(WebDriver driver, String paymentMethod) {
		try {
			SeleniumUtils.scrollToElement(driver, "xpath", Section50PageElementsBo.paymentLabel);
			SeleniumUtils.someDelay(3000);
			ele.getWebElement("XPATH", Section50PageElementsBo.paymentInFullToggleButton).click();
			ele.getWebElement("XPATH", Section50PageElementsBo.paymentMethodDropdown).click();
			ele.getWebElement("XPATH", Section50PageElementsBo.selectPaymentMethod(paymentMethod)).click();
			return "Success: Payment method successfully selected";
		} catch (Exception e) {
			return "Error: Some error occured." + e.getMessage();
		}
	}

	public String fillDeclaration(WebDriver driver) {
		try {
			// Scroll to the declaration heading to ensure the button is visible
			SeleniumUtils.scrollToElement(driver, "xpath", Section50PageElementsBo.declarationHeading);
			SeleniumUtils.someDelay(2000); // Wait for scrolling to complete (optional)

			// Attempt to click the "addDeclarationButton" element using JavaScript
			WebElement addDeclarationButton = ele.getWebElement("XPATH", Section50PageElementsBo.addDeclarationButton);
			if (addDeclarationButton.isDisplayed() && addDeclarationButton.isEnabled()) {
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", addDeclarationButton);

				ele.getWebElement("XPATH", Section50PageElementsBo.addDeclarationModalTermsAndConditionCheckBox)
						.click();
				ele.getWebElement("XPATH", Section50PageElementsBo.addDeclarationModalConfirmationCheckBox).click();
				ele.getWebElement("XPATH", Section50PageElementsBo.addDeclarationModalFullName).sendKeys("12324");
				ele.getWebElement("XPATH", Section50PageElementsBo.addDeclarationModalCompanyName).sendKeys("54235");
				ele.getWebElement("XPATH", Section50PageElementsBo.addDeclarationModalPosition).sendKeys("43svf");
				ele.getWebElement("XPATH", Section50PageElementsBo.saveDeclarationButton).click();

				// Click the "dataProtection" element using JavaScript
				WebElement dataProtection = ele.getWebElement("XPATH",
						Section50PageElementsBo.declarationDataProtectionToggleButton);
				if (dataProtection.isDisplayed() && dataProtection.isEnabled()) {
					JavascriptExecutor executor1 = (JavascriptExecutor) driver;
					executor1.executeScript("arguments[0].click();", dataProtection);
					SeleniumUtils.someDelay(1000); // Delay after clicking (optional)
				} else {
					return "Error: The data protection toggle button is not clickable.";
				}
				return "Success: Declaration filled successfully";
			} else {
				return "Error: The add declaration button is not clickable.";
			}
		} catch (Exception e) {
			return "Error: Some error occurred." + e.getMessage();
		}
	}

	public void uploadDocument(WebDriver driver, String filePath, String selectorValue) {
		// Get the WebElement for the upload button
		WebElement Upload = ele.getWebElement("ID", Section50PageElementsBo.uploadFile(selectorValue));

		// Initialize Actions class
		Actions act = new Actions(driver);

		// Move to the specific upload button and click it
		act.moveToElement(Upload).click().perform();

		try {
			// Add a delay to allow the file upload dialog to open
			SeleniumUtils.someDelay(2000);
			String scriptPath = "C://Users//Gaurav//Desktop//SeleniumTesting//AutoPilot editor scripts//TrafficPlanManagementFileUpload.exe";
			// Execute the AutoIt script to handle file upload
			Runtime.getRuntime().exec(scriptPath + " " + filePath);
			if (selectorValue.equals("traffic_plan_input")) {
				ele.getWebElement("ID", Section50PageElementsBo.trafficPlanDescriptionInputField).sendKeys("Test");
				SeleniumUtils.someDelay(2000);
				ele.getWebElement("ID", Section50PageElementsBo.trafficPlanUploadButton).click();
			}
//			else if (selectorValue.equals("pli_certificate_input")) { was removed by ui
//				ele.getWebElement("ID", Section50PageElementsBo.publicLiabilityStartDate).sendKeys("10/04/2024");
//				ele.getWebElement("ID", Section50PageElementsBo.publicLiabilityEndDate).sendKeys("06/04/2024");
//				SeleniumUtils.someDelay(2000);
//				ele.getWebElement("ID", Section50PageElementsBo.publicLiabilityUploadButton).click();
//				SeleniumUtils.someDelay(10000);
//			} 
			else if (selectorValue.equals("supervisor_card_input")) {
				SeleniumUtils.someDelay(3000);
				ele.getWebElement("ID", Section50PageElementsBo.supervisorCardSide).click();
				SeleniumUtils.someDelay(3000);
				ele.getWebElement("XPATH", Section50PageElementsBo.supervisorCardSideOption).click();
				ele.getWebElement("ID", Section50PageElementsBo.supervisorUploadButton).click();

				// for backcard
				ele.getWebElement("ID", Section50PageElementsBo.supervisorCardSide).click();
				SeleniumUtils.someDelay(3000);
				ele.getWebElement("XPATH", Section50PageElementsBo.supervisorBackCardSideOption).click();
				ele.getWebElement("ID", Section50PageElementsBo.supervisorUploadButton).click();

				SeleniumUtils.someDelay(4000);
				ele.getWebElement("ID", Section50PageElementsBo.supervisorSaveDetailsButton).click();
				SeleniumUtils.someDelay(4000);
			} else if (selectorValue.equals("operator_card_input")) {
				SeleniumUtils.someDelay(3000);
				ele.getWebElement("ID", Section50PageElementsBo.operatorCardSide).click();
				SeleniumUtils.someDelay(3000);
				ele.getWebElement("XPATH", Section50PageElementsBo.operatorCardSideOption).click();
				ele.getWebElement("ID", Section50PageElementsBo.operatorUploadButton).click();

				// for backcard
				ele.getWebElement("ID", Section50PageElementsBo.operatorCardSide).click();
				SeleniumUtils.someDelay(3000);
				ele.getWebElement("XPATH", Section50PageElementsBo.operatorBackCardSideOption).click();
				ele.getWebElement("ID", Section50PageElementsBo.operatorUploadButton).click();

				SeleniumUtils.someDelay(3000);
				ele.getWebElement("ID", Section50PageElementsBo.operatororSaveDetailsButton).click();
				SeleniumUtils.someDelay(2000);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
