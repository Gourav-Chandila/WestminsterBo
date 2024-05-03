package qa.test;

import java.lang.reflect.Method;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
import base.BaseTest;
import junit.framework.Assert;
import pageEvents.DashboardPageEvents;
import pageEvents.HighwaysPageEvents;
import pageEvents.LoginPageEvents;
import pageEvents.Section50PageEventsBo;
import pageEvents2.LoginPageEvents2;
import utils.Constants;

public class Section50UatSf extends BaseTest {

//	LoginPageEvents loginPg = new LoginPageEvents();
	LoginPageEvents2 loginPg = new LoginPageEvents2();
	DashboardPageEvents dashboardPg = new DashboardPageEvents();
	HighwaysPageEvents highwaysPg = new HighwaysPageEvents();
	Section50PageEventsBo sec50 = new Section50PageEventsBo();

	@BeforeTest
	@Parameters("browser")
	public void beforeTestMethod(String browser) {
		// Set the custom report name
		reportName = "Section50BackOffice.html";
		documentTitle = "Test Server";
		// Call the base class's method to initialize with the custom report name
		super.beforeTestMethod(browser);
	}

//	@Test(priority = '1', enabled = true)
//	public void OpenWestminsterBoUrl(Method methodName) {
//		logger = extent.createTest(methodName.getName());
//
//		// Opening Westminster backoffice login page url
//		driver.get(Constants.westminsterUatSfLoginUrl);
//		String loginMessage = loginPg.enterLoginCredentials2(driver, "donchandila334@gmail.com", "Gourav@334");
//
//		logger.info(loginMessage);
//		logger.info("Enter section 50 url :");
//		driver.get();
//
//	}

}
