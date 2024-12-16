package day1;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

/**
 * given() 
 * content type , cookies , header , add auth .................
 * 
 * when()
 * get() request , post() request , delete()request , put() request
 * 
 * then() All the validation , status codes , extract response , header cookies
 * response .............
 * 
 * 
 */
public class HTTPRequests {
	
	int id;

	@Test(priority = 1)
	void getUsers() {
		
		when ()
		
		  .get("https://reqres.in/api/users?page=2")
		
		.then ()
		
		   .statusCode(200)
		   .body("page",equalTo(2))
		   .log().all();
	}
	
	@Test(priority = 2)
	 public void getCreateUser() {
        // Prepare request body
        HashMap<String, String> hs = new HashMap<>();
        hs.put("name", "pavan");
        hs.put("job", "Engineer");
        
        // Make POST request and validate response
        given()
            .contentType(ContentType.JSON)
            .body(hs)
        .when()
            .post("https://reqres.in/api/users")
        .then()
            .statusCode(201) // Validate the response code
            .body("name", equalTo("pavan")) // Validate response body
            .body("job", equalTo("Engineer")) 
            .log().all(); // Log full response for debugging
    }
	    @Test(priority = 3)
	   public void updateUser() {
	    	
	    	
	    	 HashMap<String, String> hs = new HashMap<>();
	         hs.put("name", "ABHI");
	         hs.put("job", " Automation Engineer");
	         
	         // Make POST request and validate response
	         given()
	             .contentType(ContentType.JSON)
	             .body(hs)
	         .when()
	             .put("https://reqres.in/api/users" + id)
	         .then()
	             .statusCode(200) // Validate the response code
	             .body("name", equalTo("pavan")) // Validate response body
	             .body("job", equalTo("Engineer")) 
	             .log().all(); // Log full response for debugging
	    	
	    	
	    	
	    	
	    	
	    }
	
	
	
	
	@Test(priority = 4)
	
	public void deleteUser()
	{
		
		given()
		
		.when()
		 .delete("https://reqres.in/api/users/"+id)
		.then()
		 .statusCode(204)
		 .log().all();
		
		
		
	}
	}
