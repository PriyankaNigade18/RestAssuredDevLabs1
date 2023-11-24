package httpRequest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class PostRequest
{
	/* BDD-static import
	 * given()=Prerequisite
	 * header,cookies,body(request pay load),auth request
	 * 
	 * when()=Request
	 * GET,POST,PUT,PATCH,DELETE
	 * 
	 * then()=validation
	 * response code,message,response pay load,header
	 * 
	 */
	/*
	 * post request here we can send request payload
	 * 1.Using Map
	 * 2.Using POJO (plain old Java Object)[Encapsulation] 
	 */
	
	
	
	
  @Test
  public void post_UsingMap()
  {
	  //data- payload
	  HashMap<String,Object> data=new HashMap<String,Object>();
	  data.put("name","Priyanka");
	  data.put("job","SDET");
	  
	  
	  given()
	  	.contentType("application/json")
	  	.body(data)
	  	
	  .when()
	  	.post("https://reqres.in/api/users")
	  
	  .then()
	  	.statusCode(201).log().all();
	  
	  System.out.println("User created successfully");
	  
	  
	  
	  
	  
  }
}
