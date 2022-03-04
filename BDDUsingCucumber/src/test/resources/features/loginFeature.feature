Feature: Login Page
Description: test the login functionality for OrangeHRM  application

Background: To launch the chrome Browser
					Given Open Browser
					Given LoginPage is Opened


Scenario: Login page with correct User
	 Given Username is 'Admin' and password is 'U@qBLVtm09'
	 When user click on login button
	 Then User should navigate to Dashboard
	 
Scenario: Login page with incorrect User
	 Given Username is 'Admin' and password is 'Ufujfjek'
	 When user click on login button
	 Then User should navigate to Retry Page

Scenario: Login page with incorrect User
	 Given Username is '' and password is 'Ufujfjek'
	 When user click on login button
	 Then User should be in same page
	 
Scenario: Login page with incorrect User
	 Given Username is 'Admin' and password is ''
	 When user click on login button
	 Then User should be in same page

Scenario: Login page with incorrect User
	 Given Username is '' and password is ''
	 When user click on login button
	 Then User should be in same page