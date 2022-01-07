Feature: Sign up functionality

  Background:
    Given user is on "https://obtaincare.site/"
    And enter in email field "nursultan.musakunov@obtaincare.com"
    Then enter in password field "HelloWorld312!"


  Scenario: Sign up as new user
    Given click on Sign up button
    And i am on Sign up page
    And enter in First name field test data
    And enter in Last name field test data
    And enter in Email field test data
    And enter in Password field "VeryHardP@$$312!"
    And enter in Confirm password field "VeryHardP@$$312!"
    And click on Accept Terms checkbox
    And click on Create an account button
    Then i should see "We have sent you s verification email. Please check your inbox." message


  Scenario: Verify sign up page have following fields and texts
    Given click on Sign up button
    And i am on Sign up page
    And First name field text should be "First name"
    And last name field text should be "Last name"
    And Email field text should be "Email"
    And Password field text should be "Password"
    And Confirm password field text should be "Confirm password"


  Scenario: Mandatory fields error message
    Given click on Sign up button
    And i am on Sign up page
    When i click on Create an account button
    Then "The FirstName field is required." message should appear under the First name field
    And "The LastName field is required." message should appear under the Last name field
    And "The Email field is required." message should appear under the Email field
    And "The Password field is required." message should appear under Password field
    Then "Please confirm your agreement with our terms of service to register" message should appear under Accept Terms checkbox


  Scenario: Check Login button
    Given click on Sign up button
    And i am on Sign up page
    And verify Login button is displayed
    When i click Login button
    Then i should be on login page


  Scenario: Check eye buttons in Password and Confirm password fields
    Given click on Sign up button
    And i am on Sign up page
    When i enter in password field 12345
    And click on eye button
    Then i should see 12345 in Password input field
    And enter in password field 12345
    And click on eye button in Confirm password field
    Then i should see 12345 in Confirm password input field


  Scenario: Verify the following texts is presented
    Given click on Sign up button
    And i am on Sign up page
    Then i should see care for all you care for text


  Scenario: Verify Term and Conditions link is working
    Given click on Sign up button
    And i am on Sign up page
    And click on Term and Conditions link
    Then Term and Conditions document should appear
    And scroll down the page to the bottom
    Then i should see "privacyteam@obtaincare.com" email

  @signup
  Scenario: Verify user can not sign up with less then 8 chars
    Given click on Sign up button
    And i am on Sign up page
    And fill with test data First name, Last name and Email fields
    And enter in password field "Tt1!" in Sign up page
    And enter in Confirm password "Tt1!" in Sign up page
    And click on Accept Terms checkbox
    Then "Password must be at least 8 characters." text should appear





























