package Practice;

import java.time.Duration;
import java.util.logging.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {

	public static void main(String[] args) throws InterruptedException {
		 final Logger log = Logger.getLogger(Login.class.getName());
		System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");

		WebElement usernameField = driver.findElement(By.id("username"));
		WebElement passwordField = driver.findElement(By.id("password"));
		WebElement radioButton = driver.findElement(By.cssSelector("input[type='radio'][value='user']"));
		WebElement okayButton = driver.findElement(By.cssSelector("#okayBtn"));
		WebElement checkBox = driver.findElement(By.cssSelector("input[type='checkbox']")); // Updated selector
		WebElement signInButton = driver.findElement(By.cssSelector("#signInBtn"));

		String userInfo = driver.findElement(By.cssSelector("p.text-center.text-white")).getText();
		String username = driver.findElement(By.cssSelector("p.text-center.text-white")).getText().split(" ")[2].trim();
		String text = driver.findElement(By.cssSelector("p.text-center.text-white")).getText();

		String[] parts = text.split(" ");
		String passwordPart = parts[6];
		String password = passwordPart.substring(0, passwordPart.length() - 1);
		usernameField.sendKeys(username);
		Thread.sleep(2000);
		passwordField.sendKeys(password);
		Thread.sleep(2000);
		radioButton.click();
		Thread.sleep(2000);
		okayButton.click();
		Thread.sleep(2000);
		if (!checkBox.isSelected()) {
			checkBox.click();
		}
		Thread.sleep(2000);
		signInButton.click();
		
		signInButton.click();
		log.info("Username: " + username);
		log.info("Password: " + password);
		
		// Switch to the new window or tab
				for (String handle : driver.getWindowHandles()) {
				    driver.switchTo().window(handle);
				}

				// Wait for the new page to load
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
				wait.until(ExpectedConditions.urlContains("angularpractice/shop"));

				// Get the current URL of the page after redirection
				String redirectedURL = driver.getCurrentUrl();

				// Print the redirected URL to the console
				log.info("Redirected URL: " + redirectedURL);
		
	
	}
}
