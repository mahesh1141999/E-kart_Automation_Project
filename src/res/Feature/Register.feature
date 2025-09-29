Feature: Registration functionality

  Scenario: User creates an account only with mandatory fields
    Given User navigates to Register Accounts Page
    When User enters the details into below fileds
      | firstName | Mahesh         |
      | lastName  | Patil          |
      | email     | demo_13@gmail.com |
      | telephone |1234567891|
      | Password  | 1234           |
    And User selects Privacy Policy
    And User clicks on continue button
    Then User account should get created successfully

  Scenario: User creates an account  with All fields
    Given User navigates to Register Accounts Page
    When User enters the details into below fileds
      | firstName | Mahesh          |
      | lastName  | Patil           |
      | email     | demo_14@gmail.com |
      | telephone |1234567892|
      | Password  |12345|
    And User Selects Yes for NewsLetter
    And User selects Privacy Policy
    And User clicks on continue button
    Then User account should get created successfully

  Scenario: User creates a duplicates account
    Given User navigates to Register Accounts Page
    When User enters the details into below fileds
      | firstName | Mahesh          |
      | lastName  | Patil           |
      | email     | demo@gmail.com |
      | telephone |1234564893|
      | Password  |12345|
    And User Selects Yes for NewsLetter
    And User selects Privacy Policy
    And User clicks on continue button
    Then User should get proper warning message about duplicate email

  Scenario: User creates an account without filling any details
    Given User navigates to Register Accounts Page
    When User don't enters any details into  fileds
    And User clicks on continue button
    Then User should get proper warning message for every mandatory field