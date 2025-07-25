Feature: Application Login

  Scenario: Admin Page is the default login
    Given User is on the NetBanking landing page
    When User login into application with username "admin" and password "admin123"
    Then Home page is displayed
    And Cards are displayed

  Scenario Outline: User Page is the default login
    Given User is on the NetBanking landing page
    When User login into application with multiple username "<username>" and password "<password>"
    Then Home page is displayed
    And Cards are displayed
    Examples:
      | username | password  |
      | abcTest  | admin@123 |
      | xyztest  | admin@123 |
