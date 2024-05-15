package pageObjects;

public class PremiseApplicationElements {

	// Business details
	public static String businessSearchInputField = "business_search";
	public static String businessDetailsSearchButton = "//div[@id='business_search_button']";
	public static String businessModalSearchButton = "modal_business_search_button";

	public static String businessModalSelectButton2(String partyId, String email) {
		// Base XPath with placeholders and this function generates xpath for business
		// address select button accepts t
		String baseXPath = "//button[@class='btn btn-link business_search_select' and contains(@partyid, '%s') and contains(@partyid, '%s')]";

		// Format the XPath with the given partyId and email
		String xpath = String.format(baseXPath, String.format("\"partyId\":\"%s\"", partyId),
				String.format("\"email\":\"%s\"", email));
		return xpath;
	}

	// Please confirm the above is true: in front office
	public static String confirmInfoLabel = "//label[@id='detailscorrectanchor']";
	public static String noTogglebutton = "(//label[@class='btn btn-danger active toggle-off'])[1]";

	// Licence Duration
	public static String licenceSectionLabel = "//div[@class='panel-heading' and text()='Licence Duration']";
	public static String licenceStartDate = "//input[@id='startdate']";
	public static String licenceEndDate = "//input[@id='enddate']";

	// Applicant Details
	public static String applicantDetailsSection = "//div[@class='panel-heading' and text()='Applicant Details']";
	public static String iAmApplyingForTheLicenceAsDropdown = "//button[@class=\"btn dropdown-toggle bs-placeholder btn-default\" and @data-id=\"applicant_activities_list\"]";

	// Accepts business name and Other
	public static String iAmApplyingForTheLicenceAsDropdownOption(String licenceAsValue) {
		return "//span[text()='" + licenceAsValue + "']";
	}

	public static String addApplicantDetailsButton = "//button[@id='applicant_add']";

	public static String applicantRadioButton(String applicantCheckBoxId) {
		return applicantCheckBoxId;
	}

	public static String otherApplicantNameInput = "applicant_name";

	public static String otherApplicantAddressSearchButton = "change_address";
	public static String otherApplicantPostcode = "postcode";
	public static String otherApplicantPostcodeSearchButton = "postcode_search";
	public static String otherApplicantSelectAddress = "//button[text()='Select address']";

	public static String otherApplicantRegisteredNumberInput = "applicant_registered_number";
	public static String otherApplicantDescriptionInput = "applicant_description";
	public static String otherApplicantTelephoneInput = "applicant_telephone";
	public static String otherApplicantEmailInput = "applicant_email_address";
	public static String addOtherApplicantButton = "add_applicant";

	public static String ApplicantDetailsRadioButton(String applicantCheckBox) {
		return applicantCheckBox;
	}

	public static String allApplicantsOver18YearsOfAge = "(//label[@class='btn btn-danger active toggle-off'])[2]";

	public static String applicationShadowLicenceOrProvisionalStatement(String shadowCheckBox) {
		return shadowCheckBox;
	}

	// Designated Premises Supervisor
	public static String designatedPremisesSupervisorLabel = "//div[@class='panel-heading' and text()='Designated Premises Supervisor']";
	public static String addDesignatedPremisesSupervisorButton = "//button[text()='Add Designated Premises Supervisor']";
	public static String designatedPremisesSupervisorAddressSearchButton = "supervisor_address";
	public static String designatedPremisesSupervisorName = "designated_supervisor_name";
	public static String designatedPremisesSupervisorDob = "designated_dob";
	public static String designatedPremisesSupervisorTelephone = "designated_supervisor_telephone";
	public static String designatedPremisesSupervisorEmail = "designated_supervisor_email";
	public static String designatedPremisesSupervisorPersonalLicNo = "designated_personal_license";
	public static String designatedPremisesSupervisorPersonalIssuingAuthority = "designated_issuing_authority";
	public static String saveDesignatedPremisesSupervisorDetails = "add_designated";

	// Application Evidence
	public static String applicationEvidenceLabel = "//div[@class='panel-heading' and text()='Application Evidence']";
	public static String applicationEvidenceBrowseFile = "//input[@id='files']";
	public static String applicationEvidenceDescriptionInput = "file_desc";
	public static String applicationEvidenceUploadButton = "//button[text()='Upload']";
	
	//PremisesDetails
	public static String premiseDetailsSection="//div[@class='panel-heading' and text()='Premises Details']";
	public static String premiseDetailsAddressDropdown="//button[@data-id='address_activities_list']";
	public static String premiseDetailsAddressSelect(String selectedAddressValue) {
	    return "//span[text()='" + selectedAddressValue + "']";
	}
	public static String premiseAddressSearchButton="premise_address_btn";
	public static String premiseAddressIsUnderConstructionOption="premise_address_btn";
	public static String premiseDetailsUnderConstructionOption(String underConstructionOption) {
	    return underConstructionOption;
	}
	public static String premiseAddressReteableValueInput="//input[@id='rateableValue']";
	public static String premiseTradingName="premise_trading_name";
	public static String premisesGeneralDesctiption="description_premise";
	public static String if5000OrMorePeople="peopleAttend";
	public static String PremisesAlcoholSection="//label[@for='serve_alcohol_flag']";
	public static String premisesServeAlcohol(String Option) {
	    return Option;
	}
	public static String accessForChildrenRestrictedOrProhibited(String Option) {
		return Option;
	}
}
