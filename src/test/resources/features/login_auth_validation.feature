Feature: Login Authentication Validation

  Scenario: Login and validate authentication
    Given the API base URI is set
    When send POST request for login with payload and get a responseBody 
    Then verify login response status code should be 200
    And validate login authentication with the response