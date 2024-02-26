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
			log.info("Rerunning only failed tests...");

			JUnitCore rerunJUnit = new JUnitCore();
			Result rerunResult = rerunJUnit.run(testClass);

			for (Failure failure : rerunResult.getFailures()) {
				log.info("Rerun Failure: " + failure.toString());
			}

			log.info("Rerun Result: " + rerunResult.wasSuccessful());
		} else {
			for (Failure failure : result.getFailures()) {
				log.info("Failure: " + failure.toString());
			}

			log.info("Result: " + result.wasSuccessful());
		}
	}

	public static void main(String[] args) throws IOException {
		runTests(TestSuite.class);
	}
}
