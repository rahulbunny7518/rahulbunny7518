package TestAutomation.RestApiTestingProject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class TestOrangeHRMAPiTests {
	
	String token;
	String cookie;
	String sheetId;
	
	String totalHoursBeforePunchInOut;
	String totalHoursAfterPunchInOut;

	
	
	@BeforeTest
	public void setup(ITestContext context) {
		RestAssured.baseURI = "https://prasoonr-trials73.orangehrmlive.com/";
		token = context.getCurrentXmlTest().getParameter("Token");
		cookie = context.getCurrentXmlTest().getParameter("Cookie");

	}
	
	@Test(priority=1)
	public void testAttendanceSheet()
	{
		sheetId= given()
				.header("Content-Type","application/x-www-form-urlencoded")
				.and()
				.header("Authorization","Bearer "+token)
				.and()
				.header("Cookie",cookie)
				.when()
				.get("api/attendanceSheet")
				.then()
				.statusCode(200)
				.extract().jsonPath().getString("data.latestSheetId");
		
		assertNotNull(sheetId);
		System.out.println(sheetId);
	}
	
	@Test(priority=2)
	public void testAttendanceSheetWithId()
	{
		String endPointUrl="api/attendanceSheet?id="+sheetId;
		Response response=given() 
				.header("Content-Type","application/x-www-form-urlencoded")
				.header("Authorization","Bearer "+token)
				.header("Cookie",cookie)
				.when()
				.get(endPointUrl)
				//.prettyPrint();
				.then()
				.statusCode(200)
				.extract().response();
		
		String responseWithId=response.asString();
		System.out.println(responseWithId);
	}
	
	
	@Test(priority=3)
	public void testTotalhoursBefore()
	{
		String data="id=653";
		String endPointUrl="api/attendanceSheet"; //?id="+sheetId;
		
		totalHoursBeforePunchInOut=given() 
				.header("Content-Type","application/x-www-form-urlencoded")
				.header("Authorization","Bearer "+token)
				.header("Cookie",cookie)
				.body(data)
				.when()
				.get(endPointUrl)
				.then()
				.statusCode(200)
				.extract().jsonPath().getString("meta.totals.T.duration");
		System.out.println(totalHoursBeforePunchInOut);
	}
	
	String punchinId;
	
	@Test(priority=4)
	public void testValidPunchIn()
	{
		PunchInOut punchin=new PunchInOut();
		punchin.setEmpNumber(13);
		punchin.setDate("2022-03-10");
		punchin.setTime("12:01");
		punchin.setTimezoneOffset("5.5");
		punchin.setForcePunchIn(false);
		
		
		punchinId=given()
				.header("Content-type","application/json")
				.header("Authorization","Bearer "+token)
				.header("Cookie",cookie)
				.body(punchin)
				.when()
				.post("api/attendanceRecords")
				.then()
				.statusCode(201)
				.extract().jsonPath().getString("data.id");
		
		System.out.println(punchinId);
	}
	
	@Test(priority=5)
	public void testInvalidPunchIn()
	{
		PunchInOut punchin=new PunchInOut();
		punchin.setEmpNumber(13);
		punchin.setDate("2022-03-10");
		punchin.setTime("12:11");
		punchin.setTimezoneOffset("5.5");
		punchin.setForcePunchIn(false);
		
		
		Response res=given()
				.header("Content-type","application/json")
				.header("Authorization","Bearer "+token)
				.header("Cookie",cookie)
				.body(punchin)
				.when()
				.post("api/attendanceRecords")
				.then()
				.statusCode(403)
				.extract().response();
		String response=res.asString();
		System.out.println(response);
	}
	
	@Test(priority=6)
	public void testValidPunchOut()
	{
		String punchout="{\r\n"
				+ "  \"empNumber\": \"13\",\r\n"
				+ "  \"date\": \"2022-03-10\",\r\n"
				+ "  \"time\": \"14:01\",\r\n"
				+ "  \"timezoneOffset\": \"5.5\"\r\n"
				+ "}";
		
		Boolean message=given().pathParam("punchinId", punchinId)
		.header("Authorization","Bearer "+token)
		.and()
		.header("Content-Type","application/json")
		.and()
		.header("Cookie",cookie)
		.and()
		.body(punchout)
		.when()
		.patch("api/attendanceRecord/{punchinId}")
		.then()
		.statusCode(200)
		.extract().jsonPath().getBoolean("success");
		
		assertTrue(message);
		
	}
	
	
	@Test(priority=7)
	public void testTotalhoursAfter()
	{
		//String data="id=653";
		String endPointUrl="api/attendanceSheet?id="+sheetId;
		
		totalHoursAfterPunchInOut=given() 
				.header("Content-Type","application/x-www-form-urlencoded")
				.header("Authorization","Bearer "+token)
				.header("Cookie",cookie)
				//.body(data)
				.when()
				.get(endPointUrl)
				.then()
				.statusCode(200)
				.extract().jsonPath().getString("meta.totals.T.duration");
		System.out.println(totalHoursAfterPunchInOut);
	}
	
	@Test(priority=8)
	public void testInvalidPunchOut()
	{
		String punchout="{\r\n"
				+ "  \"empNumber\": \"13\",\r\n"
				+ "  \"date\": \"2022-03-10\",\r\n"
				+ "  \"time\": \"14:11\",\r\n"
				+ "  \"timezoneOffset\": \"5.5\"\r\n"
				+ "}";
		
		//Boolean message=
		given().pathParam("punchinId", punchinId)
		.header("Authorization","Bearer "+token)
		.and()
		.header("Content-Type","application/json")
		.and()
		.header("Cookie",cookie)
		.and()
		.body(punchout)
		.when()
		.patch("api/attendanceRecord/{punchinId}")
		.then()
		.statusCode(403);
		//.extract().jsonPath().getBoolean("success");
		
		//assertFalse(message);
	}
	
	@Test(priority=9,enabled=true)
	public void testOverlappingPunchIn()
	{
		PunchInOut punchin=new PunchInOut();
		punchin.setEmpNumber(13);
		punchin.setDate("2022-01-04");
		punchin.setTime("12:11");
		punchin.setTimezoneOffset("5.5");
		punchin.setForcePunchIn(false);
		
		
		String message=given()
				.header("Authorization","Bearer "+token)
				.and()
				.header("Content-Type","application/json")
				.and()
				.header("Cookie",cookie)
				.and()
				.body(punchin)
				.when()
				.post("api/attendanceRecords")
				.then()
				.statusCode(201)
				.extract().jsonPath().getString("messages.error");
		
		assertEquals(message, "Overlapping Records Found");
		
		
	}
	
	
	
	
	@Test(priority=10)
	public void testDelete() {
		
		
		//String data="{\"ids\":["+punchinId+"]}";
		String data="{\"ids\": ["+punchinId+"]}";
		String res=given()
		.header("Authorization","Bearer "+token).and()
		.header("Cookie",cookie).and()
		.header("Content-type","application/json")
		.body(data)
		.when()
		.delete("/api/attendanceRecords")
		.then()
		.statusCode(200)
		.extract().jsonPath().getString("messages.success");
		System.out.println("message is "+res);
		assertEquals(res,"Successfully Deleted");
	}
	
	
	@Test(priority=11)
	public void testTotalhoursAfterDelete()
	{
		String data="id=653";
		String endPointUrl="api/attendanceSheet"; //?id="+sheetId;
		
		String totalHoursAfterDelete=given() 
				.header("Content-Type","application/x-www-form-urlencoded")
				.header("Authorization","Bearer "+token)
				.header("Cookie",cookie)
				.body(data)
				.when()
				.get(endPointUrl)
				.then()
				.statusCode(200)
				.extract().jsonPath().getString("meta.totals.T.duration");
		
		System.out.println(totalHoursAfterDelete);
		assertEquals(totalHoursAfterDelete, totalHoursBeforePunchInOut);
	}

}
