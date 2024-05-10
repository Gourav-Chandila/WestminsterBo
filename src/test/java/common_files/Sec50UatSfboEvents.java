//Child1.java
package common_files;

import org.openqa.selenium.WebDriver;

import pageObjects.Section50PageElementsBo;
import utils.SeleniumUtils;

public class Sec50UatSfboEvents extends Section50Base {

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
