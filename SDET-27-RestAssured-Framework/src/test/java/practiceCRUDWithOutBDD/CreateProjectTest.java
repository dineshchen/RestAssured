package practiceCRUDWithOutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProjectTest {
	
@Test
	public void createProject()
	{
//Step 1 Create test Data
	JSONObject jobj=new JSONObject();
	jobj.put("createdBy", "Google");
	jobj.put("projectName", "Android");
	jobj.put("status", "Created");
	jobj.put("teamSize", 1008);
	
//Step 2 provide request specification
	RequestSpecification req = RestAssured.given();
	req.contentType(ContentType.JSON);
	req.body(jobj);
	
//Step 3 perform the action
	Response res = req.post("http://localhost:8084/addProject");
	
//Step 4 print in console and verify
	System.out.println(res.asString()); //Prints entire msg in one line as string
	System.out.println(res.prettyPrint()); // prints output in the form of JSON
	System.out.println(res.prettyPeek()); // Indetailed print with date,connection
	System.out.println(res.getContentType()); // prints type of content (app/json)
	System.out.println(res.statusCode());
		
	}
}
