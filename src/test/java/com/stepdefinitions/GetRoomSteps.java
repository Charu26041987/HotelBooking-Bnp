package com.stepdefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.specification.RequestSpecification;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetRoomSteps {

	RequestSpecification requestSpec = new RequestSpecBuilder().setBaseUri("https://automationintesting.online")
			.build(); 
    private Response response;

    @Given("the API endpoint for room with ID {int}")
    public void the_api_endpoint_for_room_with_id(Integer roomId) {
        requestSpec = given().log().all();
        requestSpec.basePath("admin/room/" + roomId);
    }

    @When("I am send a GET request to the room endpoint")
    public void I_am_send_a_GET_request_to_the_room_endpoint() {
        response = requestSpec.when().get();
    }

    @Then("verify the response status code should be {int}")
    public void verify_the_response_status_code_should_be(Integer statusCode) {
        response.then().log().all().assertThat().statusCode(statusCode);
    }
}