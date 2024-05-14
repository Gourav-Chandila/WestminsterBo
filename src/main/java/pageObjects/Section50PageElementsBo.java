package pageObjects;

public class Section50PageElementsBo {
	// Business details
	public static String businessSearchInputField = "business_search";
	public static String businessDetailsSearchButton = "//button[@id='business_search_button']";
	public static String businessModalSearchButton = "modal_business_search_button";
	// not use this link for select below a genric function for this
	public static String businessModalSelectButton = "//button[contains(@class, \"business_search_select\") and contains(@partyid, '{\"business_name\":null,\"main_business_party_id\":\"30839\",\"address\":null,\"business_address\":null,\"orderId\":null,\"name\":null,\"telephone\":null,\"partyId\":\"30838\",\"businessPartyId\":\"30839\",\"email\":\"test@fgl.com\"}')]";

	public static String businessModalSelectButton2(String partyId, String email) {
		// Base XPath with placeholders and this function generates xpath for business
		// address select button accepts t
		String baseXPath = "//button[@class='btn btn-link business_search_select' and contains(@partyid, '%s') and contains(@partyid, '%s')]";

		// Format the XPath with the given partyId and email
		String xpath = String.format(baseXPath, String.format("\"partyId\":\"%s\"", partyId),
				String.format("\"email\":\"%s\"", email));
		return xpath;
	}

	// Application
	public static String applicationSectionLabel = "//h2[text()='Application']";
	public static String applicationStartDate = "//input[@id='startDate']";
	public static String applicationEndDate = "//input[@id='endDate']";

	// Site details section on Section 50 page used for scrolling
	public static String siteDetailsSection = "//div[@class='panel-heading']/h2[text()='Site details']";
	public static String streetNamePoostcodeInput = "//input[@id='addressDetails']";

	// for searched street or post code there are many options for same street
	public static String streetNamePostCodeOption(String streetNamePostcode) {
		String streetNamePoostcodeOption = "//ul/li[text()='" + streetNamePostcode + "']";
		return streetNamePoostcodeOption;
	}

	// Location (outside, near house number, lamp column number) section
	public static String locationLabelSection = "//label[text()='Location (outside, near house number, lamp column number)']";
	// Location input field
	public static String locationInputField = "s50_location";

	// label Please upload a traffic management plan, if you would like to add any
	// optional support documents please upload them here Supervisor and Operator
	// details are loaded in different sections- (maximum file size is 10MB,
	// supported documents are pdf, jpg and png)
	public static String trafficManagementPlanSection = "//label[text()='Please upload a traffic management plan, if you would like to add any optional support documents please upload them here Supervisor and Operator details are loaded in different sections- (maximum file size is 10MB, supported documents are pdf, jpg and png)']";

	// Generic method of upload file
	public static String uploadFile(String fileSelector) {
		String fileWhichToBeUploaded = fileSelector;
		return fileWhichToBeUploaded;
	}

	// Traffic management description input field and upload button
	public static String trafficPlanBrowseFile = "traffic_plan_input";
	public static String trafficPlanDescriptionInputField = "traffic_plan_desc";
	public static String trafficPlanUploadButton = "traffic_plan";

	
	// About the work
	public static String aboutTheWorkLabel = "//div[@class='panel-heading']/h2[text()='About the works']";
	public static String aboutTheWorkDescription = "s50_work_description";
	public static String aboutTheWorkFootwayOption = "s50_footway_carriageway_footway";
//	public static String aboutTheWorkRoadClosureNoOption = "s50_road_closure_no";
	public static String aboutTheWorkRoadClosureNoOption = "//input[@id='s50_road_closure_no']";
	public static String aboutTheWorkTrafficDescription = "s50_traffic_description";

	// Supervisor details
	public static String supervisorDetailsLabel = "//div[@class='panel-heading']/h2[text()='Supervisor details']";
	public static String addSupervisorDetailsButton = "add_supervisor";
	public static String checkModal = "add_supervisor";
	public static String supervisorFirstNameInput = "supervisor_firstName";
	public static String supervisorSurnameInput = "supervisor_surname";
	public static String supervisorTelephoneInput = "supervisor_telephone";
	public static String supervisorNrwsaCardInput = "supervisor_nrwsa";
	public static String supervisorChooseFile = "supervisor_card_input";
	public static String supervisorCardSide = "supervisor_card_desc";
	public static String supervisorCardSideOption = "//select[@id='supervisor_card_desc']/option[text()='Supervisor front card']";
	public static String supervisorBackCardSideOption = "//select[@id='supervisor_card_desc']/option[text()='Supervisor back card']";
	public static String supervisorUploadButton = "supervisor_card";
	public static String supervisorSaveDetailsButton = "add_supervisor_button";

	// Operator details
	public static String operatorDetailsLabel = "//div[@class='panel-heading']/h2[text()='Operator details']";
	public static String addoperatorDetailsButton = "add_operator";
	public static String operatorFirstNameInput = "operator_firstName";
	public static String operatorSurnameInput = "operator_surname";
	public static String operatorTelephoneInput = "operator_telephone";
	public static String operatorNrwsaCardInput = "operator_nrwsa";
	public static String operatorChooseFile = "operator_card_input";
	public static String operatorCardSide = "operator_card_desc";
	public static String operatorCardSideOption = "//select[@id='operator_card_desc']/option[text()='Operator front card']";
	public static String operatorBackCardSideOption = "//select[@id='operator_card_desc']/option[text()='Operator back card']";
	public static String operatorUploadButton = "operator_card";
	public static String operatororSaveDetailsButton = "add_operator_button";

	// Declaration
	public static String declarationHeading = "//div[@class='panel-heading']/h2[text()='Declarations']";
	public static String addDeclarationButton = "//button[text()='Add declaration']";
	public static String addDeclarationModalTermsAndConditionCheckBox = "//input[@id='declaration_tc_confirm2']";
	public static String addDeclarationModalConfirmationCheckBox = "//input[@id='declaration_permission_confirm2']";
	public static String addDeclarationModalFullName = "(//input[@id='declaration_company_name2'])[1]";
	public static String addDeclarationModalCompanyName = "//input[@id='temp_declaration_company_name']";
	public static String addDeclarationModalPosition = "//input[@id='temp_declaration_position']";
	public static String saveDeclarationButton = "//button[@id='add_declaration']";
	public static String declarationDataProtectionToggleButton = "//div[@class='row']//div[@class='col-xs-4']//div[contains(@class, 'toggle-group')]//label[contains(@class, 'toggle-off') and contains(text(), 'No')]";

	// Order Summary
	public static String orderSummaryLabel = "//div[@class='panel-heading']/h2[text()='Order summary']";
	public static String orderSummaryPrice = "(//span[@class='price_display'])[2]";



	// Please confirm the above is true: in front office
	public static String confirmInfoLabel = "//label[@id='detailscorrectanchor']";
	public static String noTogglebutton = "(//label[@class='btn btn-danger active toggle-off'])[1]";
	
	//Payment sf
	public static String PayAndSubmitButton="//button[@id='section50_application_submit']";
	
	//Payment bo	
	public static String paymentLabel = "//div[@class='panel-heading' and text()='Payment']";
	public static String paymentInFullToggleButton = "(//label[@class='btn btn-danger active toggle-off'])[2]";
	public static String paymentMethodDropdown = "//span[@class='filter-option pull-left' and text()='Payment Method']";

	// Generic method of payment method option
	public static String selectPaymentMethod(String paymentMethodName) {
		String paymentMethod = "//span[@class='text' and text()='" + paymentMethodName + "']";
		return paymentMethod;
	}
	//City pay sf
	public static String selectPaymentCardDropDown="//div[@id='testmode-buttons']";
	public static String masterCreditCard="//b[text()='MasterCard Credit']";
	public static String payWithCityPayButton="//button[@id='process']";
	
}
