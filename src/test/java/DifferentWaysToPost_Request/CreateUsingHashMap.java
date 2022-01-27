package DifferentWaysToPost_Request;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateUsingHashMap {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void create() {
		
		Random random=new Random();
		int randomInt = random.nextInt(1000);
		
		HashMap hobj=new HashMap();
		hobj.put("createdBy","MILU");
		hobj.put("projectName","api"+randomInt);
		hobj.put("status","completed");
		hobj.put("teamSize",randomInt);
		
		given()
			.contentType(ContentType.JSON)
			.body(hobj)
			.post("http://localhost:8084/addProject")
			
		.then()
			.assertThat()
			.contentType(ContentType.JSON)
			.and()
			.statusCode(201)
			.log().all();
	}
}
