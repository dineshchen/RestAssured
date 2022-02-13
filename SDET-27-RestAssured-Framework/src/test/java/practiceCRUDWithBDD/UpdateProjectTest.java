package practiceCRUDWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class UpdateProjectTest {

	@Test
	public void updateProject() {
		Random ran = new Random();
		int randomNum = ran.nextInt(500);
	
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "Mohanlal");
		jobj.put("projectName", "BroDaddy"+randomNum);
		jobj.put("status", "Created");
		jobj.put("teamSize", 1000);
		
		given()
		   .body(jobj)
		   .contentType(ContentType.JSON)
		.when()
		    .put("http://localhost:8084/projects/TY_PROJ_1805")
		.then()
		.assertThat().contentType(ContentType.JSON)
		.statusCode(200)
		.log().all();

	}
}
