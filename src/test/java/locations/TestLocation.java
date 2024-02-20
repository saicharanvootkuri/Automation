package locations;

import java.time.Duration;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestLocation {

	private static final Logger log = Logger.getLogger(TestLocation.class.getName());

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.edge.driver", "C:\\Edgedriver\\msedgedriver.exe");

		WebDriver driver = new EdgeDriver();
		login(driver);
		navigateToLocations(driver);
		addLocation(driver, "Dummy Location", "Dummy City", "Dummy State", "12345", "India", "1234567890",
				"Dummy Address");
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

	private static void navigateToLocations(WebDriver driver) {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewLocations");

		log.info("Navigated to the Locations page.");
	}

	private static void addLocation(WebDriver driver, String name, String city, String state, String postalCode,
			String country, String phoneNumber, String address) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));

		WebElement addButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"//button[@class='oxd-button oxd-button--medium oxd-button--secondary' and @data-v-10d463b7='']")));
		wait.until(ExpectedConditions.elementToBeClickable(addButton)).click();

		log.info("Navigated to the Add Location page.");

		WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("location_name")));
		nameField.sendKeys(name);

		WebElement cityField = driver.findElement(By.id("location_city"));
		cityField.sendKeys(city);

		WebElement stateField = driver.findElement(By.id("location_state"));
		stateField.sendKeys(state);

		WebElement postalCodeField = driver.findElement(By.id("location_zipCode"));
		postalCodeField.sendKeys(postalCode);

		WebElement countryDropdown = driver.findElement(By.id("location_country"));
		countryDropdown.click();

		WebElement countryOption = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[@class='oxd-select-text-input' and text()='India']")));
		countryOption.click();

		WebElement phoneNumberField = driver.findElement(By.id("location_phone"));
		phoneNumberField.sendKeys(phoneNumber);

		WebElement addressField = driver.findElement(By.id("location_address"));
		addressField.sendKeys(address);

		WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//button[@type='submit' and @class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space' and @data-v-10d463b7='']")));
		saveButton.click();

		log.info("Location added successfully.");
	}
}