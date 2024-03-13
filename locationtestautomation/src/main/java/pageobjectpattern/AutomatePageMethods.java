package pageobjectpattern;


import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
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
	    
	    String  locationcountry= config.getProperty("addName.locationcountry");
	    WebElement countryDropdown = wait.until(ExpectedConditions.elementToBeClickable(
	            By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[4]/div/div[2]/div/div")));
	    countryDropdown.click();
	    WebElement country = wait.until(
	            ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), '" + locationcountry + "')]")));
	    country.click();
	    
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
	    nameField.sendKeys(editlocationName);
	    
	    String editlocationcity = config.getProperty("addName.editlocationcity");
	    WebElement cityField = wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input")));
	    cityField.sendKeys(editlocationcity);
	    
	    String editlocationstate = config.getProperty("addName.editlocationstate");
	    WebElement stateField = wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input")));
	    stateField.sendKeys(editlocationstate);
	    
	    String editlocationzipCode= config.getProperty("addName.editlocationzipCode");
	    WebElement zipCodeField = wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[3]/div/div[2]/input")));
	    zipCodeField.sendKeys(editlocationzipCode);
	    
	    String  editlocationcountry= config.getProperty("addName.editlocationcountry");
	    WebElement countryDropdown = wait.until(ExpectedConditions.elementToBeClickable(
	            By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[4]/div/div[2]/div/div")));
	    countryDropdown.click();
	    WebElement country = wait.until(
	            ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), '" + editlocationcountry + "')]")));
	    country.click();
	    
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

