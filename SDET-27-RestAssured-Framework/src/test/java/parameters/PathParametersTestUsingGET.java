package parameters;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PathParametersTestUsingGET {

	@Test
	public void pathParametersTest() {
		given()
		  .pathParam("projectID", "TY_PROJ_224")
		.when()
		   .get("http://localhost:8084/projects/{projectID}")
		.then()
		   .assertThat().statusCode(200)
		   .contentType(ContentType.JSON)
		   .log().all();
		   
	}
}
