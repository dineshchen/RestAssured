package genericUtility;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

/**
 * Class with generic methods to connect to database
 * @author Dinesh
 *
 */
public class DatabaseUtility {

	Connection con=null;
	
	/**
	 * This method will establish the connection
	 */
	public void connectToDB()throws Throwable 
	{
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		con=DriverManager.getConnection(IConstants.dbURL, IConstants.dbUserName, IConstants.dbPassword);

	}
	
	public String executeQueryAndGetData(String query,int columnIndex,String expData) throws SQLException {
		boolean flag=false;
		ResultSet result = con.createStatement().executeQuery(expData);
		while(result.next())
		{
			String value=result.getString(columnIndex);
			if(value.equalsIgnoreCase(expData)) 
			{
				flag=true; //rising  flag
				break;
			}
		}
		if(flag) {
			System.out.println(expData+" Data Verified");
			return expData;
		}
		else {
			System.out.println("Data is not present");
			return "";
		}
		
	}
	/**
	 * This method will close the database connection
	 * @throws Throwable
	 */
			
	public void closeDB() throws Throwable {
		con.close();
	}
}
