package com.orangehrm.admin.memberships;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.commonutils.TestUtilsMethod;
import com.pageobjectpattern.AutomatePageMethods;
import com.pageobjectpattern.NavigationTabMethods;

public class LeaveManageAutomateTest extends TestUtilsMethod {

	@Test
	private static void addMembershiptest() throws InterruptedException {
		NavigationTabMethods.navigationToMembershipPage();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement addButton = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/div[1]/div/button")));
		addButton.click();

		AutomatePageMethods.addDataToMembershipPage();
		By Locator = By.xpath("/html/body/div/div[2]");
		WebElement toastMessage = wait.until(ExpectedConditions.presenceOfElementLocated(Locator));
		AssertJUnit.assertTrue(toastMessage.isDisplayed());
		Thread.sleep(3000);
	}

	@Test
	private static void editMembershiptest() throws InterruptedException {
		NavigationTabMethods.navigationToMembershipPage();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement editButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"/html/body/div/div[1]/div[2]/div[2]/div/div/div[3]/div/div[2]/div[1]/div/div[3]/div/button[2]")));
		editButton.click();
		AutomatePageMethods.editMembershipDataPage();

		By Locator = By.xpath("/html/body/div/div[2]");
		WebElement toastMessage = wait.until(ExpectedConditions.presenceOfElementLocated(Locator));
		AssertJUnit.assertTrue(toastMessage.isDisplayed());
		Thread.sleep(3000);
	}

	@Test
	private static void deleteMembershiptest() throws InterruptedException {
		NavigationTabMethods.navigationToMembershipPage();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"/html/body/div/div[1]/div[2]/div[2]/div/div/div[3]/div/div[2]/div[1]/div/div[3]/div/button[1]")));
		deleteButton.click();

		WebElement popUpElement = driver.findElement(By.xpath("/html/body/div/div[3]/div/div/div/div[3]/button[2]"));
		popUpElement.click();
		Thread.sleep(3000);
		By Locator = By.xpath("/html/body/div/div[2]");
		WebElement toastMessage = wait.until(ExpectedConditions.presenceOfElementLocated(Locator));
		AssertJUnit.assertTrue(toastMessage.isDisplayed());
		Thread.sleep(3000);
	}

	@Test
	private static void testToShowErrorWithEmptyName() throws InterruptedException {
		NavigationTabMethods.navigationToMembershipPage();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement addButton = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/div[1]/div/button")));
		addButton.click();
		WebElement saveButton = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]")));
		saveButton.click();
		WebElement ErrorMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/span")));
		AssertJUnit.assertTrue(ErrorMessage.isDisplayed());
		Thread.sleep(3000);
	}

}
