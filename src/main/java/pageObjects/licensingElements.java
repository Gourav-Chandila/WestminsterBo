package pageObjects;

public class licensingElements {
	// Business details
	public static String businessSearchInputField = "business_search";
	public static String businessDetailsSearchButton = "//div[@id='business_search_button']";
	public static String businessModalSearchButton = "modal_business_search_button";

	public static String businessModalSelectButton2(String partyId, String email) {
		// Base XPath with placeholders and this function generates xpath for business
		String baseXPath = "//button[@class='btn btn-link business_search_select' and contains(@partyid, '%s') and contains(@partyid, '%s')]";
		// Format the XPath with the given partyId and email
		String xpath = String.format(baseXPath, String.format("\"partyId\":\"%s\"", partyId),
				String.format("\"email\":\"%s\"", email));
		return xpath;
	}
	
	
	//Enter specific address elements 
	public static String otherApplicantAddressSearchButton = "change_address";
	public static String otherApplicantPostcode = "postcode";
	public static String otherApplicantPostcodeSearchButton = "postcode_search";
	public static String otherApplicantSelectAddress = "//button[text()='Select address']";

	
	//function for checkbox
	public static String selectDeclarationCheckBox(String checkBoxButtonId) {
		return checkBoxButtonId;
	}
	
//	payment sfbo
	public static String paymentLabel = "//div[@class='panel-heading' and text()='Payment']";
	public static String paymentInFullToggleButton = "//div[@class='toggle btn btn-danger off'][input[@id='payment_confirm']]";
	public static String paymentMethodDropdown = "//span[@class='filter-option pull-left' and text()='Payment Method']";
	// Generic method of payment method option
	public static String selectPaymentMethod(String paymentMethodName) {
			String paymentMethod = "//span[@class='text' and text()='" + paymentMethodName + "']";
			return paymentMethod;
		}
	public static String payAndSubmitButton="btnSubmit";
	public static String paymentOKButton="//button[text()='OK']";
	public static String cardPaySummaryButton="//span[@class='MuiButton-label']";
	
	
}
