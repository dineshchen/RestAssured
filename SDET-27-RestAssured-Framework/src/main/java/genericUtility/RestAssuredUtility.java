package genericUtility;

import io.restassured.response.Response;

/**
 * This class contains specific generic methods for rest assured 
 * @author Dinesh
 *
 */
public class RestAssuredUtility {
/**
 *  This method will return the json data for the json path specified
 *  @param resp
 *  @param jsonPath
 *  @return
 */
	public String getJSONData(Response resp,String jsonPath) {
		String jsonData = resp.jsonPath().get(jsonPath);
		return jsonData;
		
	}
}
