Feature: Login functionality

  Scenario: Login with valid credentials
    Given User navigates to login page
    When USer has entered valid email address "demo_1@gmail.com" into the email filed
    And User has entered valid password "12345" into password filed
    And User clicks on Login button
    Then User should get successfully logged in

  Scenario: Login with invalid credentials
    Given User navigates to login page
    When USer has entered invalid email address "test@gmai.com" into the email filed
    And User has entered invalid password "123445566788" into password filed
    And User clicks on Login button
    Then User should get warning message about credentials mismatch

  Scenario:  Login with valid email and invalid password
    Given User navigates to login page
    When USer has entered valid email address "test@gmail.com" into the email filed
    And User has entered invalid password "1234567633" into password filed
    And User clicks on Login button
    Then User should get warning message about credentials mismatch

  Scenario:  Login wit invalid email and valid password
    Given User navigates to login page
    When USer has entered invalid email address "test@gmai.com" into the email filed
    And User has entered valid password "12345" into password filed
    And User clicks on Login button
    Then User should get warning message about credentials mismatch

  Scenario:  Login without providing any credentials
    Given User navigates to login page
    When User don't enter email address into email field
    And User don't enter password address into password field
    And User clicks on Login button
    Then User should get warning message about credentials mismatch