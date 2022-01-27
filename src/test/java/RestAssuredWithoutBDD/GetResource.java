package RestAssuredWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetResource {
	@Test
	public void get() {
//		RestAssured restAssured = new RestAssured(); 
//		Response response=restAssured.get("http://localhost:8084/projects");
	
		/* it is static method don't create object */
		Response response=RestAssured.get("http://localhost:8084/projects");

		/* print output or response */
		
//		System.out.println(response.prettyPrint());
//		System.out.println(response.prettyPeek());
//		System.out.println(response.asString());
	
		/* print content type, response time, status code, header and session id */
		
		
		  System.out.println(response.getContentType());
		  System.out.println(response.getTime());
		  System.out.println(response.getStatusCode());
		  System.out.println(response.getSessionId());
		 
	
	}
}
