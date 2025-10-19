Feature: Create Account functionality validation
  As a new user
  I want to create an account
  So that I can access my profile and other features
  
  Background:
  	 Given User is on the signin page

    
  @Smoke
  Scenario: create account with valid data
   
    When User enters a valid email address in create account section
    And User clicks on Create an account button
    And Enters all mandatory fiels and click register button
    Then User should get a success message
		And User should log out
    
   #Negative test case 
   @Regression
   Scenario: Trying creating account with no email id from the signin page
   
   When user enters no email id
   And User clicks on Create an account button
   Then the error message should appear
   
   @Regression
   Scenario: Create new account with already registered email id
   
   When user enters already registered email
   And User clicks on Create an account button
   Then the error message already registered should appear
   
   @Regression
   Scenario: Creating new account with larger first name
   
   When User enters a valid email address in create account section
   And User clicks on Create an account button
   And enter longer name and fill fills rest of the fields
   And User clicks on register button
   Then the error message first name too long message should appear
   
   @Regression
   Scenario: Creating new account with passowrd lesser than 5 character
   
   When User enters a valid email address in create account section
   And User clicks on Create an account button
   And password less than 5 character and fills the rest of the fields
   And User clicks on register button
   Then the error message invalid password should appear
   
   
   
	
  