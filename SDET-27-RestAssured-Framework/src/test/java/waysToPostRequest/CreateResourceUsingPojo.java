package waysToPostRequest;

import org.testng.annotations.Test;

import PojoLibrary.PojoClass;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateResourceUsingPojo {

	@Test
	public void createResourceUsingPojo() {
		PojoClass pojo = new PojoClass("Rahul", "SDET Project", "completed", 102);
		given()
		   .body(pojo)
		   .contentType(ContentType.JSON)
		.when()
		    .post("http://localhost:8084/addProject")
		.then()
		     .assertThat().statusCode(201)
		     .contentType(ContentType.JSON)
		     .log().all();
		
	}
}
