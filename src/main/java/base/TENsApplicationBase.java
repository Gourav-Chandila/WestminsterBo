package base;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageObjects.PremiseApplicationElements;
import pageObjects.TENsPageElements;
import utils.ElementFetch;
import utils.LicensingUtils;
import utils.SeleniumUtils;

public abstract class TENsApplicationBase {
	ElementFetch ele = new ElementFetch();
	LicensingUtils lic = new LicensingUtils();

	public abstract String fillBusinessDetails(String partyId, String businessEmail);
	
	public String confirmInfoIsTrue(WebDriver driver) {
		try {
			SeleniumUtils.scrollToElement(driver, "xpath", TENsPageElements.confirmInfoLabel);
			SeleniumUtils.someDelay(1000);
			WebElement ConfirmButton = ele.getWebElement("XPATH", TENsPageElements.noTogglebutton);
			WebElement clickableElement = SeleniumUtils.waitForElementToBeClickable(driver, ConfirmButton,
					Duration.ofSeconds(5));
			clickableElement.click();
			return "Please confirm the above is true : Clicked";
		} catch (Exception e) {
			return "Error : There are some problem" + e.getMessage();
		}
	}

	public String fillDatesWithTime(WebDriver driver, String startDate) {
		try {
			WebElement startDateEle = ele.getWebElement("ID", TENsPageElements.startDateInput);
			WebElement startDateElement = SeleniumUtils.waitForElementToBeDisplayed(driver, startDateEle,
					Duration.ofSeconds(5));
			startDateElement.sendKeys(startDate);

			WebElement endDateEle = ele.getWebElement("ID", TENsPageElements.endDateInput);
			WebElement endDateElement = SeleniumUtils.waitForElementToBeDisplayed(driver, endDateEle,
					Duration.ofSeconds(5));
			endDateElement.click();

			WebElement startTimeEle = ele.getWebElement("ID", TENsPageElements.startTimeInput);
			WebElement startTimeElement = SeleniumUtils.waitForElementToBeDisplayed(driver, startTimeEle,
					Duration.ofSeconds(5));
			startTimeElement.sendKeys("10:00");

			WebElement endTimeEle = ele.getWebElement("ID", TENsPageElements.endTimeInput);
			WebElement endTimeElement = SeleniumUtils.waitForElementToBeDisplayed(driver, endTimeEle,
					Duration.ofSeconds(5));
//			endTimeElement.click();
			endTimeElement.sendKeys("11:00");
			endTimeElement.clear();
			endTimeElement.sendKeys("1");

			return "Date and time filled successfully";
		} catch (Exception e) {
			return "Error : There are some problem" + e.getMessage();
		}
	}

	public String fillPersonalLicence(WebDriver driver, String otherRelevantDetails) {
		try {
			SeleniumUtils.scrollToElement(driver, "xpath", TENsPageElements.findLabel("Personal Licence"));
			SeleniumUtils.someDelay(1000);
			ele.getWebElement("ID", TENsPageElements.otherRevelantDetails).sendKeys(otherRelevantDetails);

			return "Personal license filled successfully";
		} catch (Exception e) {
			return "Error : There are some problem" + e.getMessage();
		}
	}

	public String fillLicenceActivities(WebDriver driver, String adultEntertainment, String activityText,
			String alcoholConsumption, String alcohollicensableLocation) {
		try {
			SeleniumUtils.scrollToElement(driver, "xpath", TENsPageElements.findLabel("Licence Activities"));
			SeleniumUtils.someDelay(1000);
			ele.getWebElement("ID", TENsPageElements.adultEntertainmentInput).sendKeys(adultEntertainment);
			ele.getWebElement("ID", TENsPageElements.addLicensableActivityButton).click();
			ele.getWebElement("XPATH", TENsPageElements.activityDropdownButton).click();
			ele.getWebElement("XPATH", TENsPageElements.chooseActivityOption(activityText)).click();
			// Dropdown button of Supply alcohol
			WebElement supplyAlcoholDropdownButton = ele.getWebElement("XPATH", TENsPageElements.supplyAlcoholDropdown);
			// Dropdown button of Licensable location
			WebElement licenceLocationDropdownButton = ele.getWebElement("XPATH",
					TENsPageElements.licenceLocationDropdown);
			// Logic for which dropdown is clicked and which opention was clicked
			if (supplyAlcoholDropdownButton.isDisplayed()) {
				supplyAlcoholDropdownButton.click();
				ele.getWebElement("XPATH", TENsPageElements.licenceActivitySecondDropdown(alcoholConsumption)).click();
			} else {
				licenceLocationDropdownButton.click();
				ele.getWebElement("XPATH", TENsPageElements.licenceActivitySecondDropdown(alcohollicensableLocation))
						.click();
			}
			// Location activity description
			ele.getWebElement("ID", TENsPageElements.locationActivityInput).sendKeys("test activity");
			// Save licensable details
			ele.getWebElement("ID", TENsPageElements.saveLicensableActivityButton).click();

			return "Licence activities filled successfully";
		} catch (Exception e) {
			return "Error : There are some problem" + e.getMessage();
		}
	}

	public String uploadApplicationEvidence(WebDriver driver) {
		try {
			SeleniumUtils.scrollToElement(driver, "xpath", TENsPageElements.findLabel("Application Evidence"));
			SeleniumUtils.someDelay(1000);
			lic.uploadDocument(TENsPageElements.applicationEvidenceChooseFileButton);
			ele.getWebElement("ID", TENsPageElements.applicationEvidenceFiledescInput).sendKeys("test");
			ele.getWebElement("XPATH", TENsPageElements.uploadEvidenceButton).click();
			return "Evidence successfully uploaded";
		} catch (Exception e) {
			return "Error : " + e.getMessage();
		}
	}

	public Map<String, String> fillPremiseEventDetails(WebDriver driver, String address,String licenceAndCertificateValue) {
	    Map<String, String> result = new HashMap<>();
	    try {
	        SeleniumUtils.scrollToElement(driver, "xpath", TENsPageElements.findLabel("Premise/Event Details"));
	        SeleniumUtils.someDelay(1000);
	        ele.getWebElement("XPATH", TENsPageElements.addressDropdown).click();
	        ele.getWebElement("XPATH", TENsPageElements.addressDropdownSelectOption(address)).click();
	        lic.enterAddressDetails(TENsPageElements.addressSearchButton);
	        WebElement searchInputEl = ele.getWebElement("ID", TENsPageElements.addressInput);
	        String inputValue = searchInputEl.getAttribute("value");
	        
	        SeleniumUtils.someDelay(1000);
	        if(licenceAndCertificateValue.equals("Premises") || licenceAndCertificateValue.equals("Club Premises")) {
	        	ele.getWebElement("XPATH",TENsPageElements.choosePremiseOrClubPremisesButton(licenceAndCertificateValue)).click();
	        	ele.getWebElement("ID",TENsPageElements.licenceNumberInput).sendKeys("LICOTESTID");
	        }else {
	        	ele.getWebElement("XPATH",TENsPageElements.choosePremiseOrClubPremisesButton(licenceAndCertificateValue)).click();
	        }
	        ele.getWebElement("ID",TENsPageElements.restrictedAreaInput).sendKeys("test");
	        ele.getWebElement("ID",TENsPageElements.naturePremisesInput).sendKeys("test");
	        ele.getWebElement("ID",TENsPageElements.natureOfEventInput).sendKeys("test");
	        ele.getWebElement("ID",TENsPageElements.maximumPeopleInput).sendKeys("300");
	        result.put("message", "Premise/Event Details filled successfully");
	        result.put("addressInputValue", inputValue);
	    } catch (Exception e) {
	        result.put("message", "Error : " + e.getMessage());
	    }
	    return result;
	}

	
	public Map<String, String> infoAboutProperty(WebDriver driver, String tenInSameYearValue, String issuer, String licenceNo, String startDate, String endDate) {
	    Map<String, String> result = new HashMap<>();
	    try {
	        SeleniumUtils.scrollToElement(driver, "xpath", TENsPageElements.findLabel("Information about the property"));
	        SeleniumUtils.someDelay(1000);
	        
	        // If Yes, fill a modal called Apply For Licence
	        if (tenInSameYearValue.equals("Yes")) {
	            ele.getWebElement("XPATH", TENsPageElements.hasAnyAssociateOption(tenInSameYearValue)).click();
	            ele.getWebElement("ID", TENsPageElements.issuerInput).sendKeys(issuer);
	            ele.getWebElement("ID", TENsPageElements.licenceNoInput).sendKeys(licenceNo);
	            WebElement licenceNameElement = ele.getWebElement("XPATH", TENsPageElements.licenceName);
	            String licenceName = licenceNameElement.getAttribute("value");
	            ele.getWebElement("ID", TENsPageElements.licenceHasStartDateCheckBox).click();
	            ele.getWebElement("ID", TENsPageElements.licenceHasEndDateCheckBox).click();
	            ele.getWebElement("ID", TENsPageElements.licenceStartDateInput).sendKeys(startDate);
	            ele.getWebElement("ID", TENsPageElements.licenceEndDateInput).sendKeys(endDate);
	            ele.getWebElement("XPATH", TENsPageElements.saveApplyForLicenceModal).click();
	            SeleniumUtils.someDelay(2000);
	            result.put("licenceName", licenceName);
	        } else {  
	        	//click on no check box
	            ele.getWebElement("XPATH", TENsPageElements.hasAnyAssociateOption(tenInSameYearValue)).click();
	        }
	        result.put("message", "Information about the property filled successfully");
	    } catch (Exception e) {
	        result.put("message", "Error: " + e.getMessage());
	    }
	    return result;
	}

	public String addDeclaration(WebDriver driver) {
		try {
	        SeleniumUtils.scrollToElement(driver, "xpath", TENsPageElements.findLabel("Declaration"));
			SeleniumUtils.someDelay(1000);
			ele.getWebElement("ID", TENsPageElements.addDeclarationButton).click();
			SeleniumUtils.someDelay(1000);
			lic.clickOnCheckBoxes("declaration_sole_applicant");
			SeleniumUtils.scrollToElement(driver, "id", TENsPageElements.declarationName);
			SeleniumUtils.someDelay(500);
			ele.getWebElement("ID", TENsPageElements.declarationName).sendKeys("test");
			lic.clickOnCheckBoxes("declaration_check_applicant");//Mcheckboxore 1.declaration_check_applicant 2.declaration_check_solicitor 3.declaration_check_agent
			ele.getWebElement("ID", TENsPageElements.saveDeclaration).click();
			SeleniumUtils.someDelay(1000);
			ele.getWebElement("XPATH", TENsPageElements.termsAndConditionsButton).click();
			return "Success : Declaration filled successfully";
		} catch (Exception e) {
			return "Error : There are some problem" + e.getMessage();
		}
	}
	
	public abstract String addPayment(WebDriver driver, String paymentMethod);
}
