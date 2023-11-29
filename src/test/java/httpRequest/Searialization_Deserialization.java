package httpRequest;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Searialization_Deserialization 
{
	/*
	 * Serialization===>POJO===>JSON
	 * De-serialization===>JSON===>POJO
	 * 
	 */
  //@Test
  public void searializationTest() throws JsonProcessingException 
  {
	  StudentPOJO pojo=new StudentPOJO();
	  pojo.setName("Neha");
	  pojo.setLocation("India");
	  pojo.setPhone("98977767");
	  String arr[]= {"HTML","CSS"};
	  pojo.setCourses(arr);
	  
	  //pojo---->Json
	  ObjectMapper map=new ObjectMapper();
	  String jsonData=map.writerWithDefaultPrettyPrinter().writeValueAsString(pojo);
	  
	  System.out.println(jsonData);
	  System.out.println("Serialization Process OBJECT to JSON completed!");
	  
  }
  
  
  @Test
  public void deserializationTest() throws JsonMappingException, JsonProcessingException
  {
	  
	  //json into POjo
	  
	  String jsondata="{\n"
	  		+ "  \"name\" : \"Neha\",\n"
	  		+ "  \"location\" : \"India\",\n"
	  		+ "  \"phone\" : \"98977767\",\n"
	  		+ "  \"courses\" : [ \"HTML\", \"CSS\" ]\n"
	  		+ "}";
	  
	  ObjectMapper map=new ObjectMapper();
	 StudentPOJO pojo= map.readValue(jsondata,StudentPOJO.class );
	  
	 //Validation
	 System.out.println(pojo.getName());
	 System.out.println(pojo.getLocation());
	 System.out.println(pojo.getPhone());
	 System.out.println(pojo.getCourses()[0]);
	 System.out.println(pojo.getCourses()[1]);
	  
	 System.out.println("Deserialization JSON to POJO completed!");
	  
	  
  }
  
  
}
