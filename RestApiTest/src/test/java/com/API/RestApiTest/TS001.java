package com.API.RestApiTest;
import static io.restassured.RestAssured.*;

public class TS001 {

	
	public static void main(String[] args) {
		
		//given -allthe input details
		//when -Submitthe API-end point,Http Method
		//Then-Validate the repsonse
		
		//Setup the rest assured project
		//Step1-Create a mavenproject.update pom.xml file with the followoing dependencies.
		//*Rest assured 
		//*json path 
		//*xml path
		//*json schema validator.
		//import package import static io.restassured.RestAssured.*;
		
		
		
		
		
		
		given().when().get("http://localhost:8080/getEmployee/Kim0").then().log().body();
	}
}
