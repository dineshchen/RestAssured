package practiceCRUDWithOutBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllProjectsTest {
@Test
public void getAllProjects() {
	
//step 1
	int expStatus=200;
	Response res = RestAssured.get("http://localhost:8084/projects");
	
//step
	System.out.println(res.prettyPeek());
	int actStatus=res.getStatusCode();
	Assert.assertEquals(expStatus, actStatus);
}
}
