Feature: Open Account Page

  Background: Navigate to home page, select geolocation and accept cookies
    Given Navigate to home page
    When Geolocation link is visible
    Then Geolocation link clicked
    When Accept all cookies

  Scenario: Enter new account details
    When Navigate to open account page
    Then Open account button is visible
    And Enter contact information
    Then Enter fedex user id information
    And Shipping account type selection
    Then Credit card details verification
