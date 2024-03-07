package pim;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AddEmployeeTest {
	   private WebDriver driver;

    @Test(priority = 1)
    public void testAddEmployee() throws InterruptedException {
    	System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
        driver = new ChromeDriver();
        AddEmployee addEmployee = new AddEmployee(driver);

        try {
            addEmployee.login();
            addEmployee.navigateToAddUserPage();
            addEmployee.navigateToAddEmployeePage();

            String firstName = "laxmi";
            String lastName = "kanth";
            addEmployee.fillEmployeeDetails(firstName, lastName);

            addEmployee.saveEmployee();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.urlContains("expected_redirected_url"));

        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}

