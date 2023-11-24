package httpRequest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class GetRequest
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
  @Test(priority=1)
  public void getList_Users() 
  {
	  given()
	  
	  .when().get("https://reqres.in/api/users?page=2")
	  
	  .then()
	  .body("data.id[0]", equalTo(7))
	  .body("page", equalTo(2))
	  .body("total", equalTo(12))
	  .assertThat().statusCode(200)
	   	.log().all();
	  
	  System.out.println("Validation is completed!");
  }
  

  
  @Test(priority=2)
  public void getSingle_User()
  {
	  System.out.println("Single user details are:");
	  given()
	  
	  .when()
	  	.get("https://reqres.in/api/users/2")
	  .then()
	  	.body("data.id",equalTo(2))
	  	.body("data.first_name", equalTo("Janet"))
	  	.statusCode(200).log().all();
	  
	  
  }
  
  
  
  @Test(priority=3)
  public void hasItemMethod()
  {
	  //hasItems():  Check all the element are in collection?(partial matching)
	  
	  given()
	  
	  .when()
	  	.get("https://reqres.in/api/users?page=2")
	  .then()
	  	.body("data.first_name[2]", equalTo("Tobias"))
	  	.body("data.first_name", hasItems("Lindsay","Byron","Michael","George","Rachel"))
	  	.statusCode(200).log().all();
	  
	  
  }
  
  @Test(priority=4)
  public void containsMethod()
  {
	  //contains(): check all elements are in collection and in strict order
	  
	  
	  given()
	  
	  .when()
	  	.get("https://reqres.in/api/users?page=2")
	  .then()
	  	.body("data.first_name", contains("Michael","Lindsay","Tobias","Byron","George","Rachel"))
	  	.statusCode(200).log().all();
	  
	  
	  
  }
}
