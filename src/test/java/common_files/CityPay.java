package common_files;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.SeleniumUtils;

public class CityPay {
	public static void main(String args[]) {
		// Automatically setup Firefox WebDriver
		WebDriverManager.firefoxdriver().setup();

		// Create a new instance of Firefox browser
		WebDriver driver = new FirefoxDriver();
		driver.get("https://payments.citypay.com/UlYDFQpGAw/NDg4MTgwMzk0Mjc2MDE2MDM0ODI/start?lang=en");

//		WebElement drop = driver.findElement(By.xpath("//div[@id='testmode-buttons']"));
//		drop.click();
//		WebElement master = driver.findElement(By.xpath("//b[text()='MasterCard Credit']"));
//		master.click();
		
		SeleniumUtils.someDelay(2000);
		SeleniumUtils.scrollToElement(driver,"xpath","//button[@id='cancel']");
		SeleniumUtils.someDelay(2000);
		
//		WebElement process = driver.findElement(By.xpath("//button[@id='process']"));
//		process.click();
		
	}
}
