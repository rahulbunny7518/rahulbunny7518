package TestAutomation.RestApiTestingProject;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.net.MalformedURLException;
import java.util.LinkedHashMap;

import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class TestOrangeHRM {
	
	String token;
	String cookie;
	String sheetId;
	
	@BeforeTest
	public void setup(ITestContext context) {
		RestAssured.baseURI = "https://prasoonr-trials73.orangehrmlive.com/";
		token = context.getCurrentXmlTest().getParameter("Token");
		cookie = context.getCurrentXmlTest().getParameter("Cookie");

	}
	
	@Test(priority=1)
	public void testAttendanceSheet()
	{
		
		sheetId=given()
				.header("Authorization", "Bearer " + token)
				.and()
				.header("Content-Type", "application/x-www-form-urlencoded")
				.and()
				.header("Cookie", cookie)
				.when()
				.get("api/attendanceSheet")
				//.prettyPrint();
				.then()
				.statusCode(200)
				.extract().jsonPath().getString("data.latestSheetId");
		assertNotNull(sheetId);
		System.out.println(sheetId);
	}
	@Test(priority=2)
	public void testAttendanceSheetWithIdResponse()
	{
		Response res=given()
				.header("Authorization", "Bearer " + token)
				.and()
				.header("Content-Type", "application/x-www-form-urlencoded")
				.and()
				.header("Cookie", cookie)
				.when()
				.get("api/attendanceSheet?id=653")
				.then()
				.statusCode(200)
				//.body("data[0].total", equalTo(14460))
				.extract().response();
		String response=res.asString();
		System.out.println(response);
		
	}
	
	
	@Test(priority=3)
	public void testPunchInOutConfig()
	{
		given()
		.header("Authorization", "Bearer " + token)
		.and()
		.header("Content-Type", "application/x-www-form-urlencoded")
		.and()
		.header("Cookie", cookie)
		.when()
		.get("/api/attendance/config")
		.then()
		.statusCode(200);
		
	}
	
	
	
	String punchinId;
	
	@Test(priority=4)
	public void testPunchIn()
	{
		PunchInOut punchin=new PunchInOut();
		punchin.setEmpNumber(13);
		punchin.setDate("2022-01-05");
		punchin.setTime("10:01");
		punchin.setTimezoneOffset("5.5");
		punchin.setForcePunchIn(false);
		
		
		/*String postRequest="{\r\n"
				+ "  \"empNumber\": \"13\",\r\n"
				+ "  \"date\": \"2022-01-05\",\r\n"
				+ "  \"time\": \"10:01\",\r\n"
				+ "  \"timezoneOffset\": \"5.5\",\r\n"
				+ "  \"forcePunchIn\": false\r\n"
				+ "}";*/
		
		LinkedHashMap status=given()
		.header("Authorization", "Bearer " + token)
		.and()
		.header("Content-Type", "application/json")
		.and()
		.header("Cookie", cookie)
		.and()
		.body(punchin)
		.when()
		.post("api/attendanceRecords")
		//.prettyPrint()
		.then()
		.statusCode(201)
		.extract().jsonPath().get("data");
		
		punchinId=(String)status.get("id");
		System.out.println(punchinId);
		
	}
	
	
	
	@Test(priority=5)
	public void testPunchOut()
	{
		//PunchInOut punchout=new PunchInOut();
		/*punchout.setEmpNumber(13);
		punchout.setDate("2022-01-05");
		punchout.setTime("16:00");
		punchout.setTimezoneOffset("5.5");
		punchout.setForcePunchIn(false);*/

		
		
		String punchout="{\r\n"
				+ "  \"empNumber\": \"13\",\r\n"
				+ "  \"date\": \"2022-01-05\",\r\n"
				+ "  \"time\": \"16:00\",\r\n"
				+ "  \"timezoneOffset\": \"5.5\"\r\n"
				+ "}";
		
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
		.statusCode(200);
		
	}
	
	@Test(priority=6)
	public void testDelete() {
		
		String data="{\"ids\":["+punchinId+"]}";
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
	
	
}
