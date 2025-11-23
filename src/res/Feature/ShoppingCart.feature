Feature: Verify add to card functionality

  Scenario: User searches for a Invalid product
    Given User opens the Application
    When User enters invalid product "iPhone" into Search box filed
    And User clicks on Search button