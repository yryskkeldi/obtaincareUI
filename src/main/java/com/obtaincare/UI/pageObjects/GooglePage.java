package com.obtaincare.UI.pageObjects;

import com.obtaincare.UI.utils.Driver;
import com.obtaincare.UI.methods.Helper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePage {


    public GooglePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "identifierId")
    public WebElement emailInputField;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/div/button/span")
    public WebElement nextEmailButton;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div[1]/div/div/div/div/div[1]/div/div[1]/input")
    public WebElement passwordField;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/div/button/span")
    public WebElement nextPasswordButton;

    public void enterEmailAndClickNextButton(){
        Helper.pause(7000);

        Helper.sendKeys(emailInputField,"nursultan.musakunov@obtaincare.com");
        Helper.click(nextEmailButton);
        Helper.pause(3000);
    }

    public void enterPasswordAndClickNextButton(){
        Helper.sendKeys(passwordField,"HelloWorld312!");
        Helper.click(nextPasswordButton);
    }

}
