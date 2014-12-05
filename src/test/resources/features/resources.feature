
Feature: Online betting

Scenario: Online betting company
Given I am a user trying to register
When I register providing correct information
Then I should be told that the registration was successful

Scenario Outline: Change field names
Given I am a user trying to register
When I fill in a form with correct data and I change the "fieldname" field to have incorrect input
Then  I  should  be  told  that  the  data  in  "fieldname"  is "incorrect"

Examples:

|fieldname     |incorrect            |
|firstName     |Invalid characters   |
|lastName      |Invalid characters   |
|dob           |Under age            |
|creditcard    |Invalid card         |
|expiry_date   |Invalid Expirary date|