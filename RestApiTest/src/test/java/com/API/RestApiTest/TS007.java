package com.API.RestApiTest;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;

public class TS007 {

	
	public static void main(String[] args) {
		
	
		
		System.out.println("*************************");
		RestAssured.baseURI="http://localhost:8080/";	
		given().header("Content-Type","application/json").body("{\r\n"
				+ "     \"product\":\"Mexican Ecstacy\",\r\n"
				+ "     \"price\":\"900\"\r\n"
				+ "}").when().post("addpizza").then().log().all().assertThat().statusCode(201);
		
	
	}
}
