@Ignore

@tag
Feature: Companies Functionality
  I want to use this template for my feature file

  @tag1
  Scenario Outline: Create Company
    Given User reads test data for "<TC Name>"
    Given I go to freecrm website
    And I login to the website
    And I created new company
    Then I validated new company

    Examples: 
      | TC Name           |
      | TC1_CreateCompany |

  @tag2
  Scenario Outline: Delete Company
    Given User reads test data for "<TC Name>"
    Given I go to freecrm website
    And I login to the website
    When I Delete Compnay
    Then Company should be removed

    Examples: 
      | TC Name           |
      | TC2_DeleteCompany |