package com.stepdefinitions;


import io.cucumber.java.en.*;
import static io.restassured.RestAssured.*;

import io.cucumber.java.en.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class LoginAuthValidationSteps {

    Response loginResponse;
    String loginResponseBody;
    RequestSpecification requestSpec = new RequestSpecBuilder().setBaseUri("https://automationintesting.online")
			.build(); 


    @Then("send POST request for login with payload and get a responseBody")
    public void send_POST_request_for_login_with_payload_and_get_a_responseBody () {
    	loginResponse = given()
                .spec(requestSpec)       
                .log().all()
                .body(Payload.Login())    
                .when().post("api/auth/login");
                

        loginResponseBody = loginResponse.getBody().asString();
    }
    @Then("verify login response status code should be {int}")
    public void verify_login_response_status_code_should_be(int statusCode) {
        loginResponse.then()
                .log().all()
                .assertThat()
                .statusCode(statusCode);
    }

    @Then("validate login authentication with the response")
    public void validate_login_authentication_with_the_response() {
        given()
                .spec(requestSpec)
                .log().all()
                .body(loginResponseBody)
                .when()
                .post("api/auth/validate")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200);
    }
}