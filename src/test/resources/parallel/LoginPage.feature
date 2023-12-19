Feature: TC3 - User login feature

Scenario: Login with valid credentials
Given user is on home page
When user clicks on login page button
And user enters username "automtester"
And user enters password "Test@123"
And user clicks on login button
Then user gets the welcome message of the page
And welcome message should be "Welcome automtester"