package loginfunctionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Logger;

public class VerifyForgetPassword {

    private static final Logger log = Logger.getLogger(VerifyForgetPassword.class.getName());

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        testForgotPassword(driver);
        driver.quit();
    }

    private static void testForgotPassword(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        driver.manage().window().maximize();

        // Locate the "Forgot your password?" link and click on it
        WebElement forgotPasswordLink = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[4]/p")));
        forgotPasswordLink.click();

        // Wait for the elements on the "Forgot Password" page
        WebElement usernameField = wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/div/form/div[1]/div/div[2]/input")));
        WebElement resetButton = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/div/form/div[2]/button[2]")));

        // Enter a valid email address (you may adjust this based on your requirements)
        String usernameAddress = "test@example.com";
        usernameField.sendKeys(usernameAddress);

        // Click on the "Reset" button
        resetButton.click();

        // Wait for the confirmation message or other elements on the page after resetting
        WebElement confirmationMessage = wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/div/h6")));

        // Perform assertions to verify the success of the "Forgot Password" functionality
        assert confirmationMessage.isDisplayed() : "Confirmation message not displayed after resetting password.";
        assert confirmationMessage.getText().contains("Password") : "Incorrect confirmation message after resetting password.";

        log.info("Forgot Password functionality test passed: Password reset successfully.");
    }
}
