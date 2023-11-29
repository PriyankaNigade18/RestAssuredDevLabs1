package httpRequest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;
import java.util.Map.Entry;

public class CookiesValidation {
  @Test
  public void getAllCookies() 
  {
	  
	  given()
	  
	  .when()
	  	.get("https://www.google.com/")
	  	
	  .then()
	  .statusCode(200).log().cookies();
  }
  
  @Test
  public void validateCookie()
  {
	Response res=given()
			.when()
			.get("https://www.google.com/");
	
	
		String actCookie=res.getCookie("AEC");
		
		Assert.assertEquals(actCookie, "Ackid1TNFBzx1nUAjzJhXlKW01lqZlc4jloagZXc4Ko1eufZwOjrtCblxD0","Fail:Cookies are Correclty working as server generate dynamic cookies");
		
		System.out.println("Pass:Cookies are working wronlgy as server generate dynamic cookies");
		
		
		
	  	
  }
  @Test
  public void getCookies()
  {
	  
	  Response res=given()
	  	.when()
	  		.get("https://www.google.com/");
	  
	  
	  //to get single cookies data
	  String cookie=res.getCookie("AEC");
	  System.out.println("Single cookie: "+cookie);
	  
	  //to get all cookies
	  Map<String,String> all=res.getCookies();
	  
	  System.out.println("******************Iterating Map****************");
	  //iterate
	  for(Entry<String,String> i:all.entrySet())
	  {
		  System.out.println(i.getKey()+" : "+i.getValue());
	  }
	  
	  
	  
	  
	  
	  
  }
}
