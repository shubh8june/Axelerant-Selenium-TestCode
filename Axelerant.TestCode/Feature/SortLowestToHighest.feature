#Author: Shubhangi Bheda
#

@tag
Feature: On item list page when user select the option Price: Lowest First, 
the items in the list get listed by lowest prize to highest prize


  @tag1
  Scenario: User is on Item List and select the option Price:Highest First for Sort By. The list is sorted 
    Given User launches shopping website
    When  User click on Women link to view all the items available under women category
    And User select sort by otion Prize:Highest First
    Then Items are listed according to prize Higest First


