package genericUtility;

import static io.restassured.RestAssured.*;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseApiClass {

	public DatabaseUtility dLib=new DatabaseUtility();
	public JavaUtility jLib=new JavaUtility();
	public RestAssuredUtility rLib=new RestAssuredUtility();
	
	@BeforeSuite
	public void bsconfig() throws Throwable {
		baseURI="http://localhost";
		port=8084;
		
		dLib.connectToDB();
		System.out.println("==============database connection established========");
	}
	@AfterSuite
	public void asConfig() throws Throwable {
		dLib.closeDB();
		System.out.println("==========database connection closed========");
	}
	
}
