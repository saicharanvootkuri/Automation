package authentications;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

public class BasicAuthentication {

	@Test
	void testBasicAuthentication() {

		given().auth().basic("postman", "password")

				.when().get("https://postman-echo.com/basic-auth")

				.then().statusCode(200).body("authenticated", equalTo(true)).log().all();

	}
}