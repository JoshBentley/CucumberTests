Feature: Use search bar on google home page

Scenario: input in input box
    Given a user is on the google home page
    When a user searches for "comrade doggo"
    Then a user should see pictures of dogs
