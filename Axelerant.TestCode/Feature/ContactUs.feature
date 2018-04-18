#Author: Shubhangi Bheda
#
@tag
Feature: Fill in the Contact us form and Submit it. 
Submit the form without entering email and verify if the error message shown is "Invalid email address."

  @tag1
  Scenario Outline: Fill in contact us form with given data and validate the behaviour
    Given User is on Contact Us Page
    When User enter "<SubjectHead>" and "<email>" and "<Message>"
    Then Validate Message Displayed

Examples:
          | SubjectHead  		 | email  | Message |
          | Customer service |      | Contact Us Message|
          | Customer service | shubh123@gmail.com |Contact Us Message|

