package waysToPostRequest;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateResourceUsingHashMapTest {

	@Test
	public void createResourceUsingHashMapTest() {
		HashMap map = new HashMap();
		
		map.put("createdBy", "MuruganBro");
		map.put("projectName", "TYSS Bangalore");
		map.put("status", "Created");
		map.put("teamSize", 324);
		
		given()
		    .body(map)
		    .contentType(ContentType.JSON)
		.when()
		    .post("http://localhost:8084/addProject")
		.then()
		    .assertThat().statusCode(201)
		    .contentType(ContentType.JSON)
		    .log().all();
		
	}
}
