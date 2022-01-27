package A;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Api.Generics.BaseApiClass;
import com.Api.Generics.IEndPoints;
import com.Api.Generics.JavaUtility;
import com.Api.Generics.PojoLibrary;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AddSingleProjectWithCreatedStatus extends BaseApiClass{
	
	@Test
	public void addSingleProjectWithCreatedStatus() throws Throwable {
		
		String projNAme = "BTM"+JavaUtility.getRanDomNum();
		
		PojoLibrary pobj = new PojoLibrary("milu mi", projNAme, "Created", 10);
		
		Response resp = given()						// pre conditions
						  .contentType(ContentType.JSON)
						  .body(pobj)
						.when()                             // actual http test
						   .post(IEndPoints.ADDSIcNGLEPROJECTWITHCREATEDSTATUS);

		resp.then()
		     .log().all()
		     .and()
		     .contentType(ContentType.JSON);
		
		//capture Project NAme & status
		    String apiProjecName  = resp.jsonPath().get("projectName");
		    String apiStatus  = resp.jsonPath().get("status");
					  
	     //write Selenium program to capture data from GUI
		    
		 //Write JDBC program to capture data from Mysql DB
		    String projectNAmeresult = dbLib.executeQueryAndGetData("select * from project" ,4 , apiProjecName);
		    Assert.assertEquals(projectNAmeresult,apiProjecName);
		    String projectStatus = dbLib.executeQueryAndGetData("select * from project" ,5 , apiStatus);
		    Assert.assertEquals(projectStatus,apiStatus);

		    
	}

}