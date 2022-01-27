package assignment;

import static io.restassured.RestAssured.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Api.Generics.PojoLibrary;
import com.mysql.cj.jdbc.Driver;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class VerifyProName {
	@Test
	public void verify() throws Exception {
		PojoLibrary pobj = new PojoLibrary("biswajitrajershekarpawan", "pi", "upcoming", 3);
		 Response response = given()
					.body(pobj)
					.contentType(ContentType.JSON)
					.when()
					.post("http://localhost:8084/addProject");
					String projectName=response.jsonPath().get("projectName");
					System.out.println(projectName);
					
					


					Connection con = null;
					try{
					Driver driverref=new Driver();
					DriverManager.registerDriver(driverref);
					
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
					
					Statement stat = con.createStatement();
					
					ResultSet set = stat.executeQuery("select project_name from project");
					
					boolean b = false;
					while(set.next()){  
						if(projectName==set.getString(1)) {
							b=true;
							Assert.assertEquals(projectName, set.getString(1));
							System.out.println("project is created");
							break;
						}
							
					}
					if(b==false) {
						System.out.println("project is not created");
					}
					}
					catch (Exception e) {
					}
					finally{
					con.close();
					}
				
				
	}
}
