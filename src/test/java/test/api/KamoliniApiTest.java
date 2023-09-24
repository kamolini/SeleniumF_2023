package test.api;


import org.testng.Assert; 
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.gson.Gson;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.Customer;
import model.Person;
import model.PersonName;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class KamoliniApiTest {
	
	Customer customer = null;
	
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
		Assert.assertEquals(response.jsonPath().get("firstName"), customer.getFirstName());
		Assert.assertEquals(response.jsonPath().get("lastName"), customer.getLastName());
		Assert.assertEquals(response.jsonPath().get("middleName"), customer.getMiddleName());
		Assert.assertEquals(response.jsonPath().getLong("phone")+"", customer.getPhone());
	}
	
	
	@Test
	public void CreateCustomer() throws StreamReadException, DatabindException, IOException {
		
		/*
		 * Customer customer = new Customer();
		 * 
		 * customer.setFirstName(fName); 
		 * customer.setMiddleName(mName);
		 * customer.setLastName(lName); 
		 * customer.setEmail(email);
		 * customer.setPhone(phone);
		 */
		
		ObjectMapper mapper = new ObjectMapper();
		
		File file = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\CreateCustomer.json");
		
		customer = mapper.readValue(file, Customer.class);
		
		customer.setFirstName("M");
		customer.setEmail(email);
		
		
		String body = "{"
				+ "  \"email\": \""+email+"\","
				+ "  \"firstName\": \""+fName+"\","
				+ "  \"lastName\": \""+lName+"\","
				+ "  \"middleName\": \""+mName+"\","
				+ "  \"phone\": "+phone+""
				+ "}";
		
		//Gson gson = new Gson();
		
		String cus = new Gson().toJson(customer);
		
		
		Response response =  given().
				header("accept","application/json").
				header("Content-Type","application/json").
				pathParam("createCustomer", "createCustomer"). 
				body(cus).
				post(createCustomer);
		
		System.out.println(response.statusCode());
			
		id = response.jsonPath().getInt("id");
	
		Assert.assertEquals(response.jsonPath().get("email"), email);
		Assert.assertEquals(response.jsonPath().get("firstName"), customer.getFirstName());
		Assert.assertEquals(response.jsonPath().get("lastName"), customer.getLastName());
		Assert.assertEquals(response.jsonPath().get("middleName"), customer.getMiddleName());
		Assert.assertEquals(response.jsonPath().getLong("phone")+"", customer.getPhone());
		
		Assert.assertNotNull(id);
		
		
			
	}

	
	@Test
	public void DeleteCustomer() {
				
		String s = new String();
		s = "Kamol";
		
		String s1 = new String();
		s1 = "Kamol";
		
		if(s.equals(s1)) {
			System.out.println("True");
		}else{
			System.out.println("Not True");
		}
		
	
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
	public void DeleteCustomerById() {
		Response response =  given().
				pathParam("id", id).
				delete(deleteCustomer);

		Assert.assertEquals(response.body().asString(), "1");		
	}
	

	@Test(dependsOnMethods = "DeleteCustomerById")
	public void validateCustomerNotExistbyEmail() {
		Response response =  given().
				pathParam("email", email).
				get(isCustomerExist);

		Assert.assertEquals(response.body().asString(), "false");		
	}
	
	
	@Test
	public void v() {
		
		  Customer customer = new Customer();
		  
		  customer.setFirstName("Test");
		  
		  System.out.println(customer.toString());
		  
		  
		  System.out.println("---------------");
		 
		
		Person person = new Person();
		
		PersonName name = new PersonName();
		
		person.setName(name);
		
		System.out.println(person.getName().getFirstName());
		
		person.getName().setFirstName("Kamol");
		
		 System.out.println(person.getName().getFirstName());

		
		
		
	}

}
