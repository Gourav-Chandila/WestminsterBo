package pageEvents2;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import pageObjects.LoginPageElements;
import utils.ElementFetch;
import utils.SeleniumUtils;

public class LoginPageEvents2 {
	ElementFetch ele = new ElementFetch();

	public String enterLoginCredentials2(WebDriver driver, String email, String password) {
		try {
			ele.getWebElement("id", LoginPageElements.emailInputField).sendKeys(email);
			ele.getWebElement("id", LoginPageElements.passwordInputField).sendKeys(password);
			SeleniumUtils.someDelay(1000);
			ele.getWebElement("xpath", LoginPageElements.submitButton).click();

		} catch (Exception e) {
			return "Error: Unexpected error occurred while login";
		}
		return "Login successful";
	}
}