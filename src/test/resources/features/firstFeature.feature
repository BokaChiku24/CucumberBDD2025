Feature: Application Login

  Scenario: Admin Page is the default login
    Given User is on the NetBanking landing page
    When User login into application
    Then Home page is displayed
    And Cards are displayed