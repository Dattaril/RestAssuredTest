package com.API.RestApiTest;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;

public class TS004 {

	
	public static void main(String[] args) {
		
		//Using Query paramter and path paramter
		
		System.out.println("*************************");
		RestAssured.baseURI="http://localhost:8080/";	
		given().when().get("getpizza?productName=Veggie Supreme").then().log().body();
		System.out.println("*************************");
		
		System.out.println("*************************");
		RestAssured.baseURI="http://localhost:8080/";	
		given().when().get("getpizza/NonVeg Delight0").then().log().body();
		System.out.println("*************************");
	}
}
