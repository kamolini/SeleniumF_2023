package test.api;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import java.util.UUID;

public class KamoliniApiTest {
	
	
	int id = 0;
	
	String uuid = UUID.randomUUID().toString();
	
	String email = uuid+"@gmail.com";
	String fName = "Test Automation";
	String mName = "Rest";
	String lName = "RestAssured";
	String phone = "5254845241";
	
	@Test(dependsOnMethods = "CreateCustomer")
	public void GetCustomer() {
		
	Response response =  given().baseUri("https://api.kamolini.com/api/v1/customer/"+id).get();
		
	System.out.println(response.getBody().asString());
		
	Assert.assertEquals(response.jsonPath().getInt("id"), id);
	Assert.assertEquals(response.jsonPath().get("email"), email);
	Assert.assertEquals(response.jsonPath().get("firstName"), fName);
	Assert.assertEquals(response.jsonPath().get("lastName"), lName);
	Assert.assertEquals(response.jsonPath().get("middleName"), mName);
	Assert.assertEquals(response.jsonPath().getLong("phone")+"", phone);
		
	}
	
	
	@Test
	public void CreateCustomer() {
		
		String body = "{\r\n"
				+ "  \"email\": \""+email+"\",\r\n"
				+ "  \"firstName\": \""+fName+"\",\r\n"
				+ "  \"lastName\": \""+lName+"\",\r\n"
				+ "  \"middleName\": \""+mName+"\",\r\n"
				+ "  \"phone\": "+phone+"\r\n"
				+ "}";
		
	Response response =  given().
			header("accept","application/json").
			header("Content-Type","application/json").
			baseUri("https://api.kamolini.com/api/v1/customer/createCustomer").
			body(body).
			post();
		
	id = response.jsonPath().getInt("id");

	Assert.assertEquals(response.jsonPath().get("email"), email);
	Assert.assertEquals(response.jsonPath().get("firstName"), fName);
	Assert.assertEquals(response.jsonPath().get("lastName"), lName);
	Assert.assertEquals(response.jsonPath().get("middleName"), mName);
	Assert.assertEquals(response.jsonPath().getLong("phone")+"", phone);
	Assert.assertNotNull(id);
			
	}

}
