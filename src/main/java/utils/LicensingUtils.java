package utils;

import org.openqa.selenium.WebDriver;
import pageObjects.Section50PageElementsBo;
import pageObjects.licensingElements;

public class LicensingUtils {
	ElementFetch ele = new ElementFetch();

	// function is used for select business address
	public String fillBusinessDetails(String partyId, String businessEmail) {
		ElementFetch ele = new ElementFetch();
		try {
			// Fill in the application start date
			ele.getWebElement("ID", licensingElements.businessSearchInputField).sendKeys(businessEmail);
			ele.getWebElement("XPATH", licensingElements.businessDetailsSearchButton).click();
			ele.getWebElement("ID", licensingElements.businessModalSearchButton).click();
			SeleniumUtils.someDelay(2000);
			ele.getWebElement("XPATH", licensingElements.businessModalSelectButton2(partyId, businessEmail)).click();
			return "Success: Customer search successfully";
		} catch (Exception e) {
			// Handle thread interruption gracefully
			Thread.currentThread().interrupt();
			return "Error: Some error occured " + e.getMessage();

		}
	}

	// function for upload document give locator value using of XPATH
	public void uploadDocument(String elementLocatorValue) {
		ele.getWebElement("XPATH", elementLocatorValue).sendKeys("C:\\Users\\Gaurav\\Desktop\\test_img.png");
	}

	// Function for entering address details
	public void enterAddressDetails(String addressSearchButton) {
		ele.getWebElement("ID", addressSearchButton).click();
		SeleniumUtils.someDelay(1000);
		ele.getWebElement("ID", licensingElements.otherApplicantPostcode).clear();
		ele.getWebElement("ID", licensingElements.otherApplicantPostcode).sendKeys("SW1A2DG");
		ele.getWebElement("ID", licensingElements.otherApplicantPostcodeSearchButton).click();
		SeleniumUtils.someDelay(2000);
		ele.getWebElement("XPATH", licensingElements.otherApplicantSelectAddress).click();
	}

	// function to click on checkbox only give checkbox id
	public void clickOnCheckBoxes(String checkBoxIdValue) {
		ele.getWebElement("ID", licensingElements.selectDeclarationCheckBox(checkBoxIdValue)).click();
	}

	// Payment of backoffice
	public String addPayment(WebDriver driver, String paymentMethod) {
		try {
			SeleniumUtils.scrollToElement(driver, "xpath", Section50PageElementsBo.paymentLabel);
			SeleniumUtils.someDelay(2000);
			ele.getWebElement("XPATH", licensingElements.paymentInFullToggleButton).click();
			ele.getWebElement("XPATH", licensingElements.paymentMethodDropdown).click();
			ele.getWebElement("XPATH", licensingElements.selectPaymentMethod(paymentMethod)).click();

			ele.getWebElement("ID", licensingElements.payAndSubmitButton).click();
			SeleniumUtils.someDelay(1000);
			ele.getWebElement("XPATH", licensingElements.paymentOKButton).click();
			return "Success : Payment successfull";
		} catch (Exception e) {
			return "Error :" + e.getMessage();
		}
	}
}
