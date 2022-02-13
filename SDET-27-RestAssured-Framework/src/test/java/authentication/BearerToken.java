package authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BearerToken {
@Test
	public void bearerToken() {
	given()
	   .auth().oauth2("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")
    .when()
        .get("https://api.github.com/user/repos")
    .then()
        .assertThat().statusCode(200)
        .log().all();
	}
}
