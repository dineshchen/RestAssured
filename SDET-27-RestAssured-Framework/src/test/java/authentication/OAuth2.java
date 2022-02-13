package authentication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class OAuth2 {
@Test

public void oAuth2() {
	 Response response = given()
	    .formParams("client_id", "First_App")
	    .formParams("client_secret","87039ca15765fd78de1e629d8849004b")
	    .formParams("grant_type","client_credentials")
	    .formParams("redirect_uri","https://example.com")
	  .when()
	     .post("http://coop.apps.symfonycasts.com/token");
	  String token = response.jsonPath().get("access_token");
	  
	  given()
	     .auth().oauth2(token)
	     .pathParam("USER_ID", "2803")
	  .when()
	      .post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-count")
	   .then()
	      .log().all();
}
}
