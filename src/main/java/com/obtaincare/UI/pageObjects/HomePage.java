package com.obtaincare.UI.pageObjects;

import com.obtaincare.UI.utils.Driver;
import com.obtaincare.UI.methods.Helper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    final String ZIPCODE = "60047";

    public HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@data-user-auth='false']//a[2]")
    public WebElement signUpButton;


    public void clickSignUp(){
        Helper.click(signUpButton);
    }

    @FindBy(xpath = "/html/body/reach-portal/div[3]/div/div/div/div/div[2]/button[2]")
    public WebElement noLetMeUpdateItButton;

    @FindBy(xpath = "/html/body/reach-portal/div[3]/div/div/div/input")
    public WebElement zipCodeInputField;

    @FindBy(xpath = "/html/body/reach-portal/div[3]/div/div/div/div[5]/button[1]")
    public WebElement saveButton;

    @FindBy(xpath = "/html/body/reach-portal/div[3]/div/div/div/div/div[2]/button[1]")
    public WebElement yesButton;

    @FindBy(xpath = "//div[@data-user-auth='false']//a[@class='btn oc-btn-additional'][normalize-space()='Log In']")
    public WebElement loginButton;

    public void clickLoginButton(){
        Helper.click(loginButton);
    }

    public void noLetMeUpdateIt()  {
      Helper.click(yesButton);
    }



}
