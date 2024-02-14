package demo;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NumberOfLinks {
	private static final Logger log = Logger.getLogger(NumberOfLinks.class.getName());

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testpages.eviltester.com/styled/index.html");

		String url = "";
		List<WebElement> allURLs = driver.findElements(By.tagName("a"));
		log.info("Total links on the web pages: " + allURLs.size());

		Iterator<WebElement> iterator = allURLs.iterator();
		while (iterator.hasNext()) {
			url = iterator.next().getText();
			log.info(url);

		}

		driver.quit();

	}

}