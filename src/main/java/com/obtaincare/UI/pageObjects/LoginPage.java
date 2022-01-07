package com.obtaincare.UI.pageObjects;

import com.obtaincare.UI.methods.Helper;
import com.obtaincare.UI.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@class='auth-card__title']")
    public WebElement loginText;

    @FindBy(id = "Username")
    public WebElement emailField;

    @FindBy(id = "Password")
    public WebElement passwordField;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    public WebElement loginButton;

    @FindBy(xpath = "//a[normalize-space()='Forgot your password?']")
    public WebElement forgetYourPasswordLink;

    @FindBy(xpath = "//span[@class='password-eye password-eye--close']//*[name()='svg']")
    public WebElement eyeButton;

    @FindBy(xpath = "//li[normalize-space()='Account not found.']")
    public WebElement accountNotFoundMessage;

    @FindBy(xpath = "//span[normalize-space()='The Email field is required.']")
    public WebElement emailIsRequiredText;

    @FindBy(xpath = "//span[normalize-space()='The Password field is required.']")
    public WebElement passwordIsRequiredText;

    @FindBy(xpath = "//label[normalize-space()='Email']")
    public WebElement emailText;

    @FindBy(xpath = "//label[normalize-space()='Password']")
    public WebElement passwordText;

    @FindBy(xpath = "//a[normalize-space()='Sign up']")
    public WebElement signUpButton;



    public void fillAllFieldsAndClick(String email, String password){
        Helper.sendKeys(emailField,email);
        Helper.sendKeys(passwordField,password);
        Helper.click(loginButton);
    }
}
