Feature: Search in BlazeDemo

  Scenario: Search flights from Philadelphia to Buenos Aires
    Given I have an open Chrome browser
    When I navigate to "https://blazedemo.com/"
    And Select "Philadelphia" as Departure City
    And I press Find Flights
    Then I should a page with the title "Flights from Philadelphia to Buenos Aires:"