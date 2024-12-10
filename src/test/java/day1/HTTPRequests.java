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

	//@Test
	void getUsers() {
		
	
		
		
		
		when ()
		
		  .get("https://reqres.in/api/users?page=2")
		
		.then ()
		
		   .statusCode(200)
		   .body("page",equalTo(2))
		   .log().all();
	}
	
	@Test
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
}
