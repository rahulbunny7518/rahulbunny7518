package TestAutomation.RestAsuured;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;

public class TestedClass {

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

}
