package orangehrm;

import java.time.Duration;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestLogin {

	private static final Logger log = Logger.getLogger(TestLogin.class.getName());

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.edge.driver", "C:\\Edgedriver\\msedgedriver.exe");

		WebDriver driver = new EdgeDriver();
		login(driver);
		navigateToJobTitlePage(driver);
		addJobTitle(driver, "SDE", "Responsible for software development");
		Thread.sleep(5000); // Add this to keep the page open for 5 seconds (adjust as needed)
		driver.quit();
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

	private static void navigateToJobTitlePage(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewJobTitleList");

		log.info("Navigated to the Job Titles page.");
	}

	private static void addJobTitle(WebDriver driver, String jobTitle, String jobDescription) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		WebElement addButton = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[data-v-10d463b7='']")));
		wait.until(ExpectedConditions.elementToBeClickable(addButton)).click();

		log.info("Navigated to the Add Job Title page.");

		WebElement jobTitleField = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.oxd-input--active")));
		jobTitleField.sendKeys(jobTitle);

		WebElement jobDescriptionField = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("textarea.oxd-textarea--active")));
		jobDescriptionField.sendKeys(jobDescription);

		WebElement saveButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.oxd-button--medium")));
		saveButton.click();

		log.info("Job Title added successfully.");
	}
}
