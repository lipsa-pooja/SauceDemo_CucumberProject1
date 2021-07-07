Feature: Product Fucntionlity.

Background:
	Given Launch appURL "https://www.saucedemo.com/"
	When Enter UserName and Password 
	|username     |password    |
	|standard_user|secret_sauce|
	And Click on Submit Button

Scenario: Product Soring Functionality
	Then Verify Product page appear
	Then Verify Prodcut Sort Conatiner appears on the page
	Then Validate By Default "NAME (A TO Z)" selected in Prodcut Sort Conatiner
	When Select "Price (high to low)" option in Prodcut Sort Conatiner
	Then Validate all the Products are appearing as per low to high price
