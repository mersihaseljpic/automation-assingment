Feature: Login page

  Background: Navigate to home page, select geolocation and accept cookies
    Given Navigate to home page
    When Geolocation link is visible
    Then Geolocation link clicked
    When Accept all cookies
    When Navigate to login page
    Then Login title is visible

  Scenario: Verify login page shows error message for invalid credentials
    When Enter user credentials username fake and password fake
    Then Login error message is visible

  Scenario: Verify successful login
    When Enter user credentials username testm@mail.com and password Password123!
    Then My profile page is visible