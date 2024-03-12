package commonutils;


import java.io.IOException;
import java.util.logging.Logger;

import org.testng.ITestListener;
import org.testng.ITestResult;


public class Listeners extends TestUtilsMethod implements ITestListener {
	private static final Logger log = Logger.getLogger(Listeners.class.getName());

	/**
	 * Called when a test case is starting.
	 * @param result Information about the test result.
	 */
	public void onTestStart(ITestResult result) {
		log.info("Test case is starting");
	}

	/**
	* Called when a test case gets fails.
	* Capture a screenshot upon test failure.
	* @param result Information about the failed test result.
	*/
	public void onTestFailure(ITestResult result) {
		log.info("Test Fails - Screenshot capturing !!");
		try {
			getScreenshot();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}