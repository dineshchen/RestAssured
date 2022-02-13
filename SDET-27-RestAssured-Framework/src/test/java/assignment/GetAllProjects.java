package assignment;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import PojoLibrary.PojoClass;
import io.restassured.http.ContentType;

public class GetAllProjects {
@Test
	public void getAllProjects() {
		PojoClass pojo=new PojoClass("Dhruv", "MyProject", "Created", 2022);
		given()
		   .body(pojo)
		.when()
		    .get("http://localhost:8084/projects")
		 .then()
		    .assertThat().time(Matchers.lessThanOrEqualTo(2000L), TimeUnit.MILLISECONDS)
		    .statusCode(200)
		    .contentType(ContentType.JSON)
		    .log().all();
	}
}
