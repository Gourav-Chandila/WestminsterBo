//Child1.java
package pageEvents;

import org.openqa.selenium.WebDriver;

import base.Section50Base;
import pageObjects.Section50PageElementsBo;
import utils.ElementFetch;
import utils.SeleniumUtils;

public class Sec50UatSfboEvents extends Section50Base {
ElementFetch ele = new ElementFetch();
	@Override
	public String confirmInfoIsTrue(WebDriver driver) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String payApplicationFee(WebDriver driver,String paymentMethod) {
		SeleniumUtils.scrollToElement(driver,"xpath",Section50PageElementsBo.paymentLabel);
		SeleniumUtils.someDelay(3000);
		ele.getWebElement("XPATH",Section50PageElementsBo.paymentInFullToggleButton).click();
		ele.getWebElement("XPATH",Section50PageElementsBo.paymentMethodDropdown).click();
		ele.getWebElement("XPATH",Section50PageElementsBo.selectPaymentMethod(paymentMethod)).click();
		
		return null;
	}

}
