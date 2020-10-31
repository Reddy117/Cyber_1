@tag
Feature: Companies functionality
  I want to use this template for my feature file

  @tag1
  Scenario Outline: create company and validate
    Given I go to freecrm website
    And I login to the website
    And I created new company using "<CompanyName>" and "<Web>" and "<Address>" and "<City>" and "<State>"
    Then I validated new company

    Examples: 
      | CompanyName | Web         | Address | City      | State     |
      | Test Com    | www.test.in | Road 15 | Hyderabad | Telangana |
      

  @tag2
  Scenario: Delete Company
    Given I go to freecrm website
     And I login to the website
    When I click on deletebutton
    Then Company should be deleted.
