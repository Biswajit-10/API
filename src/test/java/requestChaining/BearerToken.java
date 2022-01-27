package requestChaining;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class BearerToken {
	@Test
	public void token() {
		given()
			.auth().oauth2("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")
		
		.when()
				.get("http://api.github.com/user/repos")
				.then().log().all();
			
	}
}

class practice1{
	@Test
	public void p() {
		given()
			.auth().oauth2("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")
		.get("http://api.github.com/user/repos")
			.then()
			.log().all();
	}
}