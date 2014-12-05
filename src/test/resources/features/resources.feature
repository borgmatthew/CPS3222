
Feature: Online betting

Scenario: Online betting company
Given I am a user trying to register
When I register providing correct information
Then I should be told that the registration was successful

Given I am a user trying to register
When I fill in a form with correct data and I change the <num1> field to have incorrect input
Then  I  should  be  told  that  the  data  in  <num2>  is incorrect

Examples:
|num1|num2|result|
|5   |2   |7     |