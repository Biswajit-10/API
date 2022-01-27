package RestAssuredWithBDD;

import static io.restassured.RestAssured.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class DynamicResponse {
	@Test()
	public void response() {
		
		String expectedProjectName="TY_PROJ_604";
		 Response response = when()
			.get("http://localhost:8084/projects");
		 List<String> allProjects=response.jsonPath().get("projectId");
		 boolean a=false;
		 for(String project:allProjects) {
			 if(project.equals(expectedProjectName)) {
				 a=true;
			 }
		 }
		 Assert.assertEquals(a, true);
	}
}
