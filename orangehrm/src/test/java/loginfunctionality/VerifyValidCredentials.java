package loginfunctionality;

import java.time.Duration;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VerifyValidCredentials {

	private static final Logger log = Logger.getLogger(VerifyValidCredentials.class.getName());

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		login(driver);

		// Add verification step
		try {
			verifySuccessfulLogin(driver);
			log.info("Login test passed: Successfully logged in with valid credentials.");
		} catch (AssertionError e) {
			log.warning("Login test failed: Unable to verify successful login with valid credentials.");
			e.printStackTrace();
		} finally {
			driver.quit();
		}
	}

	private static void login(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login ");

		driver.manage().window().maximize();

		String username = "Admin";
		String password = "admin123";

		WebElement usernameField = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//input[contains(@class, 'oxd-input')][@name='username']")));
		WebElement passwordField = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//input[contains(@class, 'oxd-input')][@name='password']")));
		WebElement loginButton = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[contains(@class, 'orangehrm-login-button')]")));

		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		loginButton.click();

		log.info("Successfully logged in.");
	}

	private static void verifySuccessfulLogin(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Increase the wait time

		// Wait for the URL to change after successful login
		wait.until(ExpectedConditions.urlContains("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"));

		// Add assertion to check if the URL contains "/home"
		assert driver.getCurrentUrl().contains("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index") : "URL does not contain '/home' after login.";
	}

}
