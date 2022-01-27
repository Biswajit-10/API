package RestAssuredWithoutBDD;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CreateResource {
	@SuppressWarnings("unchecked")
	@Test
	public void create() {
		Random random=new Random();
		int randomInt = random.nextInt(1000);
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy","MILU"+randomInt);
		jobj.put("projectName","api"+randomInt);
		jobj.put("status","completed");
		jobj.put("teamSize",7);
		
		RequestSpecification reqSpec=RestAssured.given();
		reqSpec.contentType(ContentType.JSON);		//for post it is mandatory
		reqSpec.body(jobj);
		Response response = reqSpec.post("http://localhost:8084/addProject");
		
		ValidatableResponse validateResponse = response.then();
		validateResponse.assertThat().statusCode(201);
		validateResponse.assertThat().contentType(ContentType.JSON);
		validateResponse.log().all();
		
	}
}
