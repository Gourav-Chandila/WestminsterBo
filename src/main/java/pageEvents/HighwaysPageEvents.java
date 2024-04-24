package pageEvents;

import org.openqa.selenium.WebDriver;

import pageObjects.HighwaysPageElements;
import utils.ElementFetch;
import utils.SeleniumUtils;

public class HighwaysPageEvents {
	ElementFetch ele = new ElementFetch();

	public String clickOnSection50Link(WebDriver driver) {
		try {
			SeleniumUtils.scrollToElement(driver, "xpath", HighwaysPageElements.processApplicationHeading);
			SeleniumUtils.someDelay(1000);
			ele.getWebElement("XPATH", HighwaysPageElements.section50Link).click();
			return "Success: Section 50 link clicked successfully";
		} catch (Exception e) {
			return "Error: Unexpected error occurred in highways page :" + e.getMessage();
		}

	}
}
