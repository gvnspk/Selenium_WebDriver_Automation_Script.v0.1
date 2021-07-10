Feature: Automated End2End Tests
Description: The purpose of this feature is to test End 2 End integration.

Scenario Outline: Customer placing an order by purchasing an item from search
Given user is on home page
When user searches for "dress"
And choose to buy the first item
And moves to checkout from proceed to cart option
And enter "<customer>" details on checkout page
And place the order
Then Order should be sucessfully placed  
Examples:
|customer|
|Steve|
|Tony|