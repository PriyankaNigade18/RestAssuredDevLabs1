package httpRequest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Iterator;

public class HeadersValidation 
{
  //@Test(priority=1)
  public void getAllHeaders()
  {
	  System.out.println("All Headers Info ");
	  given()
	  
	  .when()
	  	.get("https://www.google.com/")
	  .then()
	  	.statusCode(200).log().headers();
	  
  }
  
  
  
  //@Test(priority=2)
  public void validateHeaders()
  {
	  System.out.println("Validation of single header ");
	  
	  Response res=given()
	  
	  .when()
	  	.get("https://www.google.com/");
	  
	  String aValue=res.getHeader("Content-Type");
	  Assert.assertEquals(aValue,"text/html; charset=ISO-8859-1","Fail:Headers not match");
	  System.out.println("Pass: Headers validated!");
	  
	   
  }
  
  
  @Test
  public void getHeaders()
  {
System.out.println("Validation of All header ");
	  
	  Response res=given()
	  
	  .when()
	  	.get("https://www.google.com/");
	  
	  Headers all=res.getHeaders();
	  /*
	   * Headers class return name:value
	   */
	  
	  //iteration
	  
	  System.out.println("*************Iteration*************");
	  Iterator<Header> hd=all.iterator();
	  while(hd.hasNext())
	  {
		  System.out.println(hd.next());
	  }
	  
	  
	  
	  
	  
	  
	  
	  
	  
//	  for(Headers h:all.)
//	  {
//		  
	  }
	  
	  
  
  }
  
  
  

