package qa.test;
import java.lang.reflect.Method;

import org.testng.annotations.*;
import base.BaseTest;
import junit.framework.Assert;
import pageEvents2.LoginPageEvents2;
import pageEvents2.Section50PageEvents2;
import utils.Constants;
import utils.SeleniumUtils;

public class Section50TestServerSfbo extends BaseTest {

//	LoginPageEvents loginPg = new LoginPageEvents();
	LoginPageEvents2 loginPg = new LoginPageEvents2();
	Section50PageEvents2 sec50 = new Section50PageEvents2();
	@BeforeTest
	@Parameters("browser")
	public void beforeTestMethod(String browser) {
		// Set the custom report name
		reportName = "Section50TSBackOffice.html";
		documentTitle = "Test Server";
		// Call the base class's method to initialize with the custom report name
		super.beforeTestMethod(browser);
	}

	@Test(priority = '1', enabled = true)
	public void OpenWestminsterBoUrl(Method methodName) {
		logger = extent.createTest(methodName.getName());

		// Opening Westminster backoffice login page url
		driver.get(Constants.westminsterTestServerSfboLoginUrl);
		String loginMessage = loginPg.enterLoginCredentials2(driver, "gwise", "t33rtS3!");

		logger.info(loginMessage);
		logger.info("Enter section 50 url :");
		
		driver.get(Constants.section50TestServerSfboUrl);
//		SeleniumUtils.someDelay(1000);
		logger.info("Current url is : "+driver.getCurrentUrl());

	}
	
	@Test(priority = '2', enabled = true)
	public void fillBusinessDetails(Method methodName) {
		logger = extent.createTest(methodName.getName());
		String businessDetailsMessage = sec50.fillBusinessDetails("36211","test@fgl.com");
		logger.info(businessDetailsMessage);
		Assert.assertEquals(businessDetailsMessage, "Success: Customer search successfully");
		logger.info(driver.getCurrentUrl());
		logger.info(businessDetailsMessage);

	}

}
