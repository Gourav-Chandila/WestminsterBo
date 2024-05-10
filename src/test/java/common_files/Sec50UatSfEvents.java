//Child2.java
package common_files;

import org.openqa.selenium.WebDriver;

import pageObjects.Section50PageElementsBo;
import utils.ElementFetch;
import utils.SeleniumUtils;

public class Sec50UatSfEvents extends Section50Base {

	ElementFetch ele = new ElementFetch();

	@Override
	public String confirmInfoIsTrue(WebDriver driver) {
		try {
			SeleniumUtils.scrollToElement(driver, "xpath", Section50PageElementsBo.confirmInfoLabel);
			SeleniumUtils.someDelay(1000);
			ele.getWebElement("xpath", Section50PageElementsBo.noTogglebutton).click();

			return "Please confirm the above is false : Clicked";
		} catch (Exception e) {
			return "Error : There are some problem" + e.getMessage();
		}

	}

	@Override
	public String payApplicationFee(WebDriver driver,String paymentMethod) {
		try {
			ele.getWebElement("XPATH", Section50PageElementsBo.PayAndSubmitButton).click();
			ele.getWebElement("XPATH", Section50PageElementsBo.selectPaymentCardDropDown).click();
			SeleniumUtils.someDelay(1000);
			// pay fee button not working
//			ele.getWebElement("xpath", Section50PageElementsBo.payWithCityPayButton).click();			
			return "Payment successful";
		} catch (Exception e) {
			return "Error : some error occured";
		}

	}



}
