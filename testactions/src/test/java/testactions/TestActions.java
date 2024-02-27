package testactions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.logging.Logger;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestActions {
	private static final Logger log = Logger.getLogger(TestActions.class.getName());

	public static void main(String[] args) throws InterruptedException, AWTException {
		System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/Admin/Downloads/learningportel.html");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.id("openModalBtn")).click();
		
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		String alertMessage =driver.switchTo().alert().getText();
		log.info(alertMessage);
		Thread.sleep(3000);
		alert.accept();
		Robot robot = new Robot();
		robot.mouseMove(400, 5);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(2000);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(2000);
		driver.quit();
		
	}
}
