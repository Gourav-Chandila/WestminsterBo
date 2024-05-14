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
	public static String otherApplicantNameInput="applicant_name";
	
	public static String otherApplicantAddressSearchButton="change_address";
	public static String otherApplicantPostcode="postcode";
	public static String otherApplicantPostcodeSearchButton="postcode_search";
	public static String otherApplicantSelectAddress="//button[text()='Select address']";
	
	
	public static String otherApplicantRegisteredNumberInput="applicant_registered_number";
	public static String otherApplicantDescriptionInput="applicant_description";
	public static String otherApplicantTelephoneInput="applicant_telephone";
	public static String otherApplicantEmailInput="applicant_email_address";
	public static String addOtherApplicantButton="add_applicant";
	public static String ApplicantDetailsRadioButton(String applicantCheckBox) {
		return applicantCheckBox;
	}
	public static String allApplicantsOver18YearsOfAge = "(//label[@class='btn btn-danger active toggle-off'])[2]";
	public static String applicationShadowLicenceOrProvisionalStatement(String shadowCheckBox) {
		return shadowCheckBox;
	}

	//Designated Premises Supervisor
	public static String designatedPremisesSupervisorLabel="//div[@class='panel-heading' and text()='Designated Premises Supervisor']";
	public static String addDesignatedPremisesSupervisorButton="//button[text()='Add Designated Premises Supervisor']";
	public static String designatedPremisesSupervisorAddressSearchButton="supervisor_address";
}
