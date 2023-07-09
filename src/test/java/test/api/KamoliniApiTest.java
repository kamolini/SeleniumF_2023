package test.api;


import org.testng.Assert; 
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import java.util.UUID;

public class KamoliniApiTest {
	
	String createCustomer = "{createCustomer}";
	String getCustomer = "{id}";
	String updateCustomer = "update/{id}";
	String getCustomerByEmail = "email/{email}";
	String isCustomerExist = "exist/{email}";
	String deleteCustomer = "{id}";
	
	int id = 0;
	
	String uuid = UUID.randomUUID().toString();
	
	String email = uuid+"@gmail.com";
	String fName = "Marc";
	String mName = "Rest";
	String lName = "Best";
	String phone = "1234567200";
	
	@BeforeClass
	public void start() {
		RestAssured.baseURI = "https://api.kamolini.com/api/v1/customer/";
	}
	
	@Test(dependsOnMethods = "CreateCustomer")
	public void GetCustomer() {
				
		Response response =  given().
				pathParam("id", id).
				get(getCustomer);

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
		
		String body = "{"
				+ "  \"email\": \""+email+"\","
				+ "  \"firstName\": \""+fName+"\","
				+ "  \"lastName\": \""+lName+"\","
				+ "  \"middleName\": \""+mName+"\","
				+ "  \"phone\": "+phone+""
				+ "}";
		
		Response response =  given().
				header("accept","application/json").
				header("Content-Type","application/json").
				pathParam("createCustomer", "createCustomer"). 
				body(body).
				post(createCustomer);
			
		id = response.jsonPath().getInt("id");
	
		Assert.assertEquals(response.jsonPath().get("email"), email);
		Assert.assertEquals(response.jsonPath().get("firstName"), fName);
		Assert.assertEquals(response.jsonPath().get("lastName"), lName);
		Assert.assertEquals(response.jsonPath().get("middleName"), mName);
		Assert.assertEquals(response.jsonPath().getLong("phone"), Long.parseLong(phone));
		Assert.assertNotNull(id);
			
	}

	
	@Test
	public void DeleteCustomer() {
		
		Response response =  given().baseUri("https://api.kamolini.com/api/v1/customer/"+206).delete();
		
	
	}

	
	@Test(dependsOnMethods = "GetCustomer")
	public void UpdateCustomer() {
		
		Response response =  given().
				pathParam("id", id).
				get(getCustomer);
			
		id = response.jsonPath().getInt("id");
		email = response.jsonPath().get("email");
		fName = UUID.randomUUID().toString().replace("-", "").substring(0,6);
		lName = response.jsonPath().get("lastName");
		mName = response.jsonPath().get("middleName");
		phone = response.jsonPath().getLong("phone")+"";
		
		
		System.out.println(fName);
		
		String body = "{"
				+ "  \"email\": \""+email+"\","
				+ "  \"firstName\": \""+fName+"\","
				+ "  \"lastName\": \""+lName+"\","
				+ "  \"middleName\": \""+mName+"\","
				+ "  \"phone\": "+phone+""
				+ "}";
		
		response =  given().
				header("accept","application/json").
				header("Content-Type","application/json").
				pathParam("id", id). 
				body(body).
				put(updateCustomer);
			
		Assert.assertEquals(response.body().asString(),"1");			
	}
	
	@Test(dependsOnMethods = "UpdateCustomer")
	public void GetCustomerAfterUpdate() {
				
		Response response =  given().
				pathParam("id", id).
				get(getCustomer);

		System.out.println(response.getBody().asString());
			
		Assert.assertEquals(response.jsonPath().getInt("id"), id);
		Assert.assertEquals(response.jsonPath().get("email"), email);
		Assert.assertEquals(response.jsonPath().get("firstName"), fName);
		Assert.assertEquals(response.jsonPath().get("lastName"), lName);
		Assert.assertEquals(response.jsonPath().get("middleName"), mName);
		Assert.assertEquals(response.jsonPath().getLong("phone")+"", phone);
	}

	
	@Test(dependsOnMethods = "GetCustomerAfterUpdate")
	public void GetCustomerByEmail() {
				
		Response response =  given().
				pathParam("email", email).
				get(getCustomerByEmail);

		System.out.println(response.getBody().asString());
			
		Assert.assertEquals(response.jsonPath().getInt("id"), id);
		Assert.assertEquals(response.jsonPath().get("email"), email);
		Assert.assertEquals(response.jsonPath().get("firstName"), fName);
		Assert.assertEquals(response.jsonPath().get("lastName"), lName);
		Assert.assertEquals(response.jsonPath().get("middleName"), mName);
		Assert.assertEquals(response.jsonPath().getLong("phone")+"", phone);
	}
	
	@Test(dependsOnMethods = "GetCustomerByEmail")
	public void validateIsCustomerExistbyEmail() {
				
		Response response =  given().
				pathParam("email", email).
				get(isCustomerExist);

		Assert.assertEquals(response.body().asString(), "true");		
	}
	
	@Test(dependsOnMethods = "validateIsCustomerExistbyEmail")
	public void DeleteCustomerByEmail() {
		Response response =  given().
				pathParam("id", id).
				delete(deleteCustomer);

		Assert.assertEquals(response.body().asString(), "1");		
	}
	

	@Test(dependsOnMethods = "DeleteCustomerByEmail")
	public void validateCustomerNotExistbyEmail() {
		Response response =  given().
				pathParam("email", email).
				get(isCustomerExist);

		Assert.assertEquals(response.body().asString(), "false");		
	}

}
