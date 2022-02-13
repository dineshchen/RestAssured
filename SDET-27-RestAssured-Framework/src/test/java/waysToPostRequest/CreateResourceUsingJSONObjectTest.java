package waysToPostRequest;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateResourceUsingJSONObjectTest {

	@Test
	public void createResource() {
		Random ran = new Random();
		int randomNum = ran.nextInt();
		
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Lal");
		jobj.put("projectName", "aeta"+randomNum);
		jobj.put("status", "Created");
		jobj.put("teamSize", 222);
		
		given()
		   .body(jobj)  
		   .contentType(ContentType.JSON)
		.when()
		   .post("http://localhost:8084/addProject")
		.then()
		   .assertThat().statusCode(201)
		   .contentType(ContentType.JSON)
		   .log().all();
	}
}
