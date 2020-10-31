@tag
Feature: Deals Functionality
  I want to use this template for my feature file

  @dealtag1
  Scenario Outline: Create Deal
    Given I go to freecrm website
    And I login to the website
    And Create deal using "<Deal Title>"

    Examples: 
      | Deal Title |
      | Test Deal  |
      | New Deal   |
