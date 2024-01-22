Feature: Login
  As a User,
  I want to see Login Functionality working as expected
  So that I can access dashboard menu in website

  Scenario: User Login with registered username and password
    Given User is on Login Page
    When User type valid username
    And User type valid password
    And User click button login
    Then User successfully login and can see dashboard menu

  Scenario: User Login with invalid username and password
    Given User is on Login Page
    When User type invalid username
    And User type invalid password
    And User click button login
    Then User can see error message "Invalid credentials"

  Scenario: User Login without filled password
    Given User is on Login Page
    When User type valid username
    And User click button login
    Then User can see error message "Required" on field password

  Scenario: User Login without filled username
    Given User is on Login Page
    When User type valid password
    And User click button login
    Then User can see error message "Required" on field username

  Scenario: User Login without filled username and password
    Given User is on Login Page
    And User click button login
    Then User can see error message "Required" on field username
    And User can see error message "Required" on field password