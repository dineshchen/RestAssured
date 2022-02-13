package requestChaining;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class RequestChaining {

	@Test
	 public void requestChaining() {
	Response resp=when()
		  .get("http://localhost:8084/projects");
	String proID=resp.jsonPath().get("[1].projectId");
	System.out.println(proID);
	
	given()
	  .pathParam("projectId", proID)
	.when()
	  .delete("http://localhost:8084/projects/{projectId}")
	.then()
	   .assertThat().statusCode(204)
	   .log().all();
	
	}
}
