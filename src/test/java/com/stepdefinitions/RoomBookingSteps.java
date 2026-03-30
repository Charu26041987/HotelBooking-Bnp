package com.stepdefinitions;


import io.cucumber.java.en.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class RoomBookingSteps {

    RequestSpecification requestSpec=new RequestSpecBuilder().setBaseUri("https://automationintesting.online")
			.build(); 
    Response response;

    @When("I create a new room booking")
    public void i_create_a_new_room_booking() {
    	response = given().spec(requestSpec)
                .log().all()
                .body(Payload.CreateBooking()) 
                .when()
                .post("/api/booking");
    }
    @Then("response status code should be {int}")
    public void response_status_code_should_be(int statusCode) {
        response 
                .then()
                .log().all()
                .assertThat()
                .statusCode(statusCode);
    }
 
}
