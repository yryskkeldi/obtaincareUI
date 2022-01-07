package com.obtaincare.UI.methods;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import java.io.IOException;

public class CustomAssertions {


    ScreenShotMethods screenShotMethods = new ScreenShotMethods();


    public void assertText(String expectedText, WebElement actualElement,String asMessage){
        Helper.waitForElementVisibilityOf(actualElement);
        Assertions.assertEquals(expectedText, Helper.getTextValue(actualElement),"Comparing: " + asMessage);
        if (!Helper.getTextValue(actualElement).equals(expectedText)){
            try {
                screenShotMethods.takeScreenShot();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}
