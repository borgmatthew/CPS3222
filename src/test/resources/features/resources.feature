
Feature: Online betting

Scenario: Online betting company
Given I am a user trying to register
When I register providing correct information
Then I should be told that the registration was successful

Scenario Outline: Change field names
Given I am a user trying to register
When I fill in a form with correct data and I change the "<fieldname>" field to have incorrect input
Then  I  should  be  told in "<errorMessage>"  that  the  data  in  "<fieldname>"  is "<incorrect>"

Examples:

|fieldname     |incorrect            |errorMessage	|
|firstName     |Invalid characters   |name_error	|
|lastName      |Invalid characters   |surname_error	|
|dob           |Please enter date of birth |dob_error		|
|creditcard    |Invalid card         |creditcard_error|
|expiry_date   |Invalid Expirary date|expiry_error	|

Scenario: Successful bet on free account

Given I am a user with a free account
When I try to place a bet of 5 euros
Then I should be told the bet was successfully placed

Scenario: Ammount of free bets
Given I am a user with a free account
When I try to place a bet of 5 euros
Then I should be told the bet was successfully placed
When I try to place a bet of 5 euros
Then I should be told the bet was successfully placed
When I try to place a bet of 5 euros
Then  I  should  be  told  that  I  have  reached  the  maximum  number of bets

Scenario: denied access
Given I am a user who has not yet logged on
When I try to access the betting screen 
Then I should be refused access

Scenario: stopped
Given I am a user with a premium account
When I try to place a bet of 5000 euros
Then I should be told the bet was successfully placed
When I try to place a bet of 1 euros
Then  I  should  be  told  that  I  have  reached  the  maximum cumulative betting amount 

Scenario Outline: invalid risks
Given I am a user with a free account
When I try to place a "<risk>" bet of 5 euros
Then  <error> 

Examples:

|risk     |error  |
|free |      |
|
