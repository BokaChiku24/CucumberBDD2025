Feature: Search and place the product for the feature

  @GreenCartTest
  Scenario: Search experience for the product search in both home and offer page
    Given User is on GreenCart Landing page
    When user searched with shortname "Tom" and extracted actual name of product
    Then user searched for same shortnmae in offer page to check if product exist