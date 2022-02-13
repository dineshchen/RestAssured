package practiceCRUDWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class GetAllProjectsTest {

	@Test
	public void getProjects() {
		
		when()
		  .get("http://localhost:8084/projects")
		.then()
		  .assertThat().contentType(ContentType.JSON)
		  .statusCode(200)
		  .log().all();
			}
}
