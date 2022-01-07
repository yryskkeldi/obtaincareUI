package com.obtaincare.UI.pageObjects;

import com.github.javafaker.Faker;
import com.obtaincare.UI.methods.Helper;
import com.obtaincare.UI.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {

    public SignUpPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[normalize-space()='Sign up as a user']")
    public WebElement signUpAsAUserText;

    @FindBy(xpath = "//input[@id='auth-form-input-first-name']")
    public WebElement firstNameInputField;

    @FindBy(xpath = "//input[@id='auth-form-input-last-name']")
    public WebElement lastNameInputField;

    @FindBy(id = "Email")
    public WebElement emailInputField;

    @FindBy(xpath = "//input[@id='password-input']")
    public WebElement passwordInputField;

    @FindBy(xpath = "//input[@id='ConfirmPassword']")
    public WebElement confirmPasswordInputField;

    @FindBy(xpath = "//button[normalize-space()='Create an account']")
    public WebElement createAnAccountButton;

    @FindBy(xpath = "//label[normalize-space()='Accept Terms']")
    public WebElement acceptTermsCheckBox;

    @FindBy(xpath = "//a[normalize-space()='Terms and Conditions']")
    public WebElement termsAndConditionsLink;

    @FindBy(xpath = "//div[@class='auth-form__checkbox-description']//a[@type='button'][normalize-space()='Privacy Policy']")
    public WebElement privacyPolicyLink;

    @FindBy(xpath = "//a[normalize-space()='Login']")
    public WebElement loginButton;

    @FindBy(xpath = "//label[normalize-space()='First name']")
    public WebElement firstNameText;

    @FindBy(xpath = "//label[normalize-space()='Last name']")
    public WebElement lastNameText;

    @FindBy(xpath = "//label[normalize-space()='Email']")
    public WebElement emailText;

    @FindBy(xpath = "//label[normalize-space()='Password']")
    public WebElement passwordText;

    @FindBy(xpath = "//label[normalize-space()='Confirm password']")
    public WebElement confirmPasswordText;

    @FindBy(xpath = "//div[@class='auth-form__checkbox-description']")
    public WebElement byClickingText;

    @FindBy(xpath = "//span[normalize-space()='The FirstName field is required.']")
    public WebElement firstNameRequiredMText;

    @FindBy(xpath = "//span[normalize-space()='The LastName field is required.']")
    public WebElement lastNameIsRequiredText;

    @FindBy(xpath = "(//span[normalize-space()='The Email field is required.'])[1]")
    public WebElement emailIsRequiredText;

    @FindBy(xpath = "//span[@id='password-validation']")
    public WebElement passwordIsRequiredText;

    @FindBy(xpath = "//span[@class='validation-msg field-validation-error']")
    public WebElement pleaseConfirmYourAgreementText;

    @FindBy(xpath = "//div[4]//span[3]//*[name()='svg']//*[name()='path' and contains(@d,'M1.24989 1')]")
    public WebElement eyeButtonPassword;

    @FindBy(xpath = "//h1[contains(text(),'care for all')]")
    public WebElement careForAllYouCareForText;

    @FindBy(xpath = "//div[5]//span[3]//*[name()='svg']")
    public WebElement eyeConfirmPass;

    @FindBy(xpath = "//div[contains(text(),'Terms and Conditions of Use')]")
    public WebElement termAndConditionsOfUseText;

    @FindBy(xpath = "//div[@class='modal__notice']")
    public WebElement pleaseReadTheseTermsAndConditionsOfUsetext;

    @FindBy(xpath = "//p[contains(text(),'This website is operated by Obtaincare. All feedba')]//a[@href='mailto:privacyteam@obtaincare.com'][normalize-space()='privacyteam@obtaincare.com']")
    public WebElement privacyTeamEmail;

    @FindBy(xpath = "/html/body/div[1]/div[3]/form/div/div[2]/div[6]")
    public WebElement passwordMustBeAtLeast8CharactersText;


    public void fillFirstLastNameAndEmailWithFakeData(){
        Faker faker = new Faker();
        String fakeFirstName = faker.name().firstName();
        String fakeLastName = faker.name().lastName();
        String fakeEmail = faker.internet().emailAddress();
        Helper.sendKeys(firstNameInputField,fakeFirstName);
        Helper.sendKeys(lastNameInputField,fakeLastName);
        Helper.sendKeys(emailInputField,fakeEmail);
    }





}
