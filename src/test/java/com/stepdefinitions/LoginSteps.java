package com.stepdefinitions;


import io.cucumber.java.en.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

public class LoginSteps {

    public static String authToken;
    RequestSpecification requestSpec = new RequestSpecBuilder().setBaseUri("https://automationintesting.online")
			.build(); 
    Response response;

    @When("I send POST request to {string} with login payload")
    public void I_send_POST_request_to_with_login_payload(String endpoint) {
        response = given().spec(requestSpec)
                .log().all()
                .body(Payload.Login())
                .when()
                .post(endpoint);
    }

    @Then("login response status code should be {int}")
    public void login_response_status_code_should_be(int statusCode) {
        response
                .then()
                .log().all()
                .assertThat()
                .statusCode(statusCode);
    }

    @Then("I extract the authentication token")
    public void I_extract_the_authentication_token() {
        authToken = response.getBody().asString();
        System.out.println("Token: " + authToken);
    }
}