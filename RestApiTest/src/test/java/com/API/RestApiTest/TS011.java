package com.API.RestApiTest;



import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;



public class TS011 {
	public static String response;
	public static String vID;
	public static String vMSG;

	
	public static void main(String[] args) throws InterruptedException {
	  

RestAssured.baseURI="http://localhost:8080/";
		
		CREATE_CRUD();
		Thread.sleep(5000);
		GET_CRUD();
		Thread.sleep(5000);
		UPDATE_CRUD();
		Thread.sleep(15000);
		DELETE_CRUD();
		Thread.sleep(5000);


}
	public static void CREATE_CRUD() {
		
		
	System.out.println("********************************");
	RestAssured.baseURI="http://localhost:8080/";
	
	response=given().header("Content-Type","application/json").header("Connection","keep-alive").
	body(AddPIZZAPayLoad()).when().post("addpizza").then().assertThat().statusCode(201).header("unique", containsString("Nonveg Supreme")).
	extract().response().asString();
	
	System.out.println(response);
	
	System.out.println("********************************");
	

	JsonPath jpath=new JsonPath(response);
	vID=jpath.getString("id");
	vMSG=jpath.getString("msg");
	
	System.out.println("ID is "+vID);
	System.out.println("Message is "+vMSG);
	
	}
	
	public static void GET_CRUD() {
		
		
		System.out.println("********************************");
		response=given().when().get("getpizza/"+vID).then().log().all().extract().response().asString();
		JsonPath jpath=new JsonPath(response);
		Assert.assertEquals(vID, jpath.getString("id"));
		System.out.println("--------------------------------------");
		
		
		
	}
	
	public static void UPDATE_CRUD()
	{
		System.out.println("--------------------------------------");
		given().header("Content-Type","application/json").body(updatepizza())
		.when().put("updatepizza/"+vID)
		.then().log().body();
		System.out.println("--------------------------------------");
	}
	
	public static void DELETE_CRUD()
	{
		System.out.println("--------------------------------------");
		given().header("Content-Type","application/json").body(deletepizza())
		.when().delete("deletepizza")
		.then().log().body().log();
		System.out.println("--------------------------------------");
	}
	
	
	
	
	public static String AddPIZZAPayLoad()
	{
		return "{\r\n"
				+ "     \"product\":\"Nonveg Supreme\",\r\n"
				+ "     \"price\":\"900\"\r\n"
				+ "}";
	}
	
	public static String updatepizza()
	{
		
		return "{\r\n"
				+ "     \"product\":\"NonVeg Delight\",\r\n"
				+ "     \"price\":\"200\"\r\n"
				+ "}";
	}
	
	public static String deletepizza()
	{
		return "{\r\n"
				+ "    \"id\":\""+vID+"\"\r\n"
				+ "}";
	}
}

