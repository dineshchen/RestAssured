package assignment;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class GetAlltheProjectsIDAndValidateWRTDataBase {
@Test
public void getAlltheProjectsIDAndValidateWRTDataBase() {
	
	given()
	   .contentType(ContentType.JSON);
	Response resp=when()
	  .get("http://localhost:8084/projects");
	List<Object> projID = resp.jsonPath().getList("projectId");
	System.out.println(projID);
	  
       
	    
	
}

}
