package TestAutomation.RestAsuured;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;


public class TestWithObject {
	@Test
	public void testPost() {
		UserDetails ob = new UserDetails();
		ob.setUserId(100);
		ob.setId(12);
		ob.setTitle("RestAssured");

		
		Response res = given()
				.log()
				.all()
				.header("Content-Type", "application/json")
				.body(ob)
				.when()
				.post("https://jsonplaceholder.typicode.com/albums")
				.then()
				.assertThat()
				.statusCode(201).extract().response();
		String response = res.asString();
		System.out.println(response);
	}

	@Test
	public void testGet() {
		UserDetails object = given()
				.log().all()
				.when()
				.get("https://jsonplaceholder.typicode.com/albums/1")
				.as(UserDetails.class);

		System.out.println(object.toString());

	}
}
