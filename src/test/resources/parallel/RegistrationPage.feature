Feature: TC2 - Registration with valid data feature

Scenario: Register with valid data
Given the user is on demoblaze website
When the user click on the sign up link
And the user fill out the registration form with valid data
And the user click on the sign up button
Then the user gets alert message "Sign up successful." 
