Feature: TC5 - Placing an Order feature

Scenario: Verify product order placed 
Given the user is on demoblaze website
When the user add product to cart
Then the user gets the alert message "Product added"
When the user click on the cart
Then the user go to the cart page
And the user review the items in the cart
When the user click on the place order button
And the user fill the shipping details and click purchase button
Then the user gets the alert "Thank you for your purchase!"