package pageEvents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import base.TENsApplicationBase;
import pageObjects.TENsPageElements;

public class TENSPageSfEvents extends TENsApplicationBase{

	@Override
	public String addPayment(WebDriver driver,String paymentMethod) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));

			// Clicking on the first element
			WebElement payAndSubmitButton = wait.until(ExpectedConditions.elementToBeClickable(By.id(TENsPageElements.payAndSubmitButton)));
			payAndSubmitButton.click();

            // Clicking on the third party pay  button
			WebElement cardPayButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(TENsPageElements.cardPaySummaryButton)));
			cardPayButton.click();
			
			return "Payment successful";
		} catch (Exception e) {
			return "Error :" + e.getMessage();
		}
	}
	
	@Override
	public String fillBusinessDetails(String partyId, String businessEmail) {
		return null;
	}

	
}

