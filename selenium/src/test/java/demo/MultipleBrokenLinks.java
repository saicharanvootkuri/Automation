package demo;

import java.io.FileInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Logger;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleBrokenLinks {
	private static final Logger log = Logger.getLogger(MultipleBrokenLinks.class.getName());

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		int totalLinks = 0;
		int brokenLinks = 0;

		try {
			FileInputStream file = new FileInputStream("C:\\Users\\Admin\\Desktop\\Data\\Book2.xlsx");
			Workbook workbook = WorkbookFactory.create(file);
			Sheet sheet = workbook.getSheetAt(0);

			int rowCount = sheet.getPhysicalNumberOfRows();
			log.info("Total rows in Excel: " + rowCount);

			for (int i = 0; i < rowCount; i++) {
				Row row = sheet.getRow(i);
				String url = row.getCell(0).getStringCellValue();

				if (!url.isEmpty()) {
					totalLinks++;
					if (isLinkBroken(url)) {
						brokenLinks++;
						log.info("Broken Link in Row " + (i + 1) + ": " + url);
					}
				}
			}

			log.info("Total Links: " + totalLinks);
			log.info("Broken Links: " + brokenLinks);

			workbook.close();
		} catch (Exception e) {
			log.severe("Exception occurred: " + e.getMessage());
		}

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