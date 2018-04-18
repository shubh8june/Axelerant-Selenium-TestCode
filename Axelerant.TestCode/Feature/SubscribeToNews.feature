#Author: Shubhangi Bheda
#

@tag
Feature: Subscribe to the newsletter 

  @tag1
  Scenario: Subscribe to the newsletter from Home Page
    Given Lauch Home Page
    When User enters valid email address to Newsletter field present at the bottom of the Home page
    Then User is subscribed to newsletter successfully