package requestChaining;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class OauthAuthentication {
	@Test
	public void oAuth2() {
		Response response = given()
		.formParam("client_id","TestJob456")
		.formParam("client_secret","52624787e7861c02ff60f96ecf6513a9")
		.formParam("grant_type","client_credentials")
		.formParam("redirect_uri","https://www.TestJob456.com")
		
		.when()
			.post("http://coop.apps.symfonycasts.com/token");
		
	    String token = response.jsonPath().get("access_token");
		given()
			.auth().oauth2(token)
			.pathParam("USER_ID", 2548)
		.when()
			.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/chickens-feed")
		.then()
			.log().all();
	}
}
class practice3{
	@Test
	public void p3() {
		String token = given()
			.formParam("client_id","TestJob456")
			.formParam("client_secret","52624787e7861c02ff60f96ecf6513a9")
			.formParam("grant_type","client_credentials")
			.formParam("redirect_uri","https://www.TestJob456.com")
		.when()
			.post("http://coop.apps.symfonycasts.com/token").jsonPath().get("access_token");
		
		given()
			.auth().oauth2(token)
			.pathParam("USER_ID", 2548)
			
		.when()
			.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/chickens-feed")
		.then()	
			.log().all();
	}
}












