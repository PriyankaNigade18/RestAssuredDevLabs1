package httpRequest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class HttpBasicRequest {
  @Test
  public void getRequest_SingleUser()
  {
	 Response result= RestAssured.get("https://reqres.in/api/users/2");
	 int statuscode=result.getStatusCode();
	 System.out.println("Session status code: "+statuscode);
	 System.out.println("Session id is: "+result.getSessionId());
	 System.out.println("Body data: "+result.getBody().asString());
	 
	 
	 //validation
	 //Assert.assertTrue(statuscode==200);
	 Assert.assertEquals(statuscode, 200,"Fail: Status code not match");
	 System.out.println("Status code match");
	 
	 
	 
	 
	 
	 
	 
	 
	  
  }
}
