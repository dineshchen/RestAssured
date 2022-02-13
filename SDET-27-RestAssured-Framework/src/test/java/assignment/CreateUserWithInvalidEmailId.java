package assignment;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class CreateUserWithInvalidEmailId {
@Test
	public void createUserTest() {
		JSONObject obj=new JSONObject();
		
		obj.put("designation","SDET");
		obj.put("dob", "13/12/2021");
		obj.put("email", "dinesh");
		obj.put("empName", "Dinesh");
		obj.put("experience", 15);
		obj.put("mobileNo", "0236561276578126578115859872346");
		obj.put("project", "hdfc");
		obj.put("role", "ROLE_ADMIN");
		obj.put("username", "Dinesh");
		
		given()
		   .body(obj)
		   .contentType(ContentType.JSON)
		 .when()
		    .post("http://localhost:8084/employees")
		  .then()
		     .assertThat().contentType(ContentType.JSON)
		     .statusCode(422)
		     .log().all();
		 
	}

}
