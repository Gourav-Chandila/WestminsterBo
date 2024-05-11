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

}
