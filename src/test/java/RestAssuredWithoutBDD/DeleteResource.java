package RestAssuredWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class DeleteResource {
	@Test
	public void dlt() {
		Response response=RestAssured.delete("http://localhost:8084/projects/TY_PROJ_2002");
		ValidatableResponse validateRes = response.then();
		validateRes.assertThat().statusCode(204);
		validateRes.log().all();
	}
}
