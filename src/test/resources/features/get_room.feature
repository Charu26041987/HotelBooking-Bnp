Feature: Room API testing

  Scenario: Get a specific room by ID
    Given the API endpoint for room with ID 2
    When I am send a GET request to the room endpoint
    Then verify the response status code should be 200