package pageEvents;

import base.PremiseApplicationBase;
import pageObjects.PremiseApplicationElements;
import pageObjects.Section50PageElementsBo;
import utils.ElementFetch;
import utils.SeleniumUtils;

public class PremiseAppSfboEvents extends PremiseApplicationBase {

	@Override
	public String fillBusinessDetails(String partyId, String businessEmail) {
		ElementFetch ele = new ElementFetch();
		try {
			// Fill in the application start date
			ele.getWebElement("ID", PremiseApplicationElements.businessSearchInputField).sendKeys(businessEmail);
			ele.getWebElement("XPATH", PremiseApplicationElements.businessDetailsSearchButton).click();
			ele.getWebElement("ID", PremiseApplicationElements.businessModalSearchButton).click();
			SeleniumUtils.someDelay(2000);
			ele.getWebElement("XPATH", PremiseApplicationElements.businessModalSelectButton2(partyId, businessEmail))
					.click();

			return "Success: Customer search successfully";
		} catch (Exception e) {
			// Handle thread interruption gracefully
			Thread.currentThread().interrupt();
			return "Error: Some error occured " + e.getMessage();

		}
	}

}
