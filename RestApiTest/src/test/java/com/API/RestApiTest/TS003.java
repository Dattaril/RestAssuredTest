package com.API.RestApiTest;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;

public class TS003 {

	
	public static void main(String[] args) {
		
		//Using Query paramter
		
		System.out.println("*************************");
		RestAssured.baseURI="http://localhost:8080/";	
		given().when().get("getpizza?productName=Veggie Supreme").then().log().body();
		System.out.println("*************************");
	}
}
