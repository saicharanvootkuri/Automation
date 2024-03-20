package pageobjectpattern;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonutils.TestUtilsMethod;

public class AutomatePageMethods extends TestUtilsMethod {

	public static void addDataToSkillsPage() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		String skillsName = config.getProperty("addName.skillsName");
		WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//form/div[1]/div/div[2]/input")));
		nameField.sendKeys(skillsName);
		

		String skillsDescription = config.getProperty("addName.skillsDescription");
		WebElement nameField1 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//form/div[2]//textarea")));
		nameField1.sendKeys(skillsDescription);
		

		WebElement saveButton = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[@type='submit']")));
		saveButton.click();

		Thread.sleep(3000);

	}

	public static void editSkillsDataPage() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		String editskillName = config.getProperty("addName.editskillName");

		WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//form/div[1]/div/div[2]/input")));
		nameField.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		nameField.sendKeys(editskillName);
		
		String editskillDescription = config.getProperty("addName.editskillDescription");
		WebElement nameField1 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//form/div[2]//textarea")));
		nameField.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		nameField.sendKeys(editskillDescription);

		WebElement saveButton = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[@type='submit']")));
		saveButton.click();

		Thread.sleep(3000);
	}

}
