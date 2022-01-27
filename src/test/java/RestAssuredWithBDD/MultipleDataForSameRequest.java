package RestAssuredWithBDD;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import com.Api.Generics.PojoLibrary;

import io.restassured.http.ContentType;

public class MultipleDataForSameRequest {
	@Test(dataProvider="multiData")
	public void create(String createdBy, String projectName, String status, int teamSize) {
		PojoLibrary plib = new PojoLibrary( createdBy,  projectName,  status,  teamSize);
		
		given()
		.body(plib)
		.contentType(ContentType.JSON)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat()
		.contentType(ContentType.JSON)
		.and() 
		.statusCode(201)
		.log().all();
	}
	@DataProvider
	public Object[][] multiData() {
		Object[][] objArray = new Object[2][4];
		
		objArray[0][0]="Muni Guruji";
		objArray[0][1]="Guru 2";
		objArray[0][2]="completed";
		objArray[0][3]=4;
		
		objArray[1][0]="raj ji";
		objArray[1][1]="raj 3";
		objArray[1][2]="completed";
		objArray[1][3]=2;
		return objArray;
	}
}
