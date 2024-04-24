package qa.test;

import java.io.File;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import base.BaseTest;
import junit.framework.Assert;
import pageEvents.DashboardPageEvents;
import pageEvents.HighwaysPageEvents;
import pageEvents.LoginPageEvents;
import pageEvents.Section50PageEventsBo;
import pageEvents.ViewApplicationEvents;
import utils.Constants;

import static pageEvents.ViewApplicationEvents.ElementKey;

public class VerifySection50Application extends BaseTest {
	LoginPageEvents loginPg = new LoginPageEvents();
	DashboardPageEvents dashboardPg = new DashboardPageEvents();
	HighwaysPageEvents highwaysPg = new HighwaysPageEvents();
	Section50PageEventsBo sec50 = new Section50PageEventsBo();
	ViewApplicationEvents viewAppEvents = new ViewApplicationEvents();

	@Override
	@BeforeTest
	@Parameters("browser") // pass parameters from the testng.xml file which driver needs like
	public void beforeTestMethod(String browser) {
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + File.separator + "reports"
				+ File.separator + "verifySection50Application.html");
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		// Configure Extent Spark Reporter
		sparkReporter.config().setDocumentTitle("Westminster Backoffice");
		sparkReporter.config().setReportName("Verify section 50 report");
		sparkReporter.config().setTheme(Theme.STANDARD);
		sparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

		// Report Configuration
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Browser", browser);
		extent.setSystemInfo("OS", "Windows 10");
		extent.setSystemInfo("Java Version", System.getProperty("java.version"));

		setupDriver(browser, true);
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // 5 seconds
	}

	@Test(priority = '1', enabled = true)
	public void OpenWestminsterBoUrl(Method methodName) {
		logger = extent.createTest(methodName.getName());

		// Opening Westminster backoffice login page url
		driver.get(Constants.westminsterSfboLoginUrl);

		String loginMessage = loginPg.enterLoginCredentials(driver);
		// it checks login successful or not by comparing expected and actual
		// 'loginMessage'

		// Getting dashboard title after login success
		String dashboardPageMessage = dashboardPg.checkDashboardDisplaying();
		Assert.assertEquals("Street trading dashboard", dashboardPageMessage);
		logger.info(loginMessage);
		logger.info("Now user is on dashboard page ");
		logger.info(dashboardPageMessage);

	}

	@Test(priority = '2', enabled = true)
	public void performActionOnDashboard(Method methodName) {
		logger = extent.createTest(methodName.getName());
		String applicationLicenseId = "LICO49446";
		String dashboardMessage = dashboardPg.clickOnApplicationType(driver, applicationLicenseId);
		// get window handles of open windows
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> handles = new ArrayList<String>();
		handles.addAll(windowHandles);

		driver.close();
		driver.switchTo().window(handles.get(1));// switch to google.com
		Assert.assertEquals("Success: Section 50 application type clicked successfylly", dashboardMessage);
		logger.info(dashboardMessage);
		logger.info("Current url is :" + driver.getCurrentUrl());// fix it want second tab url
	}

	@Test(priority = '3')
	public void checkApplicationDetails(Method methodName) {
		logger = extent.createTest(methodName.getName());

		// Obtain application details
		Map<ElementKey, String> applicationDetails = viewAppEvents.verifyApplicationDetails(driver);

		// Check if there was an error
		if (!applicationDetails.containsKey(ElementKey.ERROR)) {
			Assert.assertEquals(applicationDetails.get(ElementKey.APPLICATION_NAME), "Section 50");
			logger.pass("Application name is: " + applicationDetails.get(ElementKey.APPLICATION_NAME));

			Assert.assertEquals(applicationDetails.get(ElementKey.APPLICATION_STATUS), "Validation required");
			logger.pass("Application status is: " + applicationDetails.get(ElementKey.APPLICATION_STATUS));

			Assert.assertEquals(applicationDetails.get(ElementKey.APPLICATION_DATE), "16/04/2024");
			logger.pass("Application date is: " + applicationDetails.get(ElementKey.APPLICATION_DATE));

			Assert.assertEquals(applicationDetails.get(ElementKey.APPLICATION_CREATED_BY), "gwise (Back Office)");
			logger.pass("Application created by: " + applicationDetails.get(ElementKey.APPLICATION_CREATED_BY));

			Assert.assertEquals(applicationDetails.get(ElementKey.APPLICATION_REQ_START_DATE), "30/04/2024");
			logger.pass("Application requested start date is: "
					+ applicationDetails.get(ElementKey.APPLICATION_REQ_START_DATE));

			Assert.assertEquals(applicationDetails.get(ElementKey.APPLICATION_REQ_END_DATE), "05/05/2024");
			logger.pass("Application requested end date is: "
					+ applicationDetails.get(ElementKey.APPLICATION_REQ_END_DATE));

			Assert.assertEquals(applicationDetails.get(ElementKey.APPLICATION_SITE_ADDRESS), "VICTORIA STREET");
			logger.pass("Application site address is: " + applicationDetails.get(ElementKey.APPLICATION_SITE_ADDRESS));

			Assert.assertEquals(applicationDetails.get(ElementKey.APPLICATION_LOCATION_DESCRIPTION), "test");
			logger.pass("Application location description is: "
					+ applicationDetails.get(ElementKey.APPLICATION_LOCATION_DESCRIPTION));

			Assert.assertEquals(applicationDetails.get(ElementKey.ABOUT_THE_WORK_DESCRIPTION), "Test work");
			logger.pass(
					"About the work description is: " + applicationDetails.get(ElementKey.ABOUT_THE_WORK_DESCRIPTION));

			Assert.assertEquals(applicationDetails.get(ElementKey.TYPE_OF_WORK), "footway");
			logger.pass("Type of work is: " + applicationDetails.get(ElementKey.TYPE_OF_WORK));

			Assert.assertEquals(applicationDetails.get(ElementKey.REQUIRED_ROAD_CLOSURE), "no");
			logger.pass("Required road closure is: " + applicationDetails.get(ElementKey.REQUIRED_ROAD_CLOSURE));

			Assert.assertEquals(applicationDetails.get(ElementKey.TRAFFIC_MANAGEMENT_DESCRIPTION), "test description");
			logger.pass("Traffic management description is: "
					+ applicationDetails.get(ElementKey.TRAFFIC_MANAGEMENT_DESCRIPTION));

			Assert.assertEquals(applicationDetails.get(ElementKey.SUPERVISOR_NAME), "test test");
			logger.pass("Supervisor name is: " + applicationDetails.get(ElementKey.SUPERVISOR_NAME));

			Assert.assertEquals(applicationDetails.get(ElementKey.SUPERVISOR_TELEPHONE), "test");
			logger.pass("Supervisor telephone is: " + applicationDetails.get(ElementKey.SUPERVISOR_TELEPHONE));

			Assert.assertEquals(applicationDetails.get(ElementKey.SUPERVISOR_NRWSA_NUMBER), "test");
			logger.pass("Supervisor NRWSA number is: " + applicationDetails.get(ElementKey.SUPERVISOR_NRWSA_NUMBER));

			Assert.assertEquals(applicationDetails.get(ElementKey.OPERATOR_NAME), "test test");
			logger.pass("Operator name is: " + applicationDetails.get(ElementKey.OPERATOR_NAME));

			Assert.assertEquals(applicationDetails.get(ElementKey.OPERATOR_TELEPHONE), "test");
			logger.pass("Operator telephone is: " + applicationDetails.get(ElementKey.OPERATOR_TELEPHONE));

			Assert.assertEquals(applicationDetails.get(ElementKey.OPERATOR_NRWSA_NUMBER), "test");
			logger.pass("Operator NRWSA number is: " + applicationDetails.get(ElementKey.OPERATOR_NRWSA_NUMBER));
		}
	}
}
