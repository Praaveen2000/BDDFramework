Feature: Register functionality

Scenario: User registers into the application by providing mandatory fields
Given User navigates to register page of the application
When User enters the below fields
|firstName	|Praaveen|
|lastName		|Mohan|
|telephone	|24353654646|
|password 	|12345|
And User selects Privacy Policy
And User clicks on Continue button
Then User should successfully create an account

Scenario: User registers into the application by providing all fields
Given User navigates to register page of the application
When User enters the below fields
|firstName	|Praaveen|
|lastName		|Mohan|
|telephone	|24353654646|
|password 	|12345|
And User selects Yes for Newsletter
And User selects Privacy Policy
And User clicks on Continue button
Then User should successfully create an account

Scenario: User registers into the application by providing duplicate email
Given User navigates to register page of the application
When User enters the below fields with duplicate email
|firstName	|Praaveen|
|lastName		|Mohan|
|email			|praveenkaverimohan@gmail.com|
|telephone	|24353654646|
|password 	|12345|
And User selects Yes for Newsletter
And User selects Privacy Policy
And User clicks on Continue button
Then User should not able to create an account
And User gets a proper warning message about duplicate email address

Scenario: User registers into the application without providing any details
Given User navigates to register page of the application
When User clicks on Continue button
Then User should not able to create an account
And User gets a proper warning message about the empty mandatory fields



