Feature: A user can be created
  It is possible to create a new user and have it persisted with it's relevant details.

  Scenario: Create a user
    Given I am on the user creation page
    When I create a new user
    Then the user should have been created