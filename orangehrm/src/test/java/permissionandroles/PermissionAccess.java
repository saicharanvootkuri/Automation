package permissionandroles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PermissionAccess{

    private WebDriver driver;
    private CreatingUserRole creatingUserRole;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
        driver = new ChromeDriver();
        creatingUserRole = new CreatingUserRole(driver);
    }

    @AfterTest
    public void tearDown() {
        creatingUserRole.quitDriver();
    }

    @Test
    public void testAdminUserRole() {
        creatingUserRole.login();
        creatingUserRole.navigateToAddUserPage();
        creatingUserRole.addUser("Admin", "sai charan", "Disabled", "saicharanreddy", "Password123", "Password123");
        PermissionAccess.verifyAccessPermissions(driver, "Admin");
    }

	private static void verifyAccessPermissions(WebDriver driver2, String string) {
		
	}

//    @Test
//    public void testOtherUserRole() {
//        creatingUserRole.login();
//        creatingUserRole.navigateToAddUserPage();
//        creatingUserRole.addUser("ESS", "laxmi kanth", "Enabled", "laxmikanthreddy", "Password123", "Password123");
//        PermissionAccess.verifyAccessPermissions(driver, "OtherRole");
//    }
}
