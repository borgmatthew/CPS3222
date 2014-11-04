
Feature: Basic calculator functionality

Scenario Outline: Simple addition
Given I am using the calculator
When I add <num1> and <num2>
Then I should get the result <result>


When I subtract 5 and 2
Then I should get the result 3


When I multiply 3 and 2
Then I should get the result 6

When I divide 4 and 2
Then I should get the result 2

Examples:
|num1|num2|result|
|5   |2   |7     |