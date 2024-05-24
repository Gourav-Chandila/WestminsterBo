package pageEvents;

import org.openqa.selenium.WebDriver;

import base.TENsApplicationBase;
import pageObjects.PremiseApplicationElements;
import utils.ElementFetch;
import utils.LicensingUtils;
import utils.SeleniumUtils;

public class TENSPageSfboEvents extends TENsApplicationBase{
	LicensingUtils lic = new LicensingUtils();
	ElementFetch ele = new ElementFetch();
	@Override
	public String addPayment(WebDriver driver, String paymentMethod) {
		lic.addPayment(driver, paymentMethod);
		return "Payment successfull";
	}
	
	@Override
	public String fillBusinessDetails(String partyId, String businessEmail) {
		try {
			lic.fillBusinessDetails(partyId, businessEmail);
			return "Success: Customer search successfully";
		} catch (Exception e) {
			return "Error: Some error occured " + e.getMessage();
		}
	}

}
