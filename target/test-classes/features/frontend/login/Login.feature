
Feature: Login

  Background:
    Given user is on "https://obtaincare.site/"
    And enter in email field "nursultan.musakunov@obtaincare.com"
    Then enter in password field "HelloWorld312!"


  Scenario Outline: Login with valid credentials
    Given click Login button
    And Enter in email field "<email>"
    And Enter in Password field "<password>"
    Then click on Login button
    Then i should successfully login
    Examples:
      | email                | password     |  |
      | info@obtaincare.com  | rYy%wQvF@*Y6 |  |
      | testobtaincare@bk.ru | Tt1!         |  |


  Scenario Outline: Login with invalid credentials
    Given click Login button
    And Enter in email field "<email>"
    And Enter in Password field "<password>"
    Then click on Login button
    Then i should see error "<message>"
    Examples:
      | email            | password  | message            |
      | info@obtsdf.com  | rYy%wsdf6 | Account not found. |
      | testobtsdf@bk.ru | sdfsdfasd | Account not found. |


  Scenario:  Verify required field showing proper error message when i click Login button.
    Given click Login button
    And click on Login button in login page
    Then under email field "The Email field is required." message should appear
    Then under Password field "The Password field is required." message should appear


  Scenario:  Verify eye button is working
    Given click Login button
    And on password field enter "12345"
    And click on eye button in password field
    Then click on Login button in login page
    Then i should see "12345" in password field


  Scenario:  Check forget your password link
    Given click Login button
    And link text should be "Forgot your password?"
    And click on link
    Then i should be in "https://auth.obtaincare.site/account/forgotpassword"


  Scenario: Verify following text's is displayed
    Given click Login button
    And verify "LOGIN" text is displayed
    And verify "Email" text is displayed in Email field
    And verify "Password" text is displayed in Password field


  Scenario: Verify sign up button is clickable
    Given click Login button
    And click on Sign up button in login page
    Then i am in Sign up page "Sign up as a user"









