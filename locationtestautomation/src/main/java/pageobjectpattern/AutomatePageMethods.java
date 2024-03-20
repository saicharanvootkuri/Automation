package pageobjectpattern;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commontils.TestUtilsMethod;

public class AutomatePageMethods extends TestUtilsMethod {

	public static void addDataToLocationsPage() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

		String locationName = config.getProperty("addName.locationName");
		WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//form/div[1]/div/div/div/div[2]/input")));
		nameField.sendKeys(locationName);
		Thread.sleep(3000);
		String locationcity = config.getProperty("addName.locationcity");
		WebElement cityField = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//form/div[2]/div/div[1]/div/div[2]/input")));
		cityField.sendKeys(locationcity);
		Thread.sleep(3000);
		String locationstate = config.getProperty("addName.locationstate");
		WebElement stateField = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//form/div[2]/div/div[2]/div/div[2]/input")));
		stateField.sendKeys(locationstate);
		Thread.sleep(3000);
		String locationzipCode = config.getProperty("addName.locationzipCode");
		WebElement zipCodeField = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//form/div[2]/div/div[3]/div/div[2]/input")));
		zipCodeField.sendKeys(locationzipCode);
		Thread.sleep(3000);
		WebElement countryDropdown = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//form/div[2]/div/div[4]/div/div[2]/div/div/div[1]")));
		countryDropdown.click();
		WebElement countryOption = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[4]/div/div[2]/div/div/div[5]")));
		countryOption.click();
		Thread.sleep(3000);

		WebElement saveButton = driver
				.findElement(By.xpath("//form/div[3]/button[2]"));
		wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
		Thread.sleep(3000);
	}

	public static void editDataToLocationPage() throws InterruptedException {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	    String editlocationName = config.getProperty("addName.editlocationName");
	    WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("//form/div[1]/div/div/div/div[2]/input")));
	    nameField.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
	    nameField.sendKeys(editlocationName);
	    Thread.sleep(3000);
	    
	    String editlocationcity = config.getProperty("addName.editlocationcity");
	    WebElement cityField = wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("//form/div[2]/div/div[1]/div/div[2]/input")));
	    cityField.sendKeys(Keys.CONTROL, "a", Keys.DELETE); // Corrected to use cityField instead of nameField
	    cityField.sendKeys(editlocationcity);
	    Thread.sleep(3000);
	    
	    String editlocationstate = config.getProperty("addName.editlocationstate");
	    WebElement stateField = wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("//form/div[2]/div/div[2]/div/div[2]/input")));
	    stateField.sendKeys(Keys.CONTROL, "a", Keys.DELETE); // Corrected to use stateField instead of nameField
	    stateField.sendKeys(editlocationstate);
	    Thread.sleep(3000);
	    
	    String editlocationzipCode= config.getProperty("addName.editlocationzipCode");
	    WebElement zipCodeField = wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("//form/div[2]/div/div[3]/div/div[2]/input")));
	    zipCodeField.sendKeys(Keys.CONTROL, "a", Keys.DELETE); // Corrected to use zipCodeField instead of nameField
	    zipCodeField.sendKeys(editlocationzipCode);
	    Thread.sleep(3000);
	    
	    WebElement countryDropdown = wait.until(ExpectedConditions.elementToBeClickable(
	            By.xpath("//form/div[2]/div/div[4]/div/div[2]/div/div/div[1]")));
	    countryDropdown.click();
	    WebElement countryOption = wait.until(ExpectedConditions.presenceOfElementLocated(
	            By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[4]/div/div[2]/div/div/div[2]")));
	    countryOption.click();
	    Thread.sleep(3000);
	    
	    WebElement saveButton = driver.findElement(By.xpath("//form/div[3]/button[2]"));
	    wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
	    Thread.sleep(3000);
	}

}
