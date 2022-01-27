package RestAssuredWithBDD;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DeleteResource {
	@Test
	public void del() {
		when()
			.delete("http://localhost:8084/projects/TY_PROJ_625")
		.then()
			.assertThat()
			.contentType(ContentType.JSON)
			.statusCode(204)
			.log().all();
		
	}
}
