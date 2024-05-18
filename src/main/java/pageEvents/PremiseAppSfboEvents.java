package pageEvents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.PremiseApplicationBase;
import pageObjects.PremiseApplicationElements;
import pageObjects.Section50PageElementsBo;
import utils.ElementFetch;
import utils.SeleniumUtils;

public class PremiseAppSfboEvents extends PremiseApplicationBase {
	ElementFetch ele = new ElementFetch();

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

	@Override
	public String addPayment(WebDriver driver,String paymentMethod) {
		try {
		SeleniumUtils.scrollToElement(driver, "xpath", Section50PageElementsBo.paymentLabel);
		SeleniumUtils.someDelay(2000);
		ele.getWebElement("XPATH", PremiseApplicationElements.paymentInFullToggleButton).click();
		ele.getWebElement("XPATH", PremiseApplicationElements.paymentMethodDropdown).click();
		ele.getWebElement("XPATH", PremiseApplicationElements.selectPaymentMethod(paymentMethod)).click();
		ele.getWebElement("ID", PremiseApplicationElements.payAndSubmitButton).click();
		SeleniumUtils.someDelay(1000);
		ele.getWebElement("XPATH", PremiseApplicationElements.paymentOKButton).click();
		return "Success : Payment successfull";
		}catch(Exception e) {
			return "Error :"+e.getMessage();
		}
	}

}
