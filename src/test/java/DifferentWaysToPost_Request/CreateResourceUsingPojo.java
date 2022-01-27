package DifferentWaysToPost_Request;

import org.testng.annotations.Test;

import com.Api.Generics.PojoLibrary;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateResourceUsingPojo {
	@Test
	public void create() {
		PojoLibrary plib=new PojoLibrary("MILU","java v","started",6);
		
		given()
			.contentType(ContentType.JSON)
			.body(plib)
		.when()	
			.post("http://localhost:8084/addProject")
		.then()
			.assertThat()
			.contentType(ContentType.JSON)
			.statusCode(201)
			.log().all();
	}
}
