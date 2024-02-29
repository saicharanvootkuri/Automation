package cookies;

import static io.restassured.RestAssured.given;


import java.util.Map;
import java.util.logging.Logger;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class CookiesDemo {
	private static final Logger log = Logger.getLogger(CookiesDemo.class.getName());


	@Test
	void testCookies() {

		given()

				.when().get("https://www.google.com")

				.then().log().all();

	}

	@Test
	void getCookieInfo() {
		Response res = given().when().get("https://www.google.com/");
		String cookie_value = res.getCookie("AEC");
		log.info("Value of Cookie is " + cookie_value);

		Map<String, String> cookies_values = res.getCookies();
		log.info("cookies value set is " + cookies_values.keySet());
	}
}
