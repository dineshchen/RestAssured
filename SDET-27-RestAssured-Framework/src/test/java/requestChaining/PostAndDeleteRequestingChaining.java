package requestChaining;

import static io.restassured.RestAssured.*;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostAndDeleteRequestingChaining {
@Test
	public void postAndDeleteRequestingChaining() {
		JSONObject obj=new JSONObject();
		
		Random ran=new Random();
		int randomNum = ran.nextInt(500);
		
		obj.put("createdBy", "Vinayaga");
		obj.put("projectName", "MuruganBro"+randomNum);
		obj.put("status", "created");
		obj.put("teamSize", 100);
		
		Response resp = given()
		  .body(obj)
		  .contentType(ContentType.JSON)
		.when()
		  .post("http://localhost:8084/addProject");
		 
		
		String projID = resp.jsonPath().get("projectId"); 
		 System.out.println(projID);
		 
		 given()
		   .pathParam("projectId", projID)
		 .when()
		   .delete("http://localhost:8084/projects/{projectId}")
		 .then()
		     .assertThat().statusCode(204)
		     .contentType(ContentType.JSON)
		     .log().all();
		 
		 
		
	}
}
