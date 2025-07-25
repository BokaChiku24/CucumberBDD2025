Feature: Application Login
# Cucumber Scenario
  Scenario: Admin Page is the default login
    Given User is on the NetBanking landing page
    When User login into application
    Then Home page is displayed
    And Cards are displayed

# Cucumber Scenario with Code Reuse
  Scenario: User Page is the default login
    Given User is on the NetBanking landing page
    When User login into application with username "abctest" and password "admin123"
    Then Home page is displayed
    And Cards are displayed

# Cucumber Scenario with Parameters
  Scenario: Admin Page is the default login
    Given User is on the NetBanking landing page
    When User login into application with username "admin" and password 1234
    Then Home page is displayed
    And Cards are displayed

# Cucumber Scenario Outline
    Scenario Outline: Admin Page is the default login
        Given User is on the NetBanking landing page
        When User login into application with username "<username>" and password "<password>"
        Then Home page is displayed
        And Cards are displayed
        Examples:
        | username | password  |
        | admin    | admin123  |
        | user     | user123   |

# Cucumber Regex Pattern Scenario Outline
  Scenario Outline: User Page is the default login
    Given User is on the NetBanking landing page
    When User login into application with username <username> and password "<password>"
    Then Home page is displayed
    And Cards are displayed
    Examples:
      | username | password  |
      | abcTest  | admin@123 |
      | xyztest  | admin@123 |

# Data Driven Scenario
  Scenario: Signup to the application
    Given user is on practice landing page
    When User signup into application
      | Kunal                         |
      | Chavan                        |
      | kunal11233213chavan@gmail.com |
      | 12345678901                   |
    Then landing page is displayed
    And username and password page displayed
