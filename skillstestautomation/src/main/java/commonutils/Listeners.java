package commonutils;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Listeners extends TestUtilsMethod implements ITestListener {

	public void onTestStart(ITestResult result) {
		log.info("Test case is starting");
	}
	public void onTestFailure(ITestResult result) {
		log.info("Test Fails - Screenshot capturing !!");
		try {
			getScreenshot();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
