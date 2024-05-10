package pageEvents;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import pageObjects.LoginPageElements;
import utils.ElementFetch;

public class LoginPageEvents {
	ElementFetch ele = new ElementFetch();

	public String enterLoginCredentials(WebDriver driver, String email, String password) {
		try {
			ele.getWebElement("ID", LoginPageElements.emailInputField).sendKeys(email);
			ele.getWebElement("ID", LoginPageElements.passwordInputField).sendKeys(password);
			ele.getWebElement("XPATH", LoginPageElements.submitButton).click();

		} catch (Exception e) {
			return "Error: Unexpected error occurred while login"+e.getMessage();
		}
		return "Login successful";
	}
}
