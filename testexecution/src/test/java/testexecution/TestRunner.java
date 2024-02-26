package testexecution;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

	private static final Logger log = Logger.getLogger(TestRunner.class.getName());
	private static final String config_file = "config.properties";

	public static boolean shouldExecuteFailedTests() throws IOException {
		Properties prop = new Properties();

		InputStream input = TestRunner.class.getClassLoader().getResourceAsStream(config_file);
		if (input == null) {
			throw new IOException("Sorry, unable to find " + config_file);
		}

		prop.load(input);
		return Boolean.parseBoolean(prop.getProperty("execute_failed_tests", "false"));
	}

	public static void runTests(Class<?> testClass) throws IOException {
		JUnitCore junit = new JUnitCore();
		Result result = junit.run(testClass);

		if (shouldExecuteFailedTests() && !result.getFailures().isEmpty()) {
			runFailedTests(testClass);
		} else {
			for (Failure failure : result.getFailures()) {
				log.info("Failure: " + failure.toString());
			}

			log.info("Result: " + result.wasSuccessful());
		}
	}

	public static void runFailedTests(Class<?> testClass) throws IOException {
		if (!shouldExecuteFailedTests()) {
			log.info("Skipping execution of failed tests based on configuration.");
			return;
		}

		int maxRetries = 5;
		int retryCount = 0;

		do {
			log.info("Rerunning failed tests... Attempt #" + (retryCount + 1));

			JUnitCore junit = new JUnitCore();
			Result result = junit.run(testClass);

			for (Failure failure : result.getFailures()) {
				log.info("Rerun Failure: " + failure.toString());
			}

			log.info("Rerun Result: " + result.wasSuccessful());

			if (result.wasSuccessful()) {
				break;
			}

			retryCount++;
		} while (retryCount < maxRetries);

		if (retryCount == maxRetries) {
			log.info("Max retry attempts reached. Test execution failed after " + maxRetries + " attempts.");
		}
	}

	public static void main(String[] args) throws IOException {
		runTests(TestSuite.class);
	}
}
