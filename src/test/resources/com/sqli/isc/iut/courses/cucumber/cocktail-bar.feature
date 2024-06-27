Feature: Bar Limitation

  Background: A Cocktail Bar
    Given a new cocktail bar

  Scenario: cocktail bar is above
    Given There is 9 people
    When I add 2 people
    Then The result is false

  Scenario: Mr Leblanc pay for Mr Pignon
    Given There is 8 people
    When I add Mr Pignon and Mr Leblanc
    And Each of them buy one cocktail of the month
    And Mr Leblanc paid for his friend
    Then The result is 20

  Scenario: Mr Leblanc and Mr Pignon pay their addition separatly
    Given There is 3 people
    When I add Mr Pignon and Mr Leblanc
    And Each of them buy one cocktail of the month
    And Mr Pignon pay his addition of 10
    And Mr Leblanc buy 2 other cocktail of the month
    Then The addition of Mr Leblanc is 30
