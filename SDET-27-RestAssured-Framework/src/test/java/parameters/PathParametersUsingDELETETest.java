package parameters;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PathParametersUsingDELETETest {
@Test
public void pathParametersUsingDELETETest() {
	given()
	   .pathParam("projectID", "TY_PROJ_005")
	.when()
	   .delete("http://localhost:8084/projects/{projectID}")
	.then()
	   .assertThat().contentType(ContentType.JSON)
	   .statusCode(204)
	   .log().all();
}
}
