package base;

import org.openqa.selenium.WebDriver;

import pageObjects.PremiseApplicationElements;
import pageObjects.Section50PageElementsBo;
import utils.ElementFetch;
import utils.SeleniumUtils;

public abstract class PremiseApplicationBase {
	ElementFetch ele = new ElementFetch();
	
	public abstract String fillBusinessDetails(String partyId, String businessEmail);
	
	public String confirmInfoIsTrue(WebDriver driver) {
		try {
			SeleniumUtils.scrollToElement(driver, "xpath", PremiseApplicationElements.confirmInfoLabel);
			SeleniumUtils.someDelay(1000);
			ele.getWebElement("xpath",PremiseApplicationElements.noTogglebutton).click();

			return "Please confirm the above is true : Clicked";
		} catch (Exception e) {
			return "Error : There are some problem" + e.getMessage();
		}

	}

	public String fillLicenceDuration(WebDriver driver, String startDate, String endDate) {
		try {
			SeleniumUtils.someDelay(2000);
			// Scroll to the licence section for better visibility
			SeleniumUtils.scrollToElement(driver, "xpath",PremiseApplicationElements.licenceSectionLabel);

			// Wait for a short period to ensure page stability
			Thread.sleep(3000);

			// Fill in the application start date
			ele.getWebElement("XPATH",PremiseApplicationElements.licenceStartDate).sendKeys(startDate);

			// Fill in the application end date
			ele.getWebElement("XPATH",PremiseApplicationElements.licenceEndDate).sendKeys(endDate);
			// Return success message
			return String.format("Success: Licence duration dates filled successfully. Start date: %s End date: %s",
					startDate, endDate);

		} catch (Exception e) {
			// Handle thread interruption gracefully
			Thread.currentThread().interrupt();
			return "Error: Some error occured " + e.getMessage();

		}
	}
}
