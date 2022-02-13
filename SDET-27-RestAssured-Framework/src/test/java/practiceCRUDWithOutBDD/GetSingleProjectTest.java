package practiceCRUDWithOutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetSingleProjectTest {
@Test

public void getSingleProject() {
	
//Step 1
	Response res = RestAssured.get("http://localhost:8084/projects/TY_PROJ_1602");
	
//Step 2
	System.out.println(res.prettyPeek());

}
}
