package validations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class FormValidation {

    public static void main(String[] args) {
    	 System.setProperty("webdriver.edge.driver", "C:\\Edgedriver\\msedgedriver.exe");
         WebDriver driver = new EdgeDriver();

        driver.get("https://testpages.eviltester.com/styled/validation/input-validation.html");

        WebElement firstNameInput = driver.findElement(By.name("firstname"));
        WebElement lastNameInput = driver.findElement(By.name("surname"));
        WebElement ageInput = driver.findElement(By.name("age"));

        firstNameInput.sendKeys("sai charan");
        lastNameInput.sendKeys("vootkuri sai charan");
        ageInput.sendKeys("22");

        WebElement countryDropdown = driver.findElement(By.name("country"));
        Select countrySelect = new Select(countryDropdown);
        countrySelect.selectByVisibleText("India");

        WebElement noteInput = driver.findElement(By.name("notes"));
        noteInput.sendKeys("This is an input validation automation.");

        WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
        submitButton.click();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}
