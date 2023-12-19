Feature: Login functionality

Scenario: Login with valid Credentials
Given User navigates to the login page of the application
When User enters valid email address "praveenkaverimohan@gmail.com" into email field
And enters valid password 12345 into password field
And user clicks on login button
Then User should get logged into their account successfully

Scenario: Login with invalid Credentials
Given User navigates to the login page of the application
When User enters invalid email address into email field
And enters invalid password 123456 into password field
And user clicks on login button
Then User should not get logged into their account
And gets a proper warning message for credentials mismatch

Scenario: Login with valid email and invalid password
Given User navigates to the login page of the application
When User enters valid email address "praveenkaverimohan@gmail.com" into email field
And enters invalid password 123456 into password field
And user clicks on login button
Then User should not get logged into their account
And gets a proper warning message for credentials mismatch

Scenario: Login with invalid email and valid password
Given User navigates to the login page of the application
When User enters invalid email address into email field
And enters valid password 12345 into password field
And user clicks on login button
Then User should not get logged into their account
And gets a proper warning message for credentials mismatch

Scenario: Login without any Credentials
Given User navigates to the login page of the application
When User does not enter email into email field
And does not enter password into password field
And user clicks on login button
Then User should not get logged into their account
And gets a proper warning message for credentials mismatch

