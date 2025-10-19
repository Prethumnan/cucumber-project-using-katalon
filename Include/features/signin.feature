Feature: signin feature
  
  Registerd users can sign in into their account 
  and access the website

  Background: 
    Given user is on the signin page
    
 	@smoke
  Scenario Outline: Login with registered email and password
    When User enters email "<email>" and password "<password>"
    And click signin button
    Then User should get the "Welcome to your account. Here you can manage all of your personal information and orders." message
    And click signout

  Examples: 
      | email                           | password    |
      | prethumnan02@gmail.com          | 12345678    |
      

  @regression
  Scenario Outline: Login with multiple registered email and password
    When User enters email "<email>" and password "<password>"
    And click signin button
    Then User should get the "Welcome to your account. Here you can manage all of your personal information and orders." message
    And click signout

  Examples: 
      | email                           | password    |
      | prethumnan12@gmail.com          | 12345678    |
      |auto_1760796290323@testmail.com  | 4mn035xh    |
      | auto_1760796307903@testmail.com | g75nn67cd1  |
      | auto_1760796312389@testmail.com | ipkax6vgph2 |
      | auto_1760796316476@testmail.com | ayull88wct  |
      | auto_1760796328642@testmail.com | c76w3mv47   |
      
      
  @regression
  Scenario: Login with no email id and password
    When User enters nothinng
    And click signin button
    Then User should get the email required message
    
  @regression
  Scenario: Login with registered email and invalid password
     When User enters email "prethumnan02@gmail.com" and password "1212121212"
    And click signin button
    Then User should get authontication failed message
   
   
  @regression
  Scenario: Login with invalid email address
     When User enters email "prethumnan02@" and password "1212121212"
    And click signin button
    Then User should get the invalid email address message
