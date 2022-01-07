package com.obtaincare.UI.pageObjects;

import com.obtaincare.UI.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgetPasswordPage {

    public ForgetPasswordPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@class='auth-form__title']")
    public WebElement resetYourPasswordText;


}
