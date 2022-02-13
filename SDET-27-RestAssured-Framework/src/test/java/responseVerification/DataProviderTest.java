package responseVerification;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PojoLibrary.PojoClass;
import groovy.transform.ASTTest;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class DataProviderTest {

	@Test(dataProvider="getData")
	public void create(String createdBy,String projectName,String status,int teamSize) {
		PojoClass pojo=new PojoClass(createdBy,projectName,status,teamSize);
		given()
		    .body(pojo)
		    .contentType(ContentType.JSON)
		.when()
		    .post("http://localhost:8084/addProject")
		.then()
		    .assertThat().contentType(ContentType.JSON)
		    .statusCode(201)
		    .log().all();
	    
	}
	@DataProvider
	public Object[][] getData(){
		
		Object[][] objArray = new Object[2][4];
		
		objArray[0][0]="Ganesh";
		objArray[0][1]="lord project";
		objArray[0][2]="Completed";
		objArray[0][3]=123;
		
		objArray[1][0]="Dhruv";
		objArray[1][1]="Sun project";
		objArray[1][2]="Completed";
		objArray[1][3]=321;
		
		return objArray;
		
	}
	
}
