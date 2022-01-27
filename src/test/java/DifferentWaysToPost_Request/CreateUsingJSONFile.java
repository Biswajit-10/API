package DifferentWaysToPost_Request;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateUsingJSONFile {
	@Test
	public void create() {
		File f=new File("./src/test/resources/jsonData.json");
		
	given()
		.contentType(ContentType.JSON)
		.body(f)
		.post("http://localhost:8084/addProject")
	.then()
		.assertThat()
		.contentType(ContentType.JSON)
		.and()
		.statusCode(201)
		.log().all();
	}
}
