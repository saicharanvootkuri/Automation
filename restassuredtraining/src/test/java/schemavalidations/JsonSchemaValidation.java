package schemavalidations;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;
public class JsonSchemaValidation {

	@Test
	void jsonschemavalidation() {
		
		given()
		
		.when()
		.get("http://localhost:8000/fruits.json")
		
		.then()
		.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("fruitsschema.json"));
		
		
		
	}

}