package validations;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class TriangleTypeAutomation {
	 private static final Logger log = Logger.getLogger(TriangleTypeAutomation.class.getName());

    public static void main(String[] args) throws InterruptedException {
    	System.setProperty("webdriver.edge.driver", "C:\\Edgedriver\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();

        driver.get("https://testpages.eviltester.com/styled/apps/triangle/triangle001.html");

        WebElement side1Input = driver.findElement(By.id("side1"));
        WebElement side2Input = driver.findElement(By.id("side2"));
        WebElement side3Input = driver.findElement(By.id("side3"));

        side1Input.sendKeys("4");
        Thread.sleep(2000);
        side2Input.sendKeys("4");
        Thread.sleep(2000);
        side3Input.sendKeys("4");
        Thread.sleep(2000);

        clickSubmitButton(driver);

        String result = getTriangleTypeFromConsole(driver);

        log.info("Triangle Type: " + result);

        driver.quit();
    }

    private static void clickSubmitButton(WebDriver driver) {
        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"identify-triangle-action\"]"));
        submitButton.click();
    }

    private static String getTriangleTypeFromConsole(WebDriver driver) {
        return driver.findElement(By.id("triangle-type")).getText();
    }
}
