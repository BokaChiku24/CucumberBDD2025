Feature: Application Login

  Scenario: Signup to the application
    Given user is on practice landing page
    When User signup into application
      | Kunal                         |
      | Chavan                        |
      | kunal11233213chavan@gmail.com |
      | 12345678901                   |
    Then landing page is displayed
    And username and password page displayed

