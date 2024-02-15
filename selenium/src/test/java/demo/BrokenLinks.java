package demo;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {
	private static final Logger log = Logger.getLogger(BrokenLinks.class.getName());

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://demo.guru99.com/test/newtours/");

		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		log.info("Total links on the web page: " + allLinks.size());

		int brokenLinksCount = 0;

		for (WebElement link : allLinks) {
			String url = link.getAttribute("href");
			if (url != null && !url.isEmpty() && isLinkBroken(url)) {
				log.info("Broken Link: " + url);

				brokenLinksCount++;
			}
		}

		log.info("Number of broken links: " + brokenLinksCount);

		driver.quit();
	}

	private static boolean isLinkBroken(String url) {
		try {
			HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
			connection.setRequestMethod("HEAD");
			return connection.getResponseCode() != 200;
		} catch (Exception e) {
			log.severe("Exception occurred: " + e.getMessage());
			return true;
		}
	}
}
