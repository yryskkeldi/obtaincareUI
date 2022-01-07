package UI.stepDefinitions;

import com.obtaincare.UI.methods.CustomAssertions;
import com.obtaincare.UI.methods.Helper;
import com.obtaincare.UI.pageObjects.ForgetPasswordPage;
import com.obtaincare.UI.pageObjects.HomePage;
import com.obtaincare.UI.pageObjects.LoginPage;
import com.obtaincare.UI.pageObjects.SignUpPage;
import com.obtaincare.UI.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;



public class LoginSteps {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    CustomAssertions customAssertions = new CustomAssertions();
    ForgetPasswordPage forgetPasswordPage = new ForgetPasswordPage();
    SignUpPage signUpPage = new SignUpPage();


    @Given("click Login button")
    public void click_login_button() {
        homePage.noLetMeUpdateIt();
        homePage.clickLoginButton();
    }
    @Given("Enter in email field {string}")
    public void enter_in_email_field(String email) {
        Helper.sendKeys(loginPage.emailField,email);
    }
    @Given("Enter in Password field {string}")
    public void enter_in_password_field(String password) {
        Helper.sendKeys(loginPage.passwordField,password);
    }
    @Then("click on Login button")
    public void click_on_login_button() {
        Helper.click(loginPage.loginButton);
    }
    @Then("i should successfully login")
    public void i_should_successfully_login() {
        final String expectedURL = "https://obtaincare.site/";
        Helper.pause(5000);
        Assertions.assertEquals(expectedURL, Driver.getDriver().getCurrentUrl());
    }

    @Then("i should see error {string}")
    public void iShouldSeeError(String errorMessage) {
        customAssertions.assertText(errorMessage,loginPage.accountNotFoundMessage,errorMessage);

    }

    
    @Given("click on Login button in login page")
    public void click_on_login_button_in_login_page() {
        Helper.click(loginPage.loginButton);
    }

    @Then("under email field {string} message should appear")
    public void under_email_field_message_should_appear(String expectedText) {
        customAssertions.assertText(expectedText,loginPage.emailIsRequiredText,expectedText);

    }

    @Then("under Password field {string} message should appear")
    public void under_password_field_message_should_appear(String expectedText) {
        customAssertions.assertText(expectedText,loginPage.passwordIsRequiredText,expectedText);

    }

    @Given("on password field enter {string}")
    public void on_password_field_enter(String password) {
        Helper.sendKeys(loginPage.passwordField, password);
    }

    @Given("click on eye button in password field")
    public void click_on_eye_button_in_password_field() {
        Helper.click(loginPage.eyeButton);
        Helper.pause(4000);
    }

    @Then("i should see {string} in password field")
    public void i_should_see_in_password_field(String password) {
        WebElement passwordField = Driver.getDriver().findElement(By.xpath("//input[@id='Password']"));
        System.out.println(passwordField.getAttribute("value") + " sdadasd");
        Assertions.assertEquals(password,passwordField.getAttribute("value"));
    }


    @Given("link text should be {string}")
    public void link_text_should_be(String expectedText) {
        customAssertions.assertText(expectedText,loginPage.forgetYourPasswordLink,expectedText);

    }
    @Given("click on link")
    public void click_on_link() {
        Helper.click(loginPage.forgetYourPasswordLink);
    }
    @Then("i should be in {string}")
    public void i_should_be_in(String expectedURL) {
        Helper.waitForElementVisibilityOf(forgetPasswordPage.resetYourPasswordText);
        Assertions.assertEquals(expectedURL,Driver.getDriver().getCurrentUrl());

    }


    @Given("verify {string} text is displayed")
    public void verify_text_is_displayed(String expectedText) {
        customAssertions.assertText(expectedText,loginPage.loginText,expectedText);

    }
    @Given("verify {string} text is displayed in Email field")
    public void verify_text_is_displayed_in_email_field(String expectedText) {
        customAssertions.assertText(expectedText,loginPage.emailText,expectedText);

    }
    @Given("verify {string} text is displayed in Password field")
    public void verify_text_is_displayed_in_password_field(String expectedText) {
        customAssertions.assertText(expectedText,loginPage.passwordText,expectedText);

    }

    @Given("click on Sign up button in login page")
    public void click_on_sign_up_button_in_login_page() {
        Helper.click(loginPage.signUpButton);
    }
    @Then("i am in Sign up page {string}")
    public void i_am_in_sign_up_page(String expectedText) {
        customAssertions.assertText(expectedText,signUpPage.signUpAsAUserText,expectedText);


    }




}
