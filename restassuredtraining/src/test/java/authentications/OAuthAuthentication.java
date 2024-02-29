package authentications;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

public class OAuthAuthentication {

	@Test
	void testOAuth1Authentication() {
		given().auth().oauth("consumerKey", "consumerSecret", "accessToken", "tokenSecret").when()
				.get("https://api.github.com/user/repos").then().statusCode(200).log().all();
	}
}
