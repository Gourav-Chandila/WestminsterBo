package pageEvents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageObjects.DashboardPageElements;
import utils.ElementFetch;
import utils.SeleniumUtils;

public class DashboardPageEvents {
	ElementFetch ele = new ElementFetch();

	public String checkDashboardDisplaying() {
		try {
			WebElement streetTradingDashboard = ele.getWebElement("XPATH",
					DashboardPageElements.streetTradingDashboard);
			return streetTradingDashboard.getText();

		} catch (Exception e) {
			return "Error: Unexpected error occurred in dashboard page :" + e.getMessage();
		}
	}

	public String clickOnHighwaysNavLink() {
		try {
			ele.getWebElement("XPATH", DashboardPageElements.highwaysNavLink).click();
			return "Success: Highways link clicked successfully";
		} catch (Exception e) {
			return "Error: Unexpected error occurred in dashboard page :" + e.getMessage();
		}

	}

	public String clickOnApplicationType(WebDriver driver, String licenseId) {
		try {
			ele.getWebElement("XPATH", DashboardPageElements.highwaysNavLink).click();
			SeleniumUtils.scrollToElement(driver, "xpath", DashboardPageElements.licencesSection);
			SeleniumUtils.someDelay(3000);
			ele.getWebElement("XPATH", DashboardPageElements.section50ApplicationType).click();
			SeleniumUtils.someDelay(3000);
			ele.getWebElement("XPATH", DashboardPageElements.viewApplicationButton(licenseId)).click();
			SeleniumUtils.scrollToBottom("body");

			return "Success: Section 50 application type clicked successfylly";
		} catch (Exception e) {
			return "Error: Unexpected error occurred in dashboard page " + e.getMessage();
		}
	}
}
