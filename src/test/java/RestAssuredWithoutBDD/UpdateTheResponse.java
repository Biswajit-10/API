package RestAssuredWithoutBDD;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UpdateTheResponse {
	@SuppressWarnings("unchecked")
	@Test
	public void update() {
		Random random=new Random();
		int randomInt = random.nextInt(1000);
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy","MILU 007");
		jobj.put("projectName","api"+randomInt);
		jobj.put("status","on going");
		jobj.put("teamSize",1);
		
	
		

		RequestSpecification reqSpec=RestAssured.given();
		reqSpec.contentType(ContentType.JSON);
		reqSpec.body(jobj);
		reqSpec.contentType("application/json");
		Response response = reqSpec.put("http://localhost:8084/projects/TY_PROJ_804");
		
		ValidatableResponse validateResponse = response.then();
		validateResponse.assertThat().contentType(ContentType.JSON);
		validateResponse.log().all();
	}
}
