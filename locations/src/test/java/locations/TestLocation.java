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
		addLocation(driver, "kokapet", "Hyderabad", "Telangana", "12345", "India", "1234567890", "gandipet");
		Thread.sleep(5000);
		driver.quit();
	}

	private static void login(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

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
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

		WebElement addButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"//button[@class='oxd-button oxd-button--medium oxd-button--secondary' and @data-v-10d463b7='']")));
		wait.until(ExpectedConditions.elementToBeClickable(addButton)).click();

		log.info("Navigated to the Add Location page.");

		By nameFieldLocator = By
				.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div/div/div[2]/input");
		WebElement nameField = wait.until(ExpectedConditions.presenceOfElementLocated(nameFieldLocator));

		By cityFieldLocator = By
				.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input");
		WebElement cityField = wait.until(ExpectedConditions.presenceOfElementLocated(cityFieldLocator));

		By stateFieldLocator = By
				.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input");
		WebElement stateField = wait.until(ExpectedConditions.presenceOfElementLocated(stateFieldLocator));

		By zipCodeFieldLocator = By
				.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[3]/div/div[2]/input");
		WebElement zipCodeField = wait.until(ExpectedConditions.presenceOfElementLocated(zipCodeFieldLocator));

		By countryDropdownLocator = By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]");
		WebElement countryDropdown = wait.until(ExpectedConditions.presenceOfElementLocated(countryDropdownLocator));

		By phoneFieldLocator = By
				.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[5]/div/div[2]/input");
		WebElement phoneField = wait.until(ExpectedConditions.presenceOfElementLocated(phoneFieldLocator));

		By addressFieldLocator = By
				.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[7]/div/div[2]/textarea");
		WebElement addressField = wait.until(ExpectedConditions.presenceOfElementLocated(addressFieldLocator));

		nameField.sendKeys(name);
		cityField.sendKeys(city);
		stateField.sendKeys(state);
		zipCodeField.sendKeys(postalCode);
		phoneField.sendKeys(phoneNumber);
		addressField.sendKeys(address);

		countryDropdown.click();
		WebElement countryOption = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//div[@class='oxd-dropdown']/div[contains(text(),'" + country + "')]")));
		countryOption.click();

		WebElement saveButton = driver
				.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]"));
		wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();

		log.info("Location added successfully.");
	}
}