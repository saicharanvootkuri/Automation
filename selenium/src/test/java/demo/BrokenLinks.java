package demo;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://testpages.eviltester.com/styled/index.html");

		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println("Total links on the web page: " + allLinks.size());

		int brokenLinksCount = 0;

		for (WebElement link : allLinks) {
			String url = link.getAttribute("href");
			if (url != null && !url.isEmpty() && isLinkBroken(url)) {
				System.out.println("Broken Link: " + url);
				brokenLinksCount++;
			}
		}

		System.out.println("Number of broken links: " + brokenLinksCount);

		driver.quit();
	}

	private static boolean isLinkBroken(String url) {
		try {
			HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
			connection.setRequestMethod("HEAD");
			return connection.getResponseCode() != 200;
		} catch (Exception e) {
			return true;
		}
	}
}
