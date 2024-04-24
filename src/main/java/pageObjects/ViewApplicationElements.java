package pageObjects;

public class ViewApplicationElements {
	//Application section
public static String applicationSection="//div[@class='panel-heading' and text()='Application details']";
	public static String applicationName = "//span[@class='application_modal_product']";
	public static String applicationStatus = "//span[@class='application_modal_status']";
	public static String applicationDate = "//span[@class='application_modal_application_date']";
	public static String applicationCreatedBy = "//span[@class='application_modal_created_by']";
	public static String applicationReqStartDate = "//span[@class='application_modal_start_date']";
	public static String applicationReqEndDate = "//span[@class='application_modal_end_date']";
	public static String applicationSiteAddress = "//span[@class='application_modal_site_address']";
	public static String applicationLocationDescription = "//span[@class='s50_location']";

	public static String applicationAboutTheWorkDescription = "//span[@class='s50_work_description']";
	public static String applicationTypeOfWork = "//span[@class='s50_footway_carriageway']";
	public static String applicationRequiredRoadClosure = "//span[@class='s50_road_closure']";
	public static String applicationDescriptionTrafficMgmnt = "//span[@class='s50_traffic_description']";

	// Application section 'Supervisor details'
	public static String applicationSupervisorName = "(//div[contains(@class, 'application_modal_supervisor')]//div[@class='col-xs-7 col-sm-8'])[1]";
	public static String applicationSupervisorTelephone = "(//div[contains(@class, 'application_modal_supervisor')]//div[@class='col-xs-7 col-sm-8'])[2]";
	public static String applicationSupervisorNRWSANumber = "(//div[contains(@class, 'application_modal_supervisor')]//div[@class='col-xs-7 col-sm-8'])[3]";

	// Application section 'Operator details'
	public static String applicationOperatorName = "(//div[contains(@class, 'application_modal_operator')]//div[@class='col-xs-7 col-sm-8'])[1]";
	public static String applicationOperatorTelephone = "(//div[contains(@class, 'application_modal_operator')]//div[@class='col-xs-7 col-sm-8'])[2]";
	public static String applicationOperatorNRWSANumber = "(//div[contains(@class, 'application_modal_operator')]//div[@class='col-xs-7 col-sm-8'])[3]";

}
