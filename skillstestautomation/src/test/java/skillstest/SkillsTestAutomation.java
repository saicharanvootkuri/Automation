package skillstest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import commonutils.TestUtilsMethod;
import pageobjectpattern.AutomatePageMethods;
import pageobjectpattern.NavigationTabMethods;

public class SkillsTestAutomation extends TestUtilsMethod {

	@Test
	private static void addSkillstest() throws InterruptedException {
		NavigationTabMethods.navigationToSkillsPage();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement addButton = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='oxd-icon bi-plus oxd-button-icon']")));
		addButton.click();

		AutomatePageMethods.addDataToSkillsPage();
		By Locator = By.xpath("/html/body/div/div[2]");
		WebElement toastMessage = wait.until(ExpectedConditions.presenceOfElementLocated(Locator));
		AssertJUnit.assertTrue(toastMessage.isDisplayed());
		Thread.sleep(3000);
	}

	@Test
	private static void editskillstest() throws InterruptedException {
		NavigationTabMethods.navigationToSkillsPage();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement editButton = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[@class='oxd-layout-context']//div[2]//button[2]//i[1]")));
		editButton.click();
		AutomatePageMethods.editSkillsDataPage();

		By Locator = By.xpath("/html/body/div/div[2]");
		WebElement toastMessage = wait.until(ExpectedConditions.presenceOfElementLocated(Locator));
		AssertJUnit.assertTrue(toastMessage.isDisplayed());
		Thread.sleep(3000);
	}

	@Test
	private static void deletelocationstest() throws InterruptedException {
		NavigationTabMethods.navigationToSkillsPage();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement deleteButton = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//i[contains(@class, 'oxd-icon') and contains(@class, 'bi-trash')]")));
		deleteButton.click();

		WebElement popUpElement = driver.findElement(By.xpath("/html/body/div/div[3]/div/div/div/div[3]/button[2]"));
		popUpElement.click();
		Thread.sleep(3000);
		By Locator = By.xpath("/html/body/div/div[2]");
		WebElement toastMessage = wait.until(ExpectedConditions.presenceOfElementLocated(Locator));
		AssertJUnit.assertTrue(toastMessage.isDisplayed());
		Thread.sleep(3000);
	}
}
