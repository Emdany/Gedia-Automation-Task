@test
Feature: Google search

Background:
  When I Change Language to English

  Scenario: Search for Mercedes A class
    Given I am on the Google home page
    When I search for Mercedes A class
    Then I should see the specified result i want

