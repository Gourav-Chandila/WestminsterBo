package pageEvents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.PremiseApplicationBase;
import pageObjects.PremiseApplicationElements;
import utils.ElementFetch;
import utils.SeleniumUtils;

public class PremiseAppSfEvents extends PremiseApplicationBase {
	ElementFetch ele = new ElementFetch();

	@Override
	public String fillBusinessDetails(String partyId, String businessEmail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addPayment(WebDriver driver,String paymentMethod) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		
			// Clicking on the first element
			WebElement payAndSubmitButton = wait.until(ExpectedConditions.elementToBeClickable(By.id(PremiseApplicationElements.payAndSubmitButton)));
			payAndSubmitButton.click();
			// Clicking on the second element
			WebElement paymentOKButton = wait.until(
			ExpectedConditions.elementToBeClickable(By.xpath(PremiseApplicationElements.paymentOKButton)));
			paymentOKButton.click();
//			 Clicking on the third element
			WebElement cardPayButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PremiseApplicationElements.cardPaySummaryButton)));
			cardPayButton.click();
			
			return "Payment successful";
		} catch (Exception e) {
			return "Error :" + e.getMessage();
		}
	}

}
