Feature: Search Functionality

Scenario: User searches with valid product
Given User is on the homepage of the application
When User enters a valid product "HP" into the searchBox
And Clicks on searchbutton
Then User should be able to find results for the product

Scenario: User searches with invalid product
Given User is on the homepage of the application
When User enters a invalid product "Soda" into the searchBox
And Clicks on searchbutton
Then User should get a proper warning message about results not found

Scenario: User searches without entering product
Given User is on the homepage of the application
When User does not enters a product into the searchBox
And Clicks on searchbutton
Then User should get a proper warning message about results not found

