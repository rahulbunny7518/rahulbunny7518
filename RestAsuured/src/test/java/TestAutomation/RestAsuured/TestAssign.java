package TestAutomation.RestAsuured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class TestAssign {
	
	public static String token;
	
	@BeforeClass
	public static void setup() {
		String postRequestBody="{\r\n"
				+ "    \"email\":\"user11@gmail.com\",\r\n"
				+ "    \"password\":12345678\r\n"
				+ "}";
		
		token=given()
		.header("Content-Type","application/json")
		.and()
		.body(postRequestBody)
		.when()
		.post("http://restapi.adequateshop.com/api/authaccount/login") 
		.then()
		.statusCode(200)
		.extract().jsonPath().getString("data.Token");
		
		System.out.println(token);
		
	}
	

	
	@Test
	public static void testAuthenticateUsers()
	{
		given()
		.header("Authorization","Bearer "+token)
		.when()
		.get("http://restapi.adequateshop.com/api/users?page=1")
		.then()
		.statusCode(200)
		.body("page", equalTo(1));

	}
	
	
	//this will fail if status code is 200 because we are passing wrong token number
	@Test
	public static void testUnAuthenticateUsers()
	{
		given()
		.header("Authorization","Bearer jfddhldxdkdkdkdk") //passing wrong token
		.when()
		.get("http://restapi.adequateshop.com/api/users?page=1")
		.then()
		.statusCode(401);

	}
	
	@Test
	public static void testUnAuthenticateUsersWithoutToken()
	{
		given()
		.when()
		.get("http://restapi.adequateshop.com/api/users?page=1")
		.then()
		.statusCode(401);

	}
	
	
	
	

	

	
	
	
	
}
