Feature: User Login API

  Scenario: Login successfully and get token
    Given the API base URI is set
    When I send POST request to "/api/auth/login" with login payload
    Then login response status code should be 200
    And I extract the authentication token