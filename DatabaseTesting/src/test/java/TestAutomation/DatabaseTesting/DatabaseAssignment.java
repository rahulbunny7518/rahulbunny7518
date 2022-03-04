package TestAutomation.DatabaseTesting;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DatabaseAssignment {
	
	Connection conn;
	Statement stmt;
	ResultSet resultSet;
	
	@BeforeClass
	public void setup() throws SQLException

	{
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/world","root","password");
	}
	
	
	@Test
	public void checkAllTablesAvailability() throws SQLException
	{
		
		ArrayList<String> tableInDatabase=new ArrayList<String>();

		stmt=conn.createStatement();
		resultSet=stmt.executeQuery("show tables");
		
		while(resultSet.next())
		{
			String actualTableName=resultSet.getString(1);
			tableInDatabase.add(actualTableName);
		}
		
		String tableNames[]= {"city","citywithdetail","country","countrylanguage","employee"};
		
		int size=tableNames.length-1;
		while(size>=0)
		{
			assertTrue(tableInDatabase.contains(tableNames[size]));
			size--;	
		}

	}
	
	@Test
	public void testNoOfColumns() throws SQLException
	{
		stmt=conn.createStatement();
		resultSet=stmt.executeQuery("Select count(*) size from information_schema.columns where table_name='city'");
		resultSet.next();
		
		assertEquals(resultSet.getInt("size"),9);
		assertEquals(resultSet.getString("size"), "9");
	}
	
	@Test
	public void testAllColumnsInTableExists() throws SQLException
	{		
		ArrayList<String> columnsInDatabase=new ArrayList<String>();

		
		stmt=conn.createStatement();
		resultSet=stmt.executeQuery("Select column_name from information_schema.columns where table_name='city'");
		
		
		while(resultSet.next())
		{
			String actualColumnName=resultSet.getString(1);
			columnsInDatabase.add(actualColumnName);
			
		}
		
		String columnNames[]= {"ID","Name","CountryCode","District","Population"};

		int size=columnNames.length-1;
		while(size>=0)
		{
			assertTrue(columnsInDatabase.contains(columnNames[size]));
			size--;	
		}
	}
	
	@Test
	public void testColumnDatatypes() throws SQLException
	{
		ArrayList<String> columnDatatypesInDatabase=new ArrayList<String>();
		
		stmt=conn.createStatement();
		resultSet=stmt.executeQuery("Select column_name, data_type from information_schema.columns where table_name='city'");
		
		
		while(resultSet.next())
		{
			String actualColumnDatatype=resultSet.getString(2);
			columnDatatypesInDatabase.add(actualColumnDatatype);
			
		}
		String columnDatatypes[]= {"int","char","char","char","int"};
		
		int size=columnDatatypes.length-1;
		while(size>=0)
		{
			assertTrue(columnDatatypesInDatabase.contains(columnDatatypes[size]));
			size--;
		}

		
	}
	
	@Test
	public void testColumnSize() throws SQLException
	{
		ArrayList<String> columnSizeInDatabase=new ArrayList<String>();
		
		stmt=conn.createStatement();
		resultSet=stmt.executeQuery("Select column_name, column_type from information_schema.columns where table_name='city'");
	
		while(resultSet.next())
		{
			String actualColumnSize=resultSet.getString(2);
			columnSizeInDatabase.add(actualColumnSize);
			
		}
		
		String columnSizes[]= {"int","char(35)","char(3)","char(20)","int"};
		
		int size=columnSizes.length-1;
		while(size>=0)
		{
			assertTrue(columnSizeInDatabase.contains(columnSizes[size]));
			size--;
		}

	}
	
	@Test
	public void testColumnNullableValue() throws SQLException
	{
		ArrayList<String> columnNullableValuesInDatabase=new ArrayList<String>();
		
		stmt=conn.createStatement();
		resultSet=stmt.executeQuery("Select column_name, is_nullable from information_schema.columns where table_name='city'");
		
		while(resultSet.next())
		{
			String actualColumnNullableValue=resultSet.getString(2);
			columnNullableValuesInDatabase.add(actualColumnNullableValue);
			
		}
		
		String columnNullableStatus[]= {"NO","NO","NO","NO","NO"};
		int size=columnNullableStatus.length-1;
		while(size>=0)
		{
			columnNullableValuesInDatabase.contains(columnNullableStatus[size]);
			size--;
		}

	}
	
	@Test
	public void testColumnPrimarykeyAndOtherConstraints() throws SQLException
	{
		ArrayList<String> columnConstraintsInDatabase=new ArrayList<String>();
		stmt=conn.createStatement();
		resultSet=stmt.executeQuery("Select column_name, column_key from information_schema.columns where table_name='city'");
		
	
		while(resultSet.next())
		{
			String actualColumnConstraint=resultSet.getString(2);
			columnConstraintsInDatabase.add(actualColumnConstraint);
		
		}
		
		String columnConstraints[]= {"PRI","MUL"};
		int size=columnConstraints.length-1;
		
		while(size>=0)
		{
			columnConstraintsInDatabase.contains(columnConstraints[size]);
			size--;
		}


	}

}
