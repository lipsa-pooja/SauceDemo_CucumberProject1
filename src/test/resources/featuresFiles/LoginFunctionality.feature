Feature: Login Functionality

Scenario: validate LoginPage
Given Launch appURL https://www.saucedemo.com/ 
Then Validate Login Page Title
When Enter User Name and Password
And Click on Submit Button
Then Validate Product Page Title
When Click on Log out option
Then Validate Login page appear