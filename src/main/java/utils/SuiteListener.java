package utils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IAnnotationTransformer;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.BaseTest;

public class SuiteListener implements ITestListener, IAnnotationTransformer {
	// on falure it take screen shot of page
//	public void onTestFailure(ITestResult result) {
//		// Get current local date
//		LocalDate currentDate = LocalDate.now();
//
//		// Format the date
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
//		String formattedDate = currentDate.format(formatter);
//
//		// Create filename with date
//		String filename = System.getProperty("user.dir") + File.separator + "screenshots" + File.separator
//				+ result.getMethod().getMethodName() + "_" + formattedDate;
//
//		File f1 = ((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.FILE);
//
//		try {
//			FileUtils.copyFile(f1, new File(filename + ".png"));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
}
