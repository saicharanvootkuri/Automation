package skills;

import java.time.Duration;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestSkills {

	private static final Logger log = Logger.getLogger(TestSkills.class.getName());

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.edge.driver", "C:\\Edgedriver\\msedgedriver.exe");

		WebDriver driver = new EdgeDriver();
		login(driver);
		navigateToJobTitlePage(driver);
		addSkill(driver, "MERN", "fullstack");
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

	private static void navigateToJobTitlePage(WebDriver driver) {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSkills");

		log.info("Navigated to the skills page.");
	}

	private static void addSkill(WebDriver driver, String skillName, String skillDescription) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));

		WebElement addButton = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[1]/div/button")));
		wait.until(ExpectedConditions.elementToBeClickable(addButton)).click();

		log.info("Navigated to the add skills page.");

		WebElement skillNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
				"div#app > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div > div > form > div:nth-child(1) > div > div:nth-child(2) > input")));
		skillNameField.sendKeys(skillName);

		WebElement skillDescriptionField = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector("textarea.oxd-textarea.oxd-textarea--active.oxd-textarea--resize-vertical")));
		skillDescriptionField.sendKeys(skillDescription);

		WebElement saveButton = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]")));
		saveButton.click();

		log.info("skill added successfully.");
	}

}
