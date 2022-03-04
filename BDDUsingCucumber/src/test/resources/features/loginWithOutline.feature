Feature: Login Page

Background: To launch the chrome Browser
						Given Open Browser
						
@basicTest
Scenario Outline: Login page with various credential
		Given LoginPage is Opened 
		And  Username is '<username>' and password is '<password>'
		When user click on login button
		Then User should navigate to '<page>'
		
		Examples:
		   | username | password | page      |
		   | Admin    |U@qBLVtm09|dashboard  |
		   | Ad       |    abcd  | retryLogin|
		   
		   
@functionality @basicTest
Scenario Outline: Login page with various credential
		Given LoginPage is Opened 
		And  Username is '<username>' and password is '<password>'
		When user click on login button
		Then User should navigate to '<page>'
		
		Examples:
		   | username | password | page      |
		   | Admin    |U@qBLVtm09|dashboard  |
		   | Ad       |    abcd  | retryLogin|