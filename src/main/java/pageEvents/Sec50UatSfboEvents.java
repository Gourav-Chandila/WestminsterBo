//Child1.java
package pageEvents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

	//function for fetch application price
	@Override
		public String fetchPrice(WebDriver driver) {
			SeleniumUtils.scrollToElement(driver, "xpath", Section50PageElementsBo.orderSummaryLabel);
			SeleniumUtils.someDelay(2000);
			WebElement element = driver.findElement(By.xpath(Section50PageElementsBo.orderSummaryPriceSfbo));
			String Actualprice = element.getText();
			System.out.println("Actualprice :" + Actualprice);
			return Actualprice;
		}

}
