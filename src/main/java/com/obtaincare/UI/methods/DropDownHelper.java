package com.obtaincare.UI.methods;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.LinkedList;
import java.util.List;

public class DropDownHelper {

    public static void selectUsingVisibleText(WebElement element,String visibleValue) {
        Select select = new Select(element);
        select.selectByVisibleText(visibleValue);
    }
    public static String getSelectedValue(WebElement element) {
        String value = new Select(element).getFirstSelectedOption().getText();
        return value;
    }
    public static void selectUsingIndex(WebElement element,int index) {
        Select select = new Select(element);
        select.selectByIndex(index);
    }
    public static List<String> getAllDropDownValues(WebElement locator) {
        Select select = new Select(locator);
        List<WebElement> elementList = select.getOptions();
        List<String> valueList = new LinkedList<String>();
        for (WebElement element : elementList) {
            valueList.add(element.getText());
        }
        return valueList;
    }
}
