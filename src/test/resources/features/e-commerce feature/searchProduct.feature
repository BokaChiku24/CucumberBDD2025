Feature: Search and place the product for the feature

  @GreenCartTest
  Scenario Outline: Search experience for the product search in both home and offer page
    Given User is on GreenCart Landing page
    When user searched with shortname <Name> and extracted actual name of product
    Then user searched for <Name> shortnmae in offer page
    And validate name in offer page matches with landing pages
    Examples:
    |Name|
    |Tom |
    |Beet|