Feature: Login Functionality


Background:
Given Launch appURL "https://www.saucedemo.com/"
When Enter UserName and Password 
|username     |password    |
|standard_user|secret_sauce|
And Click on Submit Button

Scenario: validate Successfull Login functionality
Then Validate Login Page 
Then Validate Product Page Title is "Swag Labs"
When Click on Log out option
Then Validate Login Page


Scenario: validate locked_out_user functionality
Then Validate Login Page
Then Validate locked out user error message appeared is "Epic sadface: Sorry, this user has been locked out.1"
And Validate Login Page
