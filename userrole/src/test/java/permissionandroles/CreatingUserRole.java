package permissionandroles;

import java.time.Duration;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreatingUserRole {

    private static final Logger log = Logger.getLogger(CreatingUserRole.class.getName());
    private WebDriver driver;

    public CreatingUserRole(WebDriver driver) {
        this.driver = driver;
    }

    public void login() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login ");
        driver.manage().window().maximize();

        String username = "Admin";
        String password = "admin123";

        WebElement usernameField = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//input[contains(@class, 'oxd-input')][@name='username']")));
        WebElement passwordField = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//input[contains(@class, 'oxd-input')][@name='password']")));
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(@class, 'orangehrm-login-button')]")));

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
        log.info("Successfully logged in OrangeORM webpage!!");
    }

    public void navigateToAddUserPage() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");
        log.info("Navigated to the Add User page.");
    }

    public void addUser(String userRole, String partialEmployeeName, String status,
                        String username, String password, String confirmPassword) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement addButton = wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")));
        wait.until(ExpectedConditions.elementToBeClickable(addButton)).click();

        WebElement userRoleDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                "/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div/div[1]")));
        userRoleDropdown.click();
        WebElement userRoleOption = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), '" + userRole + "')]")));
        userRoleOption.click();

        WebElement employeeNameField = wait.until(ExpectedConditions.elementToBeClickable(By
                .xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div/input")));
        employeeNameField.sendKeys(partialEmployeeName);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();

        WebElement statusDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                "/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div/div[1]")));
        statusDropdown.click();
        WebElement statusOption = wait
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), '" + status + "')]")));
        statusOption.click();

        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input")));
        usernameField.sendKeys(username);

        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input")));
        passwordField.sendKeys(password);

        WebElement confirmPasswordField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input")));
        confirmPasswordField.sendKeys(confirmPassword);

        WebElement saveButton = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]")));
        saveButton.click();

        log.info("User added successfully.");
    }

    public void verifyAdminAccess() {
        // Add the actual verification steps for Admin role
        WebElement adminElement = waitForElement(By.xpath("//div[@class='admin-specific-element']"));
        // Perform additional verifications if needed
        log.info("Access verified for Admin role.");
    }

    public void verifyOtherRoleAccess() {
        // Add the actual verification steps for OtherRole
        WebElement otherRoleElement = waitForElement(By.xpath("//div[@class='other-role-specific-element']"));
        // Perform additional verifications if needed
        log.info("Access verified for OtherRole.");
    }

    private WebElement waitForElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
