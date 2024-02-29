package parameters;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class PathAndQueryParameters {
@Test
	void testQueryAndPathPArameters() {

		given().pathParam("mypath", "users").queryParam("page", 2).queryParam("id", 5)

				.when().get("https://reqres.in/api/{mypath}")

				.then().statusCode(200).log().all();

	}

}
