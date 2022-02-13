package responseVerification;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class DynamicResponseValidationTest {
@Test
public void verify() {
	String expectedProjectName="APR-06";
			Response response = when()
			   .get("http://localhost:8084/projects");
			 List<String> proNames = response.jsonPath().get("projectName");
	boolean flag=false;
	for(String pNames:proNames) {
		try {
			if(pNames.equals(expectedProjectName)) {
				flag=true;
			}
		}catch(Exception e) {
			
		}
	}
	response.then()
	        .assertThat()
	        .contentType(ContentType.JSON).and().statusCode(200)
	        .log().all();
	Assert.assertEquals(flag, true);
}
}
