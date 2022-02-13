package responseVerification;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSender;

import static io.restassured.RestAssured.*;

public class StaticResponseValidationTest {
@Test
	public void verify() {
		String expectedProjectName="APR-06";
		
		  Response response = when()
				.get("http://localhost:8084/projects");
				String actualProjectName = response.jsonPath().get("[0].projectName");
				response.then()
				    .assertThat()
				    .contentType(ContentType.JSON).and().statusCode(200)
				    .log().all();
		Assert.assertEquals(expectedProjectName, actualProjectName);
		
	}
}
