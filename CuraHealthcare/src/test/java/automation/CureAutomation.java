package automation;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CureAutomation {
    public static void main(String[] args) {
        // Set the path to the EdgeDriver executable
        System.setProperty("webdriver.edge.driver", "C:\\Edgedriver\\msedgedriver.exe");

        // Instantiate an EdgeDriver class.
        WebDriver driver = new EdgeDriver();

        // Set up WebDriverWait with a timeout of 25 seconds
        WebDriverWait wait = new WebDriverWait(driver, 25);

        // Navigate to the URL
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        // Maximize the browser window
        driver.manage().window().maximize();

        // Close the browser
        driver.close();
    }
}
