package parameters;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class QueryAndPathParameterTest {

	@Test
	public void queryAndPathParameterTest() {
		given()
		   .pathParam("username", "dineshchen")
		   .queryParam("sort", "created")
		   .queryParam("per_page", "10")
		.when()
		   .get("http://api.github.com/users/{username}/repos")
		 .then()
		   .assertThat().statusCode(200)
		   .log().all();
	}
}
