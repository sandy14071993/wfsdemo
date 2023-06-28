Feature: Login page feature

@loginTest
Scenario: Login with correct credentials.

Given user is on Swag Labs  login page
When user enters the "standard_user" and "secret_sauce" and click on login 
Then user is on product page and verify the page title should be "Swag Labs"

Scenario Outline: Sorting of products in products page

Given user is on Swag Labs  login page
And  user enters the "standard_user" and "secret_sauce" and click on login
When user is on product page and verify the page title should be "Swag Labs"
And user select for Sorting by click on <sorting as>
Then Verify sorting in <order>

Examples:
|     sorting as    |  order   |
|Price (low to high)| ascending|
|Price (high to low)|descending|