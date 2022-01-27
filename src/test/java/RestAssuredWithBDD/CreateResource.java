package RestAssuredWithBDD;

import static io.restassured.RestAssured.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

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
		
		
		Response response = given()
			.contentType(ContentType.JSON)
			.body(jobj)
			.post("http://localhost:8084/addProject");
		response.then()
			.assertThat()
			.contentType(ContentType.JSON)
			.and()
			.statusCode(201)
			.log().all()
			.time(Matchers.lessThan(3000L));
		long longExpTime = response.getTimeIn(TimeUnit.MICROSECONDS);
		System.out.println(longExpTime);
		
		
	}
}


