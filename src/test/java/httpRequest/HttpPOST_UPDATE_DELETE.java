package httpRequest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;


public class HttpPOST_UPDATE_DELETE
{
	/*
	 * create new resource-->update same ---->delete same based on id
	 */
	int id;
  @Test(priority=1)
  public void create_User()
  {
	  
	  //data
	  HashMap<String,Object> data=new HashMap<String,Object>();
	  data.put("name","Sarang");
	  data.put("job","QA");
	  
	  
	  id=given()
	  	.contentType("application/json")
	  	.body(data)
	  	
	  .when()
	  	.post("https://reqres.in/api/users")
	  	.jsonPath().getInt("id");


	  System.out.println("Updated id is: "+id);
	  System.out.println("User is created with id: "+id);
	 
	    }
  
  @Test(priority=2,dependsOnMethods = "create_User")
  public void updateSameUser()
  {
	  //data
	  HashMap<String,Object> data=new HashMap<String,Object>();
	  data.put("name","priyanka");
	  data.put("job","QA");
	  
	  given()
	  .contentType("application/json")
	  .body(data)
	  
	  .when()
	  	.put("https://reqres.in/api/users/"+id)
	  
	  .then()
	  	.statusCode(200).log().all();
	  System.out.println("Same user updated with id: "+id);
	  
  }
  
  
  @Test(priority=3,dependsOnMethods = "updateSameUser")
  public void deleteSameUser()
   {
	  
	  given()
	  
	  .when()
	  	.delete("https://reqres.in/api/users/"+id)
	  	
	  	.then()
	  		.statusCode(204).log().all();
	  
	  System.out.println("User resource is deleted with id: "+id);
	  
  }
}
