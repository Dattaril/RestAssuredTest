package com.API.RestApiTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;


import static io.restassured.RestAssured.*;



public class TS010A {
	public static String response;
	public static String vID;
	public static String vMSG;

	
	public static void main(String[] args) {
		
		
	System.out.println("********************************");
	RestAssured.baseURI="http://localhost:8080/";
	
	response=given().header("Content-Type","application/json").header("Connection","keep-alive").
	body(AddPIZZAPayLoad()).when().post("addpizza").then().assertThat().statusCode(201).header("unique", containsString("PIZZA")).
	extract().response().asString();
	
	System.out.println(response);
	
	System.out.println("********************************");
	

	JsonPath jpath=new JsonPath(response);
	vID=jpath.getString("id");
	vMSG=jpath.getString("msg");
	
	System.out.println("ID is "+vID);
	System.out.println("Message is "+vMSG);
	
	}
	

	public static String AddPIZZAPayLoad()
	{
		return "{\r\n"
				+ "     \"product\":\"PIZZA\",\r\n"
				+ "     \"price\":\"900\"\r\n"
				+ "}";
	}
}
