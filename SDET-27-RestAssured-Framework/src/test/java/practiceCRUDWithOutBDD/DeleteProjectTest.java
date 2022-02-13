package practiceCRUDWithOutBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteProjectTest {
@Test
public void deleteProject() {
	
//step 1	
	int expStatus=204;
	Response res = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_228");
	
//step 2
	int actStatus=res.getStatusCode();
	Assert.assertEquals(expStatus, actStatus);
	System.out.println(res.prettyPrint());
}
}
