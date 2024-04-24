package pageObjects;

public class DashboardPageElements {
	// Nav link
	public static String highwaysNavLink = "//a[@title='Highways']";
	public static String streetTradingDashboard = "//h2[text()='Street trading dashboard']";

	// Licenses
	public static String licencesSection = "//div[@class='panel-heading' and text()='Licences']";

	public static String viewApplicationButton(String licenseId) {
	    return "//a[@application_id='" + licenseId + "']";
	}


	// Application type
	public static String section50ApplicationType = "//td[@class='sorting_1' and text()='Section 50']";
}
