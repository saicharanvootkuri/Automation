package validations;

import java.time.Duration;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalculatorValidation {
    private static final Logger log = Logger.getLogger(CalculatorValidation.class.getName());

    public static void main(String[] args) {
        System.setProperty("webdriver.edge.driver", "C:\\Edgedriver\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.get("https://testpages.eviltester.com/styled/calculator");

        performCalculation(driver, "plus");
        performCalculation(driver, "minus");
        performCalculation(driver, "times");
        performCalculation(driver, "divide");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    private static void performCalculation(WebDriver driver, String operation) {
        WebElement number1Input = driver.findElement(By.name("number1"));
        WebElement number2Input = driver.findElement(By.name("number2"));
        WebElement operationDropdown = driver.findElement(By.name("function"));
        WebElement calculateButton = driver.findElement(By.xpath("/html/body/div/div[3]/form/div[2]/input"));

        number1Input.clear();
        number1Input.sendKeys("25");
        number2Input.clear();
        number2Input.sendKeys("25");

        operationDropdown.sendKeys(operation);

        calculateButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement resultElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"answer\"]")));

        String resultText = resultElement.getText();

        log.info("Calculation performed for " + operation + ". Result: " + resultText);
    }
}
