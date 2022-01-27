package requestChaining;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GetAndDelete {
	@Test
	public void requestChaining() {
		
		Response response = when()
			.get("http://localhost:8084/projects");
		String proId = response.jsonPath().get("[1].projectId");
		response.then().log().all();
		given()
			.pathParam("projectID", proId)
		.when()
			.delete("http://localhost:8084/projects/{projectID}")
			  .then()
				.assertThat().statusCode(204)
				.log().all();
//		.jsonPath().get()
		
	}
}
