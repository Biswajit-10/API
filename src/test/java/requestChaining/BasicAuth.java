package requestChaining;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class BasicAuth {
	@Test
	public void basicAuth() {
		given()
			.auth().basic("rmgyantra","rmgy@9999")
		
		.when()
				.get("http://localhost:8084/login")
				.then().log().all();
			
	}
}
class Practice{
	@Test
	public void practice() {
		given()
			.auth().basic("rmgyantra","rmgy@9999")
//		.when()
			.get("http://localhost:8084/login")
				.then().log().all();
	}
}