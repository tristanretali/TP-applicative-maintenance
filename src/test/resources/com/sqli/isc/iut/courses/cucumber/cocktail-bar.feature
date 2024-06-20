Feature: Bar Limitation

  Background: A Cocktail Bar
    Given a new cocktail bar

  Scenario: cocktail bar is above
    Given There is 9 people
    When I add 2 people
    Then the result is false

  Scenario: cocktail bar is full
    Given There is 9 people
    When I add 1 people
    Then the result is true

  Scenario: buy cocktails
    Given There is 8 people
    When I buy 2 cocktails of the month
    Then The result is 20

  Scenario Outline: Add people in cocktail bar
    When I add <a> people
    Then the result is <b>

    Examples: Full and above bar
      | a | b |
      | 2 | false |
      | 1 | true |