package com.stepdefinitions;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class Booking {

	RequestSpecification requestSpec = new RequestSpecBuilder().setBaseUri("https://automationintesting.online")
			.build();

	@Test
	// public static void main(String[] args) {
	public void checkRoomAvilabilityTest() {
		// TODO Auto-generated method stub
		// RestAssured.baseURI = "https://automationintesting.online";

		// 1.Checking Room Availability

		given().spec(requestSpec).log().all().when().get("api/room").then().log().all().assertThat().statusCode(200);

	}

	@Test
	public void createRoomBookingTest() {
		// 2.Create Room Booking
		given().spec(requestSpec).log().all().body(Payload.CreateBooking()).when().post("api/booking").then().log()
				.all().assertThat().statusCode(201);

	}

	@Test
	public void loginTest() {
		// 3.Login

		String response = given().spec(requestSpec).log().all().body(Payload.Login()).when().post("api/auth/login")
				.then().log().all().assertThat().statusCode(200).extract().response().getBody().asString();

		System.out.println("Token:" + response);

	}
	
	@Test
	public void validateLoginAuthTest() {
		// 4. Validate Login Auth
		String response = given().spec(requestSpec).log().all().body(Payload.Login()).when().post("api/auth/login")
				.then().log().all().assertThat().statusCode(200).extract().response().getBody().asString();

		given().spec(requestSpec).log().all().body(response).when().post("api/auth/validate").then().log().all()
				.assertThat().statusCode(200);
	}
	
	@Test
	public void getRoomTest() {

		// 5. Get Rooms
		given().spec(requestSpec).log().all().when().get("admin/room/2").then().log().all().assertThat()
				.statusCode(200);

	}
}
