
Feature: Test login HOGS

  Scenario Outline: Test login HOGS
    Given Open Chrome and navigate
    When I input correct "<username>" and "<password>"
    Then I login success

    Examples: 
      | username    | password |
      | username111 |   123456 |
      | jay         | P2ssword |
