package authentications;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class BearTokenAuthentication {
	
	@Test
	void testBearerTokenAuthentication() {
		String bearerToken="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";
		
		given()
		.headers("Authorization","Bearer"+bearerToken)
		
		.when()
		.get("https://api.github.com/user/repos")
		
		.then()
		.statusCode(200)
		.log().all();
		
		
	}
}

