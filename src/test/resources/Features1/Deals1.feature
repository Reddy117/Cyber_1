@Approved

@tag
Feature: Deals Functionality
  I want to use this template for my feature file

  @tag1
  Scenario Outline: Create Deal
    Given User reads test data for "<TC Name>"
    Given I go to freecrm website
    And I login to the website
    When I Create deal

    Examples: 
      | TC Name        |
      | TC2_CreateDeal |