Feature: Room Availability API

  Scenario: Check room availability successfully
    Given the API base URI is set
    When I send a GET request to "/api/room"
    Then the response status code should be 200