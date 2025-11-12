Feature: Search functionality

  Scenario: User searches for a valid product
    Given User opens the Application
    When User enters valid product "HP" into Search box filed
    And User clicks on Search button
    Then User should get valid product displays in search results

  Scenario: User searches for a Invalid product
    Given User opens the Application
    When User enters invalid product "Honda Car" into Search box filed
    And User clicks on Search button
    Then User should get message about no product matching

  Scenario: User searches without any product
    Given User opens the Application
    When User don't enters any product name into search box field
    And User clicks on Search button
    Then User should get message about no product matching