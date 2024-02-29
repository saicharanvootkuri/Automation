package parsing;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import java.util.logging.Logger;

import org.testng.Assert;
import org.testng.annotations.Test;

import cookies.CookiesDemo;
import io.restassured.response.Response;

public class ParsingJsonResponse {
	private static final Logger log = Logger.getLogger(CookiesDemo.class.getName());

	// Method-1
	@Test
	void TestJsonRespons() {

		given().contentType("ContentType.JSON")

				.when().get("http://localhost:8000/fruits.json")

				.then().statusCode(200).header("Content-Type", "application/json")
				.body("fruits[4].taste", equalTo("Sweet"));
	}

	// Method-2
	@Test
	void testJosnResponseBodyData() {
		Response res = given().contentType("application/json").when().get("http://localhost:8000/fruits.json");

		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertTrue(res.header("Content-Type").startsWith("application/json"));

		String fruitsName = res.jsonPath().getString("fruits[4].taste");
		Assert.assertEquals(fruitsName, "Sweet");

	}
}
