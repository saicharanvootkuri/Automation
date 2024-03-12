package leavemanagement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Logger;

public class VerifyLeaveApplication {

    private static final Logger log = Logger.getLogger(VerifyLeaveApplication.class.getName());

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        login(driver);
        applyLeave(driver);
        driver.quit();
    }

    private static void login(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login ");

        driver.manage().window().maximize();

        String username = "Admin";
        String password = "admin123";

        WebElement usernameField = wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//input[contains(@class, 'oxd-input')][@name='username']")));
        WebElement passwordField = wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//input[contains(@class, 'oxd-input')][@name='password']")));
        WebElement loginButton = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//button[contains(@class, 'orangehrm-login-button')]")));

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();

        log.info("Successfully logged in.");
    }

    private static void applyLeave(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Assuming there is a "Leave" link/button after login, update the XPath accordingly
        WebElement leaveLink = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//a[contains(@class, 'leave-link')]")));
        leaveLink.click();

        // Assuming there is a "Apply for Leave" link/button after navigating to the Leave page
        WebElement applyLeaveButton = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//button[contains(@class, 'apply-leave-button')]")));
        applyLeaveButton.click();

        // Assuming there are fields for leave start date, end date, and a submit button
        WebElement startDateField = wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//input[@id='startDate']")));
        WebElement endDateField = wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//input[@id='endDate']")));
        WebElement submitButton = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//button[@id='submitLeaveButton']")));

        // Set leave dates
        startDateField.sendKeys("2024-03-15");
        endDateField.sendKeys("2024-03-20");

        // Submit leave application
        submitButton.click();

        // Assuming there is a confirmation message after applying for leave
        WebElement confirmationMessage = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[@class='leave-confirmation-message']")));

        // Perform assertions or log messages to verify the success of leave application
        assert confirmationMessage.isDisplayed() : "Leave application confirmation message not displayed.";
        log.info("Leave application successful.");
    }
}
