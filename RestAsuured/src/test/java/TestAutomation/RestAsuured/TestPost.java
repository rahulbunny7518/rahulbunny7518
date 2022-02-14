package TestAutomation.RestAsuured;

import static io.restassured.RestAssured.given;
//import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;


public class TestPost {
	
	@BeforeClass
	public static void setup() {
		RestAssured.baseURI="https://jsonplaceholder.typicode.com";
	}
	
	@Test
	public static void testPostObjectGETResponse()
	{
		given()
		.when()
		.get("https://jsonplaceholder.typicode.com/posts")
		.then()//verification
		.statusCode(200);
		
	}
	
	@Test
	public static void testPostObjectGETWithID()
	{
		given().pathParam("id", 1)
		.when()
		.get("https://jsonplaceholder.typicode.com/posts/{id}")
		.then()
		.statusCode(200)
		.body("userId", equalTo(1))
		.body("title", equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"));
		
		
	}
	
	@Test
	public static void testPostObjectGETWithIDQueryParam()
	{
		given().queryParam("userId", 1)
		.when()
		.get("https://jsonplaceholder.typicode.com/posts")
		.then()
		.statusCode(200)
		.body("[0].userId", equalTo(1))
		.body("[0].title", equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"));
		
		
	}
	
	@Test(dataProvider="userIDDataProvider")
	public static void testPostObjectGETResponseWithParamSearch(int userID,int id)
	{
		List<Object> posts=given()
				.queryParam("userId", userID)
		.when()
		.get("https://jsonplaceholder.typicode.com/posts") //for each userID it will execute again
		.then()
		.statusCode(200)
		.body("[0].userId", equalTo(userID))
		.body("[0].id", equalTo(id))
		.extract().jsonPath().getList("$");
		
		assertEquals(posts.size(),10);
				
	}
	
	@DataProvider(name="userIDDataProvider")
	public Object[][] getUserIDDataProvider()
	{
		return new Object[][] {{1,1},{2,11}};
	}
	
	
	@Test
	public static void testPostObjectPOSTResponse()
	{
		String postRequestBody="{\r\n"
				+ "    \"userId\":7,\r\n"
				+ "    \"title\":\"Sample request for REST ASSURED\",\r\n"
				+ "    \"body\":\"Sample request REST ASSURED DATA\"\r\n"
				+ "}";
		
		given()
		.header("Content-Type","application/json")
		.body(postRequestBody)
		.when()
		.post("/posts") //we have decalred url in setup
		.then()
		.statusCode(201);
	}
	
	@Test
	public static void testPostObjectPUTResponse()
	{
		String putRequestBody="{\r\n"
				+ "    \"userId\":5,\r\n"
				+ "    \"title\":\"Sample request for REST ASSURED\",\r\n"
				+ "    \"body\":\"Sample request REST ASSURED using PUT\"\r\n"
				+ "}";
		
		given()
		.header("Content-Type","application/json")
		.body(putRequestBody)
		.when()
		.put("/posts/5")
		.then()
		.statusCode(200)
		.body("id", equalTo(5))
		.body("body", equalTo("Sample request REST ASSURED using PUT"));
		
	}
	
	
	
	@Test
	public static void testPostObjectPATCHResponse()
	{
		String patchRequestBody="{\r\n"
				+ "    \"title\":\"PAtch request -Sample request for REST ASSURED\"\r\n"
				+ "}";
		
		given()
		.header("Content-Type","application/json")
		.body(patchRequestBody)
		.when()
		.patch("/posts/5")
		.then()
		.statusCode(200)
		.body("id", equalTo(5))
		.body("title",equalTo( "PAtch request -Sample request for REST ASSURED"));
		
	}
	
	
	
	

}
