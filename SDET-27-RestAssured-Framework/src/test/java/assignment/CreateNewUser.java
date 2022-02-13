package assignment;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class CreateNewUser {

	@Test
	public void createNewUser() {
		
		Random ran=new Random();
		int randomNum = ran.nextInt(100);
		
		JSONObject obj=new JSONObject();
		
		obj.put("designation","SDET");
		obj.put("dob", "13/12/2021");
		obj.put("email", "suresh@gmail.com");
		obj.put("empName", "Suresh");
		obj.put("experience", 15);
		obj.put("mobileNo", "9132416837");
		obj.put("project", "hdfc"+randomNum);
		obj.put("role", "ROLE_ADMIN");
		obj.put("username", "Dinesh");
	/////////////////////////////////////////////////error////////////	
		Response resp = given()
		   .body(obj)
		   .contentType(ContentType.JSON)
		 .when()
		    .post("http://localhost:8084/employees");
		
		String name = resp.jsonPath().get("username");
				System.out.println(name);
		  given()
		     .pathParam("username", name)
		  .when()
		     .get("http://localhost:8084/employees")
		  .then()
		     .assertThat().contentType(ContentType.JSON)
		     .statusCode(201)
		     .log().all();
	}
	
}
