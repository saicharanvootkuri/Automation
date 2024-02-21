package utilitymethod;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtilityMethod {

    private static final Logger log = Logger.getLogger(UtilityMethod.class.getName());

    public static void main(String[] args) {
        System.setProperty("webdriver.edge.driver", "C:\\Edgedriver\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();

        String expectedPassword = "admin123";
        boolean isPasswordMatching = extractAndComparePassword(driver, expectedPassword);

        if (isPasswordMatching) {
            log.info("Password matches the expected value: " + expectedPassword);
        } else {
            log.info("Password does not match the expected value: " + expectedPassword);
        }

        driver.quit();
    }

    private static boolean extractAndComparePassword(WebDriver driver, String expectedPassword) {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login ");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement passwordElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/div[1]/div/p[2]")));

        String actualPassword = passwordElement.getText().trim();

        int numericValue = extractNumber(actualPassword);
        log.info("Numeric Value in Compared Element: " + numericValue);

        log.info("Actual Password: " + actualPassword);

        return actualPassword.contains(expectedPassword);
    }

    private static int extractNumber(String text) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            return Integer.parseInt(matcher.group());
        } else {
            return -1;
        }
    }
}
