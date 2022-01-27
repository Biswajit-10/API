package requestChaining;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import com.Api.Generics.PojoLibrary;


import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostAndDelete {
	@Test
	public void postanddelete() {
		PojoLibrary pobj = new PojoLibrary("biswajitrajershekarpawan", "brpm", "upcoming", 3);
		 Response response = given()
		.body(pobj)
		.contentType(ContentType.JSON)
		.when()
		.post("http://localhost:8084/addProject");
		String projectID=response.jsonPath().get("projectId");
		System.out.println(projectID);
		given()
		.pathParam("projectId", projectID)
			.when()
			.delete("http://localhost:8084/projects/{projectId}")
			.then()
			.statusCode(204);
			
	}
}
