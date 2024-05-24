package pageObjects;

public class TENsPageElements {
	// Please confirm the above is true: in front office
	public static String confirmInfoLabel = "//label[@id='detailscorrectanchor']";
	public static String noTogglebutton = "(//label[@class='btn btn-danger active toggle-off'])[1]";

	// Function for labels
	public static String findLabel(String labelName) {
		return "//div[@class='panel-heading' and text()='" + labelName + "']";
	}

	// Date time
	public static String startDateInput = "startdate";
	public static String endDateInput = "enddate";
	public static String startTimeInput = "starttime";
	public static String endTimeInput = "endtime";
	public static String endTimeclockIcon = "//div[@id='applicationendtime']//span[@class='glyphicon glyphicon-time']";

	// Personal Licence
	public static String otherRevelantDetails = "personal_licence_details";

	// Licence Activities
	public static String adultEntertainmentInput = "adult_services";
	public static String addLicensableActivityButton = "license_activity_add";
	public static String activityDropdownButton = "//span[text()='Select an activity']";

	public static String chooseActivityOption(String activityText) {
		return "//span[@class='text' and text()='" + activityText + "']";
	}

	public static String supplyAlcoholDropdown = "//button[@data-id='supply_alcohol']";
	public static String licenceLocationDropdown = "//button[@data-id='location']";

	public static String licenceActivitySecondDropdown(String OptionValue) {
		return "//span[@class='text' and text()='" + OptionValue + "']";
	}

	public static String locationActivityInput = "activity_location_details";
	public static String saveLicensableActivityButton = "licensableButton";

	// Application evidence
	public static String applicationEvidenceChooseFileButton = "//input[@id='files']";
	public static String applicationEvidenceFiledescInput = "file_desc";
	public static String uploadEvidenceButton = "//button[@class='btn btn-primary application_upload_document']";

	// Premise Event Details
	public static String addressDropdown = "//button[@data-id='address_activities_list']";

	public static String addressDropdownSelectOption(String optionValue) {
		return "//span[@class='text' and text()='" + optionValue + "']";
	}

	public static String addressSearchButton = "premise_address_btn";
	public static String addressInput = "premise_address";
	
	public static String choosePremiseOrClubPremisesButton(String premiseValue) {
	return "//input[@value='"+premiseValue+"']";
	}
	public static String licenceNumberInput="certificate_id";
	public static String restrictedAreaInput="restrict_area_text";
	public static String naturePremisesInput="nature_premise";
	public static String natureOfEventInput="nature_event";
	public static String maximumPeopleInput="maximum_people";
	
	//Information about the property
	public static String hasAnyAssociateOption(String tenValue) {
		return "//input[@class='form-check-input tenInSameYear' and @value='"+tenValue+"']";
	}
	public static String issuerInput="issuer";
	public static String licenceNoInput="licence_no";
	public static String licenceName="//input[@id='licence_name']";
	public static String licenceHasStartDateCheckBox="licence_start_na";
	public static String licenceHasEndDateCheckBox="licence_end_na";
	public static String licenceStartDateInput="licencestartdate";
	public static String licenceEndDateInput="licenceenddate";
	public static String saveApplyForLicenceModal="//button[text()='Submit']";

	//Declaration
	// Declarations
	public static String addDeclarationSection = "//div[text()='Declarations']";
	public static String addDeclarationButton = "declaration_add";
	public static String selectDeclarationCheckBox(String checkBoxButtonId) {
		return checkBoxButtonId;
	}
	public static String declarationName = "declaration_name";
	public static String saveDeclaration = "aad_declaration";
	public static String termsAndConditionsButton = "//i[@data-bv-icon-for='detailscorrect1']/following-sibling::div[@class='toggle-group']/label[@class='btn btn-danger active toggle-off']";

	//payment sf
	public static String payAndSubmitButton="btnSubmit";
	public static String cardPaySummaryButton="//span[@class='MuiButton-label']";

		
}
