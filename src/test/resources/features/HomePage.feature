Feature: Home Page

  Background: Navigate to home page, select geolocation and accept cookies
    Given Navigate to home page
    When Geolocation link is visible
    Then Geolocation link clicked
    When Accept all cookies

  Scenario: Verify home page Elements
    Then Title is visible

  Scenario: Verify Track Search is working and returns error message for invalid search
    When User enters incorrect track id
    And Track button is visible
    Then User clicks track button
    Then Search result is returned saying Unfortunately, we are unable to retrieve your tracking results at this time

  Scenario: Verify Rate transit Time navigation is working
    When Rate transit times link is visible
    Then User clicks on rate transit
    And Calculate title is visible

  Scenario: Verify Custom Tools  navigation is working
    When User scroll down to custom tools
    Then User clicks on custom tools
    And User is redirected to custom tools


  Scenario: Verify when user clicks ship he is redirected to login
    When Ship link is present on homepage
    Then User clicks on ship link
    And He is redirected to login screen

  Scenario: Verify duties and taxes navigation
    When Duty and taxes link is visible
    Then User clicks on duty and taxes
    And User is redirected to page duty and tax
    Then User clicks on pay tab
    Then More information regarding duty and taxes are available

  Scenario: Verify service news page is loaded
    When Service alert is present
    Then User clicks on service alert
    And User is redirected to service news page
