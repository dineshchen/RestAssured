package authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DigestiveAuthentication {
	@Test
	public void digestiveAuthentication() {
		given()
		    .auth().digest("rmgyantra", "rmgy@9999")
		.when()
		    .get("http://localhost:8084/login")
		.then()
		    .assertThat().statusCode(202)
		    .log().all();
	}

}
