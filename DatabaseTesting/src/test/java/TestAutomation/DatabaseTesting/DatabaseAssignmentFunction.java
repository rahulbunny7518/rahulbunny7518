package TestAutomation.DatabaseTesting;

import static org.testng.Assert.assertEquals;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DatabaseAssignmentFunction {
	
	Connection conn;
	Statement stmt;
	ResultSet resultSet;
	
	@BeforeClass
	public void setup() throws SQLException

	{
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/world","root","password");
	}
	
	@Test
	public void testCityNameStartsWithI() throws SQLException
	{
		CallableStatement cStmt=conn.prepareCall("{?=CALL cityNameStartsWithI()}");
		
		cStmt.registerOutParameter(1, Types.INTEGER);
		cStmt.execute();
		
		int noOfCities=cStmt.getInt(1);
		
		// Get Data from SQL Query
		stmt = conn.createStatement();
		ResultSet actualData = stmt.executeQuery("select count(Name) from city where Name like 'I%'");
		actualData.next();
		int expectedCityCount = actualData.getInt(1);
		System.out.println(noOfCities+" "+expectedCityCount);
		assertEquals(expectedCityCount, noOfCities);
		
	}
	
	@AfterClass
	public void tearDown() throws SQLException
	{
		conn.close();
	}

}
