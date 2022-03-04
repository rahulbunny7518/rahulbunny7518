package TestAutomation.DatabaseTesting;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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



public class DatabaseTest {
	
	Connection conn;
	Statement stmt;
	ResultSet resultSet;
	
	@BeforeClass
	public void setup() throws SQLException
	{
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/world","root","password");
	}
	
	@Test
	public void testStoredProcedureExistence() throws SQLException
	{
		
		stmt=conn.createStatement();
		resultSet=stmt.executeQuery("show procedure status where name='cityCountsByCountry'");
		
		resultSet.next();
		String procedureName=resultSet.getString("Name");
		
		assertEquals(procedureName, "cityCountsByCountry");
	}
	
	@Test
	public void testSPCityDetails() throws SQLException 
	{
		CallableStatement cStmt=conn.prepareCall("{CALL world.citydetails}");
		resultSet=cStmt.executeQuery();
		
		stmt=conn.createStatement();
		ResultSet actualData=stmt.executeQuery("select * from city");
		
		assertTrue(compareResultSet(resultSet,actualData));

	}
	
	
	
	
	@Test
	public void testSPCityByCountry() throws SQLException
	{
		CallableStatement cStmt=conn.prepareCall("{CALL cityByCountry(?)}");
		cStmt.setString(1, "AFG");
		resultSet=cStmt.executeQuery();
	
		
		stmt=conn.createStatement();
		ResultSet actualData=stmt.executeQuery("Select * from city where countrycode='AFG'");
		
		assertTrue(compareResultSet(resultSet,actualData));
	}
	
	
	@Test
	public void testSPCityCountsByCountry() throws SQLException
	{
		//Get Data from Stored procedure
		CallableStatement cStmt=conn.prepareCall("{CALL cityCountsByCountry(?,?,?)}");
		cStmt.setString(1, "AFG");
		
		cStmt.registerOutParameter(2, Types.INTEGER);
		cStmt.registerOutParameter(3, Types.INTEGER);
		
		cStmt.executeQuery();
		
		int cityCount=cStmt.getInt(2);
		int countryCount=cStmt.getInt(3);
		
		//Get Data from SQL Query
		stmt=conn.createStatement();
		ResultSet actualData=stmt.executeQuery("Select count(*) from city where countryCode='AFG'");
		actualData.next();
		int expectedCityCount=actualData.getInt(1);
		
		//Get Data from SQL Query
		stmt=conn.createStatement();
		actualData=stmt.executeQuery("Select count(*) from country" );
		actualData.next();
		int expectedCountryCount=actualData.getInt(1);
		
		assertEquals(cityCount, expectedCityCount);
		assertEquals(countryCount, expectedCountryCount);



	}
	
	@Test
	public void testTrigger() throws SQLException
	{
		stmt=conn.createStatement();
		String id="23";
		String query="insert into employee values("+id+",'Pushpa',24,1,'Hyd')";
		stmt.execute(query);
		
		String query1="select * from employee where id="+id;
		ResultSet result=stmt.executeQuery(query1);
		
		String city="";
		while(result.next())
		{
			city=result.getString("city");
		}
		
		assertEquals(city, "BEN");
	}
	
	
	private boolean compareResultSet(ResultSet rs1, ResultSet rs2) throws SQLException {
		try {
			while (rs1.next()) {
				rs2.next();
				int count = rs1.getMetaData().getColumnCount();
				for (int i = 1; i <= count; i++) {
					if (!rs1.getString(i).equals(rs2.getString(i))) {
						return false;
					}
				}
			}
		} catch (Exception ex) {
			return false;
		}

		return true;

	}
	
	@AfterClass
	public void tearDown() throws SQLException
	{
		conn.close();
	}

}
