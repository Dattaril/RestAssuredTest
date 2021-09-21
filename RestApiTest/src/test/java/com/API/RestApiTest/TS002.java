package com.API.RestApiTest;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;

public class TS002 {

	
	public static void main(String[] args) {
		
		//Using Base URI
		
		System.out.println("*************************");
		RestAssured.baseURI="http://localhost:8080/";	
		given().when().get("getEmployee/Kim0").then().log().body();
		System.out.println("*************************");
	}
}
