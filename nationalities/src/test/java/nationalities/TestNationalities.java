package nationalities;

import java.time.Duration;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestNationalities {

	private static final Logger log = Logger.getLogger(TestNationalities.class.getName());

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.edge.driver", "C:\\Edgedriver\\msedgedriver.exe");

		WebDriver driver = new EdgeDriver();
		login(driver);
		navigateToNationalityPage(driver);
		addNationality(driver, "Indian");
		Thread.sleep(5000);
		driver.quit();
	}

	private static void login(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));

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

	private static void navigateToNationalityPage(WebDriver driver) {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/admin/nationality");

		log.info("Navigated to the Nationalities page.");
	}

	private static void addNationality(WebDriver driver, String nationalityName) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));

		WebElement addButton = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/div[1]/div/button")));
		wait.until(ExpectedConditions.elementToBeClickable(addButton)).click();

		log.info("Navigated to the add Nationalities page.");

		WebElement nationalityNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/input")));
		nationalityNameField.sendKeys(nationalityName);

		WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(
				By.cssSelector("button.oxd-button.oxd-button--medium.oxd-button--secondary[data-v-10d463b7]")));
		saveButton.click();

		log.info("Nationality added successfully.");
	}

}
