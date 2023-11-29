package httpRequest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Query_PathParameters
{
	
	
	@Test(priority=1)
	public void get_Request()
	{
		given()
		
		.when()
			.get("https://reqres.in/api/users?page=2&id=7")
			
		.then()
			.statusCode(200).log().all();
		
		System.out.println("This is simple get Request!");
	}

	
	@Test(priority=2)
	public void query_PathTest()
	{
		given()
		.pathParam("apipath","users")
		.queryParam("page","2")
		.queryParam("id","7")
		
		.when()
			.get("https://reqres.in/api/{apipath}")
			
		.then()
			.statusCode(200).log().body();
		System.out.println("This is get request with path and query parameter");
	}
}
