package pageEvents;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import pageObjects.LoginPageElements;

import utils.ElementFetch;
import utils.SeleniumUtils;

public class LoginPageEvents {
	ElementFetch ele = new ElementFetch();

	public String enterLoginCredentials(WebDriver driver) {
		try {
			// Another method
			Actions actions = new Actions(driver);
			actions.sendKeys("gwise").perform();
			actions.sendKeys(Keys.TAB).perform();
			actions.sendKeys("pass@123").perform();
			actions.sendKeys(Keys.TAB).perform();
			actions.sendKeys(Keys.ENTER).perform();

		} catch (Exception e) {
			return "Error: Unexpected error occurred while login";
		}
		return "Login successful";
	}
}
