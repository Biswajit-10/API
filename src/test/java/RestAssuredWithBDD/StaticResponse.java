package RestAssuredWithBDD;


import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class StaticResponse {
	@Test()
	public void response() {
		String expectedProjectName="project";
		 Response response = when()
			.get("http://localhost:8084/projects");
		String actualProjectName = response.jsonPath().get("[1].projectName");
		System.out.println(actualProjectName);
		
		response.then()
		.assertThat().statusCode(200)
		.and().contentType(ContentType.JSON)
		.log().all();
		Assert.assertEquals(expectedProjectName, actualProjectName);
	}
}
