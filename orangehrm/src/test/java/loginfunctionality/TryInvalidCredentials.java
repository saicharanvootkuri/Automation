package loginfunctionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Logger;

public class TryInvalidCredentials {

    private static final Logger log = Logger.getLogger(TryInvalidCredentials.class.getName());

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        verifyInvalidLogin(driver);
        driver.quit();
    }

    private static void verifyInvalidLogin(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        driver.manage().window().maximize();

        String invalidUsername = "InvalidUser";
        String invalidPassword = "InvalidPassword";

        WebElement usernameField = wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//input[contains(@class, 'oxd-input')][@name='username']")));
        WebElement passwordField = wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//input[contains(@class, 'oxd-input')][@name='password']")));
        WebElement loginButton = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//button[contains(@class, 'orangehrm-login-button')]")));

        usernameField.sendKeys(invalidUsername);
        passwordField.sendKeys(invalidPassword);
        loginButton.click();

        // Wait for the element with the provided XPath to be visible
        WebElement errorMessageElement = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p")));

        // Get and display the error message text
        String errorMessage = errorMessageElement.getText();
        System.out.println("Error message after invalid login attempt: " + errorMessage);

        log.info("Invalid login test passed: User cannot log in with invalid credentials.");
    }
}
