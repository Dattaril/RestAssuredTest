package com.API.RestApiTest;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;

public class TS005 {

	
	public static void main(String[] args) {
		
		//Using Query paremetr key value pair
		
		System.out.println("*************************");
		RestAssured.baseURI="http://localhost:8080/";	
		given().queryParam("productName", "Veggie Supreme").when().get("getpizza").then().log().body();
		System.out.println("*************************");
		
	
	}
}
