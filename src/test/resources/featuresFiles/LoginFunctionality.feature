Feature: Login Functionality

Scenario: validate LoginPage
Given Launch appURL "https://www.saucedemo.com/"
Then Validate Login Page 
When Enter UserName and Password 
|username     |password    |
|standard_user|secret_sauce|
And Click on Submit Button
Then Validate Product Page Title is "Swag Labs"
When Click on Log out option
Then Validate Login Page