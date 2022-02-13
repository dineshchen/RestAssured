package practiceCRUDWithOutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UpdateProjectTest {
@Test
	public void updateProject() {
	
//Step 1 Create test data
	
	JSONObject jobj=new JSONObject();
	jobj.put("createdBy", "Dinesh");
	jobj.put("projectName", "APTY");
	jobj.put("status", "Completed");
	jobj.put("teamSize", 10);
	
//Step 2 
	RequestSpecification req = RestAssured.given();
	req.contentType(ContentType.JSON);
	req.body(jobj);
	
//Step 3 
	Response res = req.put("http://localhost:8084/projects/TY_PROJ_1602");
	
//Step 4
	ValidatableResponse valid = res.then();
	valid.assertThat().statusCode(200);
	valid.log().all();
	}
}
