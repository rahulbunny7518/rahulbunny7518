package TestAutomation.RestAsuured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class TestPractice {
	
	@BeforeClass
	public void setup() {
		RestAssured.baseURI="https://jsonplaceholder.typicode.com";
	}
	
	
	@Test
	public static void testPostObjectGETWithIDQueryParam()
	{
		given().queryParam("userId", 2)
		.when()
		.get("https://jsonplaceholder.typicode.com/posts?userId=2")// ?userId=2 is optional as we used queryParam()
		.then()
		.statusCode(200)
		.body("[0].userId", equalTo(2));
		
		//.body("[0].title", equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"));
		
		
	}

}
