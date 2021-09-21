package com.API.RestApiTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;



public class TS010 {

	
	public static void main(String[] args) {
		
		
	System.out.println("********************************");
	RestAssured.baseURI="http://localhost:8080/";
	given().header("Content-Type","application/json").header("Connection","keep-alive").
	body(AddPIZZAPayLoad()).when().post("addpizza").then().assertThat().statusCode(201).
	header("Unique", containsString("PZMNS")).log().all();
	System.out.println("********************************");
	
	}
	

	public static String AddPIZZAPayLoad()
	{
		return "{\r\n"
				+ "     \"product\":\"PZMNS\",\r\n"
				+ "     \"price\":\"900\"\r\n"
				+ "}";
	}
}
