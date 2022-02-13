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

public class UpdateResourceAndVerifyInDB extends BaseApiClass {
@Test
	public void modifyResourceAndVerifyInDB() throws Throwable {
		
		PojoClass pojo=new PojoClass("Google", "Android", "completed", 20000);
		
		Response rep=given()
		    .body(pojo)
		    .contentType(ContentType.JSON)
		.when()
		    .put(IEndPoints.updateProject);
		   String expData=rLib.getJSONData(rep, "status");
		   Reporter.log(expData+"data in response", true);
		   
		   String query="select * from project";
		   String actData = dLib.executeQueryAndGetData(query, 5, expData);
		   Reporter.log(actData+"data in db",true);
		   
		   Assert.assertEquals(expData, actData);
		   Reporter.log("Verified Successfully",true);
		    
		    
	}
}
