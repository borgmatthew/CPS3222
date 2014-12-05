
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