Feature: Create Room Booking API

  Scenario: Create a new room booking successfully
    Given the API base URI is set
    When I create a new room booking
    Then response status code should be 201