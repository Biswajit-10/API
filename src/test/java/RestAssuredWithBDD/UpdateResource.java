package RestAssuredWithBDD;

import static io.restassured.RestAssured.*;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class UpdateResource {
	@SuppressWarnings("unchecked")
	@Test
	public void updatePut() {
		
		Random random=new Random();
		int randomInt = random.nextInt(1000);
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy","MILU");
		jobj.put("projectName","api");
		jobj.put("status","completed");
		jobj.put("teamSize",randomInt);
		
		
		given()
			.contentType(ContentType.JSON)
			.body(jobj)
			.put("http://localhost:8084/projects/TY_PROJ_606")
		.then()
			.assertThat()
			.contentType(ContentType.JSON)
			.and()
			.statusCode(200)
			.log().all();
}
}