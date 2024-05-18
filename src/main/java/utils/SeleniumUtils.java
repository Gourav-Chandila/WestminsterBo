package utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.imageio.ImageIO;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class SeleniumUtils {
	private static ElementFetch ele = new ElementFetch();

	// Usage SeleniumUtils.scrollToBottom("body");
	public static void scrollToBottom(String pageElement) {
		ele.getWebElement("TAGNAME", pageElement).sendKeys(Keys.END);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt(); // Restore interrupted status
		}

	}

	/*
	 * Usage WebDriver driver = BaseTest.getDriver(); String
	 * findByMethodValue="//div[@class='panel panel-info panel-default my_panel']/div[@class='panel-heading'][text()='Payments and refunds']"
	 * ; SeleniumUtils.scrollToElement(driver,"XPATH",findByMethodValue);
	 */
	public static void scrollToElement(WebDriver driver, String findbyMethod, String findByMethodValue) {
		WebElement element = ele.getWebElement(findbyMethod, findByMethodValue);
		// Scroll to the element using JavaScriptExecutor
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	// Function used for add some pause takes one argument in seconds like 2000=2Sec
	public static void someDelay(Integer timeInSeconds) {
		try {
			Thread.sleep(timeInSeconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// usage captureFullPageSS(driver,"thisSsScreenSHot")
	public static String captureFullPageScreenShot(WebDriver driver, String screenshotNameFullPage) {
		// 1.48 horizontal 1000 vertical
		Screenshot screenshot = new AShot()
				.shootingStrategy(ShootingStrategies.viewportPasting(ShootingStrategies.scaling(1.48f), 1000))
				.takeScreenshot(driver);

		// Saving the screenshot
		String dest = System.getProperty("user.dir") + "/PullPageScreenshots/" + screenshotNameFullPage + ".png";
		try {
			ImageIO.write(screenshot.getImage(), "PNG", new File(dest));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dest;
	}

	// sendEmailWithAttachment("System.getProperty("user.dir") + File.separator +
	// "reports"
	// + File.separator +
	// "Section50ExtentReport.html","hellowchandila@gmail.com","Gourav")
	public static void sendEmailWithAttachment(String reportPath, String recipientEmail, String recipientName) {
		final String username = "gouravchandila34@gmail.com"; // Your email
		final String password = "vzflzbaiadzowarq"; // Your password

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com"); // for Gmail
		props.put("mail.smtp.port", "587"); // for TLS

		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
			message.setSubject("Extent Report");

			// Personalized greeting
			String greeting = "Hello " + recipientName + ",";

			// Email body with explanation and instructions
			String body = greeting + "\n\n" + "1.Please find attached the Extent report.\n"
					+ "2.This report contains important information about XYZ.\n"
					+ "3.Please review it carefully and let me know if you have any questions.\n\n" + "Best regards,\n"
					+ "Gourav Chandila";

			// Create a multipart message
			Multipart multipart = new MimeMultipart();

			// Create the message part for text
			MimeBodyPart textPart = new MimeBodyPart();
			textPart.setText(body);

			// Set the attachment
			MimeBodyPart attachmentPart = new MimeBodyPart();
			DataSource source = new FileDataSource(reportPath);
			attachmentPart.setDataHandler(new DataHandler(source));

			// Set the desired file name here
			attachmentPart.setFileName("Section50_regression_report.html");

			// Add parts to the multipart
			multipart.addBodyPart(textPart);
			multipart.addBodyPart(attachmentPart);

			// Set the multipart as the message content
			message.setContent(multipart);

			// Send message
			Transport.send(message);

			System.out.println("Email sent successfully.");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	
	
	 public static WebElement waitForElementToBeClickable(WebDriver driver, WebElement cardPayButton, Duration timeout) {
	        WebDriverWait wait = new WebDriverWait(driver, timeout);
	        return wait.until(ExpectedConditions.elementToBeClickable(cardPayButton));
	    }
	 
	 public static WebElement waitForElementToBeDisplayed(WebDriver driver, WebElement cardPayButton, Duration timeout) {
		    WebDriverWait wait = new WebDriverWait(driver, timeout);
		    return wait.until(ExpectedConditions.visibilityOf(cardPayButton));
		}

}
