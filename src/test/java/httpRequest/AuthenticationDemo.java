package httpRequest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

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
public class AuthenticationDemo 
{
	
  @Test(priority=1)
  public void basic_Auth() 
  {
	  given()
	  		.auth().basic("postman","password")
	  		
	  .when()
	  	.get("https://postman-echo.com/basic-auth")
	  	
	  	.then()
	  		.statusCode(200)
	  		.body("authenticated",equalTo(true))
	  		.log().all();
	  System.out.println("Basic Authentication is completed!");
	  		
	  
  }
  
  
  @Test(priority=2)
  public void digestAuth()
  {
	  System.out.println("*******************************************");
	  given()
	  .auth().digest("postman","password")
	  .when()
	  	.get("https://postman-echo.com/basic-auth")
	  	
	  	.then()
	  	.statusCode(200).log().all();
	  
	  System.out.println("Digest Authetication is completed!");
	  
	  
  }
  
  @Test(priority=3)
  public void preemptiveAuth()
  {
	  System.out.println("*******************************************");

	  given()
	  .auth().preemptive().basic("postman","password")
	  .when()
	  	.get("https://postman-echo.com/basic-auth")
	  	
	  	.then()
	  	.statusCode(200).log().all();
	  
	  System.out.println("Preemptive Authetication is completed!");
	  
	  
  }
  
  @Test(priority=4)
  public void bearerTokenAuth()
  {
	  System.out.println("*******************************************");

	  
	  given()
	  	.header("Authorization","Bearer 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")
	  
	  .when()
	  	.get("https://api.github.com/user/repos")
	  	
	   .then()
	   .statusCode(200)
	   .log().all();
	  System.out.println("Bearer token authentication is completed");
  }
  
  @Test(priority=5)
  public void auth2Test()
  {
	  System.out.println("*******************************************");

	  given()
	  
	  	.auth().oauth2("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")
	  .when()
	  	.get("https://api.github.com/user/repos")
	  
	  .then()
	  .statusCode(200).log().all();
	  
	  System.out.println("Auth2.0 authentication is completed");

	  
	  
	  
	  
	  
  }
  
}
