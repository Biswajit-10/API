package RestAssuredWithBDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GetAllResource {
	@Test(enabled=false)
	public void get1() {
//		.when		//wrong
		
		
		Response response = when()
			.get("http://localhost:8084/projects");
		System.out.println(response.getContentType()); 
		System.out.println(response.getTime()); 
		System.out.println(response.getStatusCode()); 
		response.then()
			.assertThat()
			.contentType(ContentType.JSON)
			.and()
			.statusCode(200)
			.log().all();
	}
	@Test
	public void get2() {
		
		get("http://localhost:8084/projects")
		.then()
			.assertThat().contentType(ContentType.JSON)
			.statusCode(200)
			.log().all();
		
	}
}
