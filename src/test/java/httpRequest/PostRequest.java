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
	
	
	
	
 // @Test
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
  
  //@Test
  public void students_Hash()
  {
	  //payload
	  HashMap<String,Object> data=new HashMap<String,Object>();
	  data.put("name","Jay");
	  data.put("location","India");
	  data.put("phone","121233");
	  String arr[]={"python","C#"};
	  data.put("courses",arr);
	  
	  given()
	  	.contentType("application/json")
	  	.body(data)
	  	
	  .when()
	  	.post("http://localhost:3000/students")
	  
	  .then()
	  	.statusCode(201)
	  	.body("name",equalTo("Jay"))
	  	.body("location",equalTo("India"))
	  	.body("phone",equalTo("121233"))
	  	.body("courses[0]", equalTo("python"))
	  	.body("courses[1]",equalTo("C#"))
	  	.log().all();
	    
	   
  }
  
  
  //@Test
  public void studentPost()
  {
	  
	  //payload
	  StudentPOJO pojo=new StudentPOJO();
	  pojo.setName("Sam");
	  pojo.setLocation("Us");
	  pojo.setPhone("464678");
	  String arr[]= {"C","PHP"};
	  pojo.setCourses(arr);
	  
	    
	  given()
	  	.contentType("application/json")
	  	.body(pojo)
	  	
	  .when()
	  	.post("http://localhost:3000/students")
	  
	  .then()
	  	.statusCode(201)
	  	.body("name",equalTo("Sam"))
	  	.body("location",equalTo("Us"))
	  	.body("phone",equalTo("464678"))
	  	.body("courses[0]",equalTo("C"))
	  	.body("courses[1]",equalTo("PHP"))
	  	.log().all();
	    
	   
  }
  
  @Test
  public void deletePojo() {
	  
	  given()
	  
	  .when()
	  	.delete("http://localhost:3000/students/4")
	  	
	  	.then()
	  		.statusCode(200).log().all();
	  System.out.println("Student id=4 record is deleted!");
  }
  
  
}
