package A;

import org.testng.annotations.Test;

import com.Api.Generics.Employs;
import com.Api.Generics.JavaUtility;
import com.Api.Generics.PojoLibrary;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Create_Project_and_Allocate_USER {

	
	@Test
	public void createProject_WithUSer() {
		String status = "Completed";
		String projectNAme = "SDET_22_"+JavaUtility.getRanDomNum();
		PojoLibrary pobj = new PojoLibrary("deepak", projectNAme, status, 10);		
		//execute API and get the data & verify
          Response resp = given()
        		             .contentType(ContentType.JSON)
        		             .body(pobj).when()
        		             .post("/addProject");
		           resp.then()
						    .assertThat().statusCode(201)
						    .log().all();
		          String apiResponseProjectNAme =  resp.jsonPath().get("projectName");
		          
		          
		  //create user for above project
				   Employs empPojoObj = new Employs("sdet", "12/12/1990", "deepak@gmail.com", "deepak_gowda", 15, "9886662262", apiResponseProjectNAme, "ROLE_ADMIN", "deepak_gowda");      
		                  given()
						     .contentType(ContentType.JSON)
						     .body(empPojoObj)
						    .when()
						     .post("/employees")
		           .then()
		               .assertThat().statusCode(201)
		               .log().all();
		          
		          
	}
}