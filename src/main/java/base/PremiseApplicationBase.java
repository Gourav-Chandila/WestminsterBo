package base;

import org.openqa.selenium.WebDriver;

import pageObjects.PremiseApplicationElements;
import pageObjects.Section50PageElementsBo;
import utils.ElementFetch;
import utils.SeleniumUtils;

public abstract class PremiseApplicationBase {
	ElementFetch ele = new ElementFetch();

	public abstract String fillBusinessDetails(String partyId, String businessEmail);

	public String confirmInfoIsTrue(WebDriver driver) {
		try {
			SeleniumUtils.scrollToElement(driver, "xpath", PremiseApplicationElements.confirmInfoLabel);
			SeleniumUtils.someDelay(1000);
			ele.getWebElement("xpath", PremiseApplicationElements.noTogglebutton).click();

			return "Please confirm the above is true : Clicked";
		} catch (Exception e) {
			return "Error : There are some problem" + e.getMessage();
		}

	}

	public String fillLicenceDuration(WebDriver driver, String startDate, String endDate) {
		try {
			SeleniumUtils.someDelay(2000);
			// Scroll to the licence section for better visibility
			SeleniumUtils.scrollToElement(driver, "xpath", PremiseApplicationElements.licenceSectionLabel);
			// Wait for a short period to ensure page stability
			Thread.sleep(3000);
			// Fill in the application start date
			ele.getWebElement("XPATH", PremiseApplicationElements.licenceStartDate).sendKeys(startDate);
			// Fill in the application end date
			ele.getWebElement("XPATH", PremiseApplicationElements.licenceEndDate).sendKeys(endDate);
			// Return success message
			return String.format("Success: Licence duration dates filled successfully. Start date: %s End date: %s",
					startDate, endDate);
		} catch (Exception e) {
			// Handle thread interruption gracefully
			Thread.currentThread().interrupt();
			return "Error: Some error occured " + e.getMessage();

		}
	}

	public String fillApplicantDetails(WebDriver driver, String licenceAs, String otherAppplicant,
			String ApplicantCheckbox, String shadowCheckBox) {
		try {
			SeleniumUtils.scrollToElement(driver, "xpath", PremiseApplicationElements.applicantDetailsSection);
			Thread.sleep(2000);
			ele.getWebElement("XPATH", PremiseApplicationElements.iAmApplyingForTheLicenceAsDropdown).click();
			Thread.sleep(1000);
			ele.getWebElement("XPATH", PremiseApplicationElements.iAmApplyingForTheLicenceAsDropdownOption(licenceAs))
					.click();
			ele.getWebElement("XPATH", PremiseApplicationElements.addApplicantDetailsButton).click();
			Thread.sleep(1000);
//			 Accepts individual_applicant,limited_company_applicant,partnership_applicant,unincoporated_applicant,other_applicant,recognised_club_applicant,charity_applicant,educational_applicant,health_service_applicant,registered_individual_wales_applicant,registered_individual_wales_applicant,registered_individual_england_applicant,chief_officer_applicant
			ele.getWebElement("ID", PremiseApplicationElements.applicantRadioButton(otherAppplicant)).click();
			ele.getWebElement("ID", PremiseApplicationElements.otherApplicantNameInput)
					.sendKeys("Test other applicant name");
			SeleniumUtils.someDelay(1000);
			enterAddressDetails(PremiseApplicationElements.otherApplicantAddressSearchButton);
			ele.getWebElement("ID", PremiseApplicationElements.otherApplicantRegisteredNumberInput)
					.sendKeys("+44567897689");
			ele.getWebElement("ID", PremiseApplicationElements.otherApplicantDescriptionInput)
					.sendKeys("Test other applicant description");
			ele.getWebElement("ID", PremiseApplicationElements.otherApplicantTelephoneInput).sendKeys("+445623986756");
			ele.getWebElement("ID", PremiseApplicationElements.otherApplicantEmailInput)
					.sendKeys("testotherapplicant@fgl.com");
			ele.getWebElement("ID", PremiseApplicationElements.addOtherApplicantButton).click();

			ele.getWebElement("ID", PremiseApplicationElements.ApplicantDetailsRadioButton(ApplicantCheckbox)).click();
			SeleniumUtils.scrollToElement(driver, "xpath", PremiseApplicationElements.allApplicantsOver18YearsOfAge);
			Thread.sleep(2000);
			ele.getWebElement("XPATH", PremiseApplicationElements.allApplicantsOver18YearsOfAge).click();
			ele.getWebElement("ID",
					PremiseApplicationElements.applicationShadowLicenceOrProvisionalStatement(shadowCheckBox)).click();
			return "Applicant details filled successfully";
		} catch (Exception e) {
			return "Error : There are some problem" + e.getMessage();
		}

	}

	public String designatedPremisesSupervisor(WebDriver driver) {
		try {
			SeleniumUtils.scrollToElement(driver, "xpath",
					PremiseApplicationElements.designatedPremisesSupervisorLabel);
			SeleniumUtils.someDelay(2500);
			ele.getWebElement("XPATH", PremiseApplicationElements.addDesignatedPremisesSupervisorButton).click();
			SeleniumUtils.someDelay(1000);
			ele.getWebElement("ID", PremiseApplicationElements.designatedPremisesSupervisorName)
					.sendKeys("Test supervisor name");
			ele.getWebElement("ID", PremiseApplicationElements.designatedPremisesSupervisorDob).sendKeys("18/09/2000");
			enterAddressDetails(PremiseApplicationElements.designatedPremisesSupervisorAddressSearchButton);
			SeleniumUtils.someDelay(1000);
			ele.getWebElement("ID", PremiseApplicationElements.designatedPremisesSupervisorTelephone)
					.sendKeys("+445656565645");
			ele.getWebElement("ID", PremiseApplicationElements.designatedPremisesSupervisorEmail)
					.sendKeys("supervisor@fgl.com");
			ele.getWebElement("ID", PremiseApplicationElements.designatedPremisesSupervisorPersonalLicNo)
					.sendKeys("LICO0000");
			ele.getWebElement("ID", PremiseApplicationElements.designatedPremisesSupervisorPersonalIssuingAuthority)
					.sendKeys("Test authority");
			ele.getWebElement("ID", PremiseApplicationElements.saveDesignatedPremisesSupervisorDetails).click();

			return "Success: Designated Premises Supervisor filled successfully";
		} catch (Exception e) {
			// Handle thread interruption gracefully
			Thread.currentThread().interrupt();
			return "Error: Some error occured " + e.getMessage();

		}
	}

	public String uploadApplicationEvidence(WebDriver driver) {
		try {
			SeleniumUtils.scrollToElement(driver, "xpath", PremiseApplicationElements.applicantDetailsSection);
			SeleniumUtils.someDelay(2000);
			uploadDocument(PremiseApplicationElements.applicationEvidenceBrowseFile);
			ele.getWebElement("ID", PremiseApplicationElements.applicationEvidenceDescriptionInput)
					.sendKeys("test description");
			SeleniumUtils.someDelay(1000);
			ele.getWebElement("XPATH", PremiseApplicationElements.applicationEvidenceUploadButton).click();
			return "Success : Application Evidence uploaded successfully";
		} catch (Exception e) {
			return "Error : There are some problem" + e.getMessage();
		}
	}

	public String fillPremisesDetails(WebDriver driver, String underConstructionId,String alcoholOption,String accessOption) {
		try {
			SeleniumUtils.scrollToElement(driver, "xpath", PremiseApplicationElements.premiseDetailsSection);
			SeleniumUtils.someDelay(2000);
			ele.getWebElement("XPATH", PremiseApplicationElements.premiseDetailsAddressDropdown).click();
			// Accepts null,Other Address ,and your address
			ele.getWebElement("XPATH", PremiseApplicationElements.premiseDetailsAddressSelect("Other Address")).click();
			enterAddressDetails(PremiseApplicationElements.premiseAddressSearchButton);
			SeleniumUtils.someDelay(1000);
			if (underConstructionId.equals("is_under_construction_yes")) {
				ele.getWebElement("ID",
						PremiseApplicationElements.premiseDetailsUnderConstructionOption(underConstructionId)).click();
			} else {
				ele.getWebElement("ID",
						PremiseApplicationElements.premiseDetailsUnderConstructionOption(underConstructionId)).click();
				SeleniumUtils.someDelay(1000);
				ele.getWebElement("XPATH", PremiseApplicationElements.premiseAddressReteableValueInput).clear();
				ele.getWebElement("XPATH", PremiseApplicationElements.premiseAddressReteableValueInput).sendKeys("23");
			}
			ele.getWebElement("ID", PremiseApplicationElements.premiseTradingName).clear();
			ele.getWebElement("ID", PremiseApplicationElements.premiseTradingName).sendKeys("test premise trading name");
			ele.getWebElement("ID", PremiseApplicationElements.premisesGeneralDesctiption).sendKeys("test general description");
			ele.getWebElement("ID", PremiseApplicationElements.if5000OrMorePeople).sendKeys("5000");
			SeleniumUtils.scrollToElement(driver, "id", PremiseApplicationElements.if5000OrMorePeople);
			SeleniumUtils.someDelay(2000);	
			ele.getWebElement("ID", PremiseApplicationElements.premisesServeAlcohol(alcoholOption)).click();
			ele.getWebElement("ID", PremiseApplicationElements.accessForChildrenRestrictedOrProhibited(accessOption)).click();
			
			

			return "Success : Premises details filled successfully";
		} catch (Exception e) {
			return "Error : There are some problem" + e.getMessage();
		}
	}

	public void uploadDocument(String filePath) {
		ele.getWebElement("XPATH", filePath).sendKeys("C:\\Users\\Gaurav\\Desktop\\test_img.png");
	}

	// Function for entering address details
	public void enterAddressDetails(String addressSearchButton) {
		ele.getWebElement("ID", addressSearchButton).click();
		SeleniumUtils.someDelay(1000);
		ele.getWebElement("ID", PremiseApplicationElements.otherApplicantPostcode).clear();
		ele.getWebElement("ID", PremiseApplicationElements.otherApplicantPostcode).sendKeys("SW1A2DG");
		ele.getWebElement("ID", PremiseApplicationElements.otherApplicantPostcodeSearchButton).click();
		SeleniumUtils.someDelay(2000);
		ele.getWebElement("XPATH", PremiseApplicationElements.otherApplicantSelectAddress).click();
	}

}
