Feature: Bar Limitation

  Background: A Cocktail Bar
    Given a new cocktail bar

  Scenario: cocktail bar is above
    Given There is 9 people
    When I add 2 people
    Then The result is false

