Feature: Logout
  As a User,
  I want to see Logout Functionality working as expected
  So that I can login with another account

  Scenario: User logs out successfully
    Given User already in Dashboard Page
    When User clicks on the user dropdown
    And User clicks on the logout button
    Then User should be redirected to the login page