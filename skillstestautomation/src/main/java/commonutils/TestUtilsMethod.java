package commonutils;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import lombok.extern.slf4j.Slf4j;
import pageobjectpattern.OrangeHRMAutoLogin;

@Slf4j
public class TestUtilsMethod {
	public static WebDriver driver;
	private OrangeHRMAutoLogin orangeHRMAutoLogin;
	public static Properties config;

	static {
		config = new Properties();
		try {
			config.load(TestUtilsMethod.class.getClassLoader().getResourceAsStream("config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Setup method to launch the browser before the test suite
	@BeforeSuite
	public void launchBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", config.getProperty("webdriver.chrome.driver"));
		driver = new ChromeDriver();
		orangeHRMAutoLogin = new OrangeHRMAutoLogin(driver, config);
		log.info("Launching the browser...");
		orangeHRMAutoLogin.login();
		log.info("Login To Webpage...");

	}

	// Teardown method to close the browser after the test suite
	@AfterSuite
	public void closingBrowser() {
		driver.quit();
		log.info("Closing the browser...");
	}

	// Method to capture a screenshot
	public void getScreenshot() throws IOException {
		Date currentDate = new Date();

		// Format the date and time to create a unique filename (converted Date object to string)
		String screenshotFilename = currentDate.toString().replace(" ", "_").replace(":", "-");

		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile,
				new File("C:\\Users\\Admin\\Downloads\\TestFailSnaps\\" + screenshotFilename + ".png"));
		log.info("Screenshot captured and saved at: C:\\Users\\Admin\\Downloads\\TestFailSnaps" + screenshotFilename
				+ ".png");
	}

}
