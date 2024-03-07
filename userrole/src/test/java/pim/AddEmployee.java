package pim;

import java.time.Duration;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddEmployee {

	private static final Logger log = Logger.getLogger(AddEmployee.class.getName());
	private WebDriver driver;

	public AddEmployee(WebDriver driver) {
		this.driver = driver;
	}

	public void login() throws InterruptedException {
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
		Thread.sleep(1000);
		passwordField.sendKeys(password);
		Thread.sleep(1000);
		loginButton.click();
		log.info("Successfully logged in OrangeHRM webpage!!");
	}

	public void navigateToAddUserPage() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList");
		log.info("Navigated to the View Employee List page.");
	}

	public void navigateToAddEmployeePage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Wait for the "Add" button to be clickable
		WebElement addButton = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")));

		addButton.click();

		// Wait for the URL to change to the "Add Employee" page
		wait.until(
				ExpectedConditions.urlToBe("https://opensource-demo.orangehrmlive.com/web/index.php/pim/addEmployee"));

		log.info("Clicked on the 'Add' button to navigate to Add Employee page.");
	}

	public void fillEmployeeDetails(String firstName, String lastName) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Wait for the "First Name" and "Last Name" fields to be present
		WebElement firstNameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[1]/div/div/div[2]/div[1]/div[2]/input")));
		WebElement lastNameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[1]/div/div/div[2]/div[3]/div[2]/input")));

		// Fill in the first name and last name
		firstNameField.sendKeys(firstName);
		Thread.sleep(1000);
		lastNameField.sendKeys(lastName);
		Thread.sleep(1000);

		log.info("Filled in employee details.");
	}

	public void saveEmployee() throws InterruptedException {
		WebElement saveButton = driver
				.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]"));

		saveButton.click();
		Thread.sleep(1000);
		log.info("Clicked on the 'Save' button.");
		driver.quit();
	}

}
