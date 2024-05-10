package base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.SeleniumUtils;

public class BaseTest {

	public static WebDriver driver;
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest logger;

	protected String reportName = "DefaultReport.html";
	protected String documentTitle = "Default Title";

	// Base class setup method, accepting customization through parameters
	@BeforeTest
	@Parameters({ "browser" })
	public void beforeTestMethod(String browser) {
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(
				System.getProperty("user.dir") + File.separator + "reports" + File.separator + reportName);
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);

		sparkReporter.config().setDocumentTitle(documentTitle);
		sparkReporter.config().setReportName(reportName);
		sparkReporter.config().setTheme(Theme.STANDARD);

		// Report Configuration
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Browser", browser);
		extent.setSystemInfo("OS", "Windows 10");
		extent.setSystemInfo("Java Version", System.getProperty("java.version"));
		
		// Set up the driver and other configurations
		setupDriver(browser, true);
	}

	// After the completion of test than it generates the report
	@AfterTest
	public void afterTest() {
		extent.flush();
		// driver.quit();
		// Calls function to send email it accepts two args 'filePath','recipientEmail'
		try {
//			SeleniumUtils.sendEmailWithAttachment(System.getProperty("user.dir") + File.separator + "reports"
//					+ File.separator + "Section50ExtentReport.html", "hellowchandila@gmail.com", "Gourav");
//			System.out.println("Email sent successfully.");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed to send email: " + e.getMessage());
		}
	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "  " + "FAIL", ExtentColor.RED));
			logger.fail(result.getThrowable());
			// Add screenshot on failure
			captureAndAddScreenshot(result.getMethod().getMethodName());
//			String screenshotPath = SeleniumUtils.captureFullPageScreenShot(driver, result.getMethod().getMethodName());
//			logger.fail("Fullpage ScreenShot :" + logger.addScreenCaptureFromPath(screenshotPath));

		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + "  " + "PASS", ExtentColor.GREEN));
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + "  " + "SKIP", ExtentColor.YELLOW));
		}

	}

	// Various driver setup with ignore ssl certificates
	public void setupDriver(String browser, boolean ignoreSSLCertificates) {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			if (ignoreSSLCertificates) {
				options.setAcceptInsecureCerts(true);
			}
			driver = new ChromeDriver(options);
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			if (ignoreSSLCertificates) {
				options.addPreference("security.insecure_field_warning.contextual.enabled", false);
			}
			driver = new FirefoxDriver(options);
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			EdgeOptions options = new EdgeOptions();
			if (ignoreSSLCertificates) {
				options.setCapability("acceptInsecureCerts", true);
			}
			driver = new EdgeDriver(options);
		}
	}

	// Method to capture screenshot and add to logs on test failure
	public void captureAndAddScreenshot(String methodName) {
		try {
			LocalDate currentDate = LocalDate.now();
			// Format the date
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
			String formattedDate = currentDate.format(formatter);

			// Capture screenshot
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			// Save screenshot to a file
			String screenshotPath = System.getProperty("user.dir") + File.separator + "screenshots" + File.separator
					+ methodName + "_" + formattedDate + ".png";
			FileUtils.copyFile(screenshot, new File(screenshotPath));
			// Add screenshot to logs
			logger.fail("Screenshot below: ", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
