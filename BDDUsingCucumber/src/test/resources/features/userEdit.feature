Feature: Modifying Admin Role 
Description: changing the admin role of amanda to Global Admin

Background: To launch the chrome Browser
					Given open BrowserLogin page And Username is 'Admin' and password is 'U@qBLVtm09'
	 				When user click on login button
	 				Then User should navigate to Dashboard

Scenario: navigating to users page
		Given Admin Role is 'Global Admin'
		When user click on Admin button
		     And user click on User Management button
		     And user click on Users button
		Then User should navigate to Users page
		
Scenario: Adding Admin Role to amanda
		Given Username is 'amanda'
		When user click amanda Edit button
					And click on Admin Role dropdown
					And click on Global Admin
					And click on save button
		Then user should able to see Global Admin in User Roles of amanda
