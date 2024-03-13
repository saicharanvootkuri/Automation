package pageobjectpattern;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commontils.TestUtilsMethod;

public class AutomatePageMethods extends TestUtilsMethod {

	public static void addDataToLocationsPage()throws InterruptedException {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	    String locationName = config.getProperty("addName.locationName");
	    WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div/div/div[2]/input")));
	    nameField.sendKeys(locationName);
	    
	    String locationcity = config.getProperty("addName.locationcity");
	    WebElement cityField = wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input")));
	    cityField.sendKeys(locationcity);
	    
	    String locationstate = config.getProperty("addName.locationstate");
	    WebElement stateField = wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input")));
	    stateField.sendKeys(locationstate);
	    
	    String locationzipCode= config.getProperty("addName.locationzipCode");
	    WebElement zipCodeField = wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[3]/div/div[2]/input")));
	    zipCodeField.sendKeys(locationzipCode);
	    
	   

		WebElement userRoleDropdown = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[4]/div/div[2]/div/div")));
		userRoleDropdown.click();
		WebElement userRoleOption = wait.until(ExpectedConditions.presenceOfElementLocated(
				   By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[4]/div/div[2]/div/div/div[5]")));
		userRoleOption.click();


	    
//	    
//	    String phoneno = config.getProperty("addName.locationName");
//	    WebElement phoneField = wait.until(ExpectedConditions.visibilityOfElementLocated(
//	            By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[5]/div/div[2]/input")));
//	    phoneField.sendKeys(config.getProperty("location.phoneNumber"));
//
//	    WebElement addressField = wait.until(ExpectedConditions.visibilityOfElementLocated(
//	            By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[7]/div/div[2]/textarea")));
//	    addressField.sendKeys(config.getProperty("location.address"));

	    WebElement saveButton = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]"));
	    wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();


	    Thread.sleep(3000);
	}



	public static void editDataToLocationPage() throws InterruptedException {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	    String editlocationName = config.getProperty("addName.editlocationName");
	    WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div/div/div[2]/input")));
	    nameField.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
	    nameField.sendKeys(editlocationName);
	    
	    String editlocationcity = config.getProperty("addName.editlocationcity");
	    WebElement cityField = wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input")));
	    nameField.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
	    cityField.sendKeys(editlocationcity);
	    
	    String editlocationstate = config.getProperty("addName.editlocationstate");
	    WebElement stateField = wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input")));
	    nameField.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
	    stateField.sendKeys(editlocationstate);
	    
	    String editlocationzipCode= config.getProperty("addName.editlocationzipCode");
	    WebElement zipCodeField = wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[3]/div/div[2]/input")));
	    nameField.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
	    zipCodeField.sendKeys(editlocationzipCode);
	    
	    WebElement userRoleDropdown = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[4]/div/div[2]/div/div")));
		userRoleDropdown.click();
		WebElement userRoleOption = wait.until(ExpectedConditions.presenceOfElementLocated(
				   By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[4]/div/div[2]/div/div/div[4]")));
		nameField.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		userRoleOption.click();
	    
//	    
//	    String phoneno = config.getProperty("addName.locationName");
//	    WebElement phoneField = wait.until(ExpectedConditions.visibilityOfElementLocated(
//	            By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[5]/div/div[2]/input")));
//	    phoneField.sendKeys(config.getProperty("location.phoneNumber"));
//
//	    WebElement addressField = wait.until(ExpectedConditions.visibilityOfElementLocated(
//	            By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[7]/div/div[2]/textarea")));
//	    addressField.sendKeys(config.getProperty("location.address"));

	    WebElement saveButton = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]"));
	    wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();





	    Thread.sleep(3000);
	    }

	}

