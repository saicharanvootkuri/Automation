package locationtest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import commontils.TestUtilsMethod;
import pageobjectpattern.AutomatePageMethods;
import pageobjectpattern.NavigationTabMethods;

public class LocationTestAutomation extends TestUtilsMethod {

	@Test
	private static void addLocationstest() throws InterruptedException {
		NavigationTabMethods.navigationToLocationsPage();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement addButton = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[1]/div/button")));
		addButton.click();

		AutomatePageMethods.addDataToLocationsPage();
		By Locator = By.xpath("/html/body/div/div[2]");
		WebElement toastMessage = wait.until(ExpectedConditions.presenceOfElementLocated(Locator));
		AssertJUnit.assertTrue(toastMessage.isDisplayed());
		Thread.sleep(1000);
	}

	@Test
	private static void editlocationstest() throws InterruptedException {
		NavigationTabMethods.navigationToLocationsPage();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement editButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div/div[7]/div/button[2]")));
		editButton.click();
		AutomatePageMethods.editDataToLocationPage();

		By Locator = By.xpath("/html/body/div/div[2]");
		WebElement toastMessage = wait.until(ExpectedConditions.presenceOfElementLocated(Locator));
		AssertJUnit.assertTrue(toastMessage.isDisplayed());
		Thread.sleep(3000);
	}

	@Test
	private static void deletelocationstest() throws InterruptedException {
		NavigationTabMethods.navigationToLocationsPage();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div/div[7]/div/button[1]")));
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
