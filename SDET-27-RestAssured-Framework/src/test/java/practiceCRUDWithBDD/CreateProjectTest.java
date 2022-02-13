package practiceCRUDWithBDD;

import static io.restassured.RestAssured.given;
import static org.testng.annotations.Test.*;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateProjectTest {

	@Test
	
	public void createProject() {
		Random ran = new Random();
		int randomNum = ran.nextInt(500);
	
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "Mohanlal");
		jobj.put("projectName", "BroDaddy"+randomNum);
		jobj.put("status", "Created");
		jobj.put("teamSize", 100);
		
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
