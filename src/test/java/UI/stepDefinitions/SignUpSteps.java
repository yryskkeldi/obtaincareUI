package UI.stepDefinitions;

import com.github.javafaker.Faker;
import com.obtaincare.UI.methods.CustomAssertions;
import com.obtaincare.UI.methods.Helper;
import com.obtaincare.UI.pageObjects.LoginPage;
import com.obtaincare.UI.pageObjects.SignUpPage;
import com.obtaincare.UI.utils.Driver;
import com.obtaincare.UI.pageObjects.GooglePage;
import com.obtaincare.UI.pageObjects.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class SignUpSteps {

    WebDriver driver = Driver.getDriver();
    HomePage homePage = new HomePage();
    GooglePage googlePage = new GooglePage();
    CustomAssertions customAssertions = new CustomAssertions();
    SignUpPage signUpPage = new SignUpPage();
    Faker faker = new Faker();
    LoginPage loginPage = new LoginPage();



    @Given("user is on {string}")
    public void userIsOn(String devEnv) {
        driver.get(devEnv);
    }

    @And("enter in email field {string}")
    public void enterInEmailField(String email) {
        googlePage.enterEmailAndClickNextButton();
    }

    @Then("enter in password field {string}")
    public void enterInPasswordField(String password) {
        googlePage.enterPasswordAndClickNextButton();
    }

    @Given("click on Sign up button")
    public void click_on_sign_up_button() throws InterruptedException {
        homePage.noLetMeUpdateIt();
        homePage.clickSignUp();

    }

    @Given("i am on Sign up page")
    public void i_am_on_sign_up_page() {
        String expectedText = "Sign up as a user";
        customAssertions.assertText(expectedText, signUpPage.signUpAsAUserText, expectedText);
    }

    @Given("enter in First name field test data")
    public void enter_in_first_name_field_test_data() {
        String firstName = faker.name().firstName();
        Helper.sendKeys(signUpPage.firstNameInputField, firstName);
    }

    @Given("enter in Last name field test data")
    public void enter_in_last_name_field_test_data() {
        String lastName = faker.name().lastName();
        Helper.sendKeys(signUpPage.lastNameInputField, lastName);
    }

    @Given("enter in Email field test data")
    public void enter_in_email_field_test_data() {
        String email = faker.internet().emailAddress();
        Helper.sendKeys(signUpPage.emailInputField, email);
    }

    @Given("enter in Password field {string}")
    public void enter_in_password_field(String password) {
        Helper.sendKeys(signUpPage.passwordInputField, password);
    }

    @Given("enter in Confirm password field {string}")
    public void enter_in_confirm_password_field(String password) {
        Helper.sendKeys(signUpPage.confirmPasswordInputField, password);
    }

    @Given("click on Accept Terms checkbox")
    public void click_on_accept_terms_checkbox() {
        Helper.click(signUpPage.acceptTermsCheckBox);
    }

    @Given("click on Create an account button")
    public void click_on_create_an_account_button() {
        Helper.click(signUpPage.createAnAccountButton);
    }

    @Then("i should see {string} message")
    public void i_should_see_message(String expectedText) {
        String expectMessage = "We have sent you a verification email.\n" +
                "Please check your inbox.";
        WebElement ex = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]"));
        customAssertions.assertText(expectMessage, ex, "Text");
    }

    // Verify sign up page have following fields and texts
    @Given("First name field text should be {string}")
    public void first_name_field_text_should_be(String expectedText) {
        customAssertions.assertText(expectedText, signUpPage.firstNameText, expectedText);
    }

    @Given("last name field text should be {string}")
    public void last_name_field_text_should_be(String expectedText) {
        customAssertions.assertText(expectedText, signUpPage.lastNameText, expectedText);
    }

    @Given("Email field text should be {string}")
    public void email_field_text_should_be(String expectedText) {
        customAssertions.assertText(expectedText, signUpPage.emailText, expectedText);
    }

    @Given("Password field text should be {string}")
    public void password_field_text_should_be(String expectedText) {
        customAssertions.assertText(expectedText, signUpPage.passwordText, expectedText);
    }

    @Given("Confirm password field text should be {string}")
    public void confirm_password_field_text_should_be(String expectedText) {
        customAssertions.assertText(expectedText, signUpPage.confirmPasswordText, expectedText);
    }

    //Mandatory fields error message
    @When("i click on Create an account button")
    public void i_click_on_create_an_account_button() {
        Helper.click(signUpPage.createAnAccountButton);
    }

    @Then("{string} message should appear under the First name field")
    public void message_should_appear_under_the_first_name_field(String expectedText) {
        customAssertions.assertText(expectedText, signUpPage.firstNameRequiredMText, expectedText);
    }

    @Then("{string} message should appear under the Last name field")
    public void message_should_appear_under_the_last_name_field(String expectedText) {
        customAssertions.assertText(expectedText, signUpPage.lastNameIsRequiredText, expectedText);
    }

    @Then("{string} message should appear under the Email field")
    public void message_should_appear_under_the_email_field(String expectedText) {
        customAssertions.assertText(expectedText, signUpPage.emailIsRequiredText, expectedText);
    }

    @Then("{string} message should appear under Password field")
    public void message_should_appear_under_password_field(String expectedText) {
        customAssertions.assertText(expectedText, signUpPage.passwordIsRequiredText, expectedText);
    }

    @Then("{string} message should appear under Accept Terms checkbox")
    public void message_should_appear_under_accept_terms_checkbox(String expectedText) {
        customAssertions.assertText(expectedText, signUpPage.pleaseConfirmYourAgreementText, expectedText);
    }

    // Check Login button
    @Given("verify Login button is displayed")
    public void verify_login_button_is_displayed() {
        Assertions.assertTrue(signUpPage.loginButton.isDisplayed());
    }

    @When("i click Login button")
    public void i_click_login_button() {
        Helper.click(signUpPage.loginButton);
    }

    @Then("i should be on login page")
    public void i_should_be_on_login_page() {
        customAssertions.assertText("Login", loginPage.loginText, "Login");
    }

    @When("i enter in password field {int}")
    public void i_enter_in_password_field(Integer password) {
        Helper.sendKeys(signUpPage.passwordInputField,password.toString());
    }

    @When("click on eye button")
    public void click_on_eye_button() {
        Helper.click(signUpPage.eyeButtonPassword);
    }

    @Then("i should see {int} in Password input field")
    public void i_should_see_in_password_input_field(Integer password) {
        Assertions.assertEquals(password.toString(),signUpPage.passwordInputField.getAttribute("value"));
    }

    @Then("enter in password field {int}")
    public void enter_in_password_field(Integer pass) {
        Helper.sendKeys(signUpPage.confirmPasswordInputField,pass.toString());
    }

    @Then("click on eye button in Confirm password field")
    public void click_on_eye_button_in_confirm_password_field() {
        Helper.click(signUpPage.eyeConfirmPass);
    }

    @Then("i should see {int} in Confirm password input field")
    public void i_should_see_in_confirm_password_input_field(Integer pass) {
        Assertions.assertEquals(pass.toString(),signUpPage.confirmPasswordInputField.getAttribute("value"));
    }

    @Then("i should see care for all you care for text")
    public void iShouldSeeCareForAllYouCareForText() {
        final String expectedText = "CARE FOR ALL\n" +
                "YOU CARE FOR";

        customAssertions.assertText(expectedText,signUpPage.careForAllYouCareForText,expectedText);
    }


    @And("click on Term and Conditions link")
    public void clickOnTermAndConditionsLink() {
        Helper.click(signUpPage.termsAndConditionsLink);
    }

    @Then("Term and Conditions document should appear")
    public void termAndConditionsDocumentShouldAppear() {
        final String expectedText = "Terms and Conditions of Use";
        customAssertions.assertText(expectedText,signUpPage.termAndConditionsOfUseText,expectedText);
    }

    @And("scroll down the page to the bottom")
    public void scrollDownThePageToTheBottom() {
        Helper.jsScrollIntoView(signUpPage.privacyTeamEmail);
    }

    @Then("i should see {string} email")
    public void iShouldSeeEmail(String email) {
        customAssertions.assertText(email,signUpPage.privacyTeamEmail,email);
    }

    @Given("fill with test data First name, Last name and Email fields")
    public void fill_with_test_data_first_name_last_name_and_email_fields() {
     signUpPage.fillFirstLastNameAndEmailWithFakeData();
    }
    @Given("enter in password field {string} in Sign up page")
    public void enter_in_password_field_in_sign_up_page(String password) {
    Helper.sendKeys(signUpPage.passwordInputField,password);
    }
    @Given("enter in Confirm password {string} in Sign up page")
    public void enter_in_confirm_password_in_sign_up_page(String password) {
    Helper.sendKeys(signUpPage.confirmPasswordInputField,password);
    }
    @Then("{string} text should appear")
    public void text_should_appear(String expectedText) {
     //   System.out.println(Helper.getTextValue(signUpPage.passwordMustBeAtLeast8CharactersText));
        System.out.println(signUpPage.passwordMustBeAtLeast8CharactersText.getText());
      customAssertions.assertText(expectedText,signUpPage.passwordMustBeAtLeast8CharactersText,expectedText);
    }

}
