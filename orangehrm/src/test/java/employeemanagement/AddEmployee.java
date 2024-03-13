package employeemanagement;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddEmployee {

    private static final Logger log = Logger.getLogger(AddEmployee.class.getName());

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        login(driver);

        // Additional steps after login
        redirectToSystemUsersPage(driver);
        clickAddButton(driver);
        fillSystemUserDetails(driver);

        driver.quit();
    }

    private static void login(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        String username = "Admin";
        String password = "admin123";

        WebElement usernameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")));
        WebElement passwordField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")));
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")));

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();

        wait.until(ExpectedConditions.titleContains("Dashboard"));

        log.info("Successfully logged in.");
    }


    private static void redirectToSystemUsersPage(WebDriver driver) {
        // Redirect to the desired page after login
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");

        // Wait for the page to load (you may need to add more specific conditions)
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.titleContains("System Users"));

        log.info("Successfully redirected to System Users page.");
    }

    private static void clickAddButton(WebDriver driver) {
        // Click the "Add" button
        WebElement addButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button"));
        addButton.click();

        log.info("Clicked on the 'Add' button.");
    }

    private static void fillSystemUserDetails(WebDriver driver) {
        // Fill in the system user details on the "Save System User" page
        Select userRoleDropdown = new Select(driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div/div[1]")));
        userRoleDropdown.selectByVisibleText("Admin");

        Select statusDropdown = new Select(driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div/div[1]")));
        statusDropdown.selectByVisibleText("Enabled");

        WebElement employeeNameField = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div/input"));
        employeeNameField.sendKeys("sai charan");

        WebElement usernameField = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input"));
        usernameField.sendKeys("saicharanreddy");

        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input"));
        passwordField.sendKeys("Password123");

        WebElement confirmPasswordField = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input"));
        confirmPasswordField.sendKeys("Password123");

        // Click the "Save" button
        WebElement saveButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]"));
        saveButton.click();

        // Optionally, you can wait for a success message or any other relevant element
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("successMessage")));

        log.info("System user details saved successfully.");
    }
}
