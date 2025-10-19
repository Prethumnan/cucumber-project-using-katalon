Feature: Forgot password feature
  
  As a registered user
  I want to reset my password when I forget it
  So that I can regain access to my account securely without creating a new one

  Background: 
    Given user is on the forgot password page
    
 	@smoke
  Scenario: Retrive password with valid email
    When User enters email "prethumnan02@gmail.com"
    And click retrive password button
    Then User should get the A confirmation email has been sent to your address message
    
    
   
  @regression
  Scenario Outline: Retrive password with multiple valid email
    When User enters email "<email>"
    And click retrive password button
    Then User should get the A confirmation email has been sent to your address message

  Examples: 
      | email                           | 
      | prethumnan12@gmail.com          | 
      | auto_1760796290323@testmail.com | 
      | auto_1760796307903@testmail.com | 
      | auto_1760796312389@testmail.com | 
      | auto_1760796316476@testmail.com | 
      | auto_1760796328642@testmail.com | 
   
	@regression
  Scenario: Retrive password with new email id
    When User enters email "prethumnan021212@gmail.com"
    And click retrive password button
    Then User should get the There is no account registered for this email address message
    
    
  @regression
  Scenario: Retrive password with new email id
    When User enters no email id
    And click retrive password button
    Then User should get the Invalid email address message 
