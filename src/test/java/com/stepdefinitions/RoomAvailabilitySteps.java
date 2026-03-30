package com.stepdefinitions;

import static io.restassured.RestAssured.*;

import io.cucumber.java.en.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RoomAvailabilitySteps {

    RequestSpecification requestSpec;
    Response response;

    @Given("the API base URI is set")
    public void the_api_base_uri_is_set() {
    	 requestSpec = new RequestSpecBuilder().setBaseUri("https://automationintesting.online")
    			.build();    }

    @When("I send a GET request to {string}")
    public void i_send_a_get_request_to(String endpoint) {
        
    	response = given().spec(requestSpec).log().all().when().get(endpoint);
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(int statusCode) {
        response 
                .then()
                .log().all()
                .assertThat()
                .statusCode(statusCode);
    }
}