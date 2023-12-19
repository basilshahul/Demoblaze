Feature: TC4 - Product Selection and Cart Interaction feature

Scenario: Verify product added to cart 
Given the user is on demoblaze website
When the user navigate to a product category
And the user click on a product to view its details
And the user add the product to the cart
Then the user gets the alert message "Product added"