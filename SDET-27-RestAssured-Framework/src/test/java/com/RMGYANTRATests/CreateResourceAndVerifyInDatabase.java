package com.RMGYANTRATests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import PojoLibrary.PojoClass;
import genericUtility.BaseApiClass;
import genericUtility.IEndPoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;


public class CreateResourceAndVerifyInDatabase extends BaseApiClass {

	@Test
	public void createResourceAndVerifyInDatabase() throws Throwable {
		
//Step:1 create testData
		PojoClass pLib=new PojoClass("Dinesh", "DHRUV"+jLib.getRandomNum(), "OnGoing", 10);
		
//Step:2 execute post request
		Response resp = given()
		    .body(pLib)
		    .contentType(ContentType.JSON)
		  .when()
		      .post(IEndPoints.createProject);
//Step :3 capture the project id from response
		String expData=rLib.getJSONData(resp, "projectId");
		System.out.println(expData);
		
		
//Step:4 Verify in DB
		String query="select* from project;";
		String actData=dLib.executeQueryAndGetData(query, 1, expData);
		Reporter.log(actData+"data in response body",true);
		
//Step:5 Validate
		Assert.assertEquals(expData, actData);
		Reporter.log("data verification successful", true);
		  
	}
}
