package com.obtaincare.UI.methods;

import com.obtaincare.UI.utils.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Helper {

    private static Logger logger = LogManager.getLogger(Helper.class);

    public static void click(WebElement element){
        logger.info("Clicking the " + element);
        waitForElementToBeDisplayed(element);
        waitForElementVisibilityOf(element);
        waitForElementToBeClickable(element);
        highLighterMethod(element);
        element.click();
    }

    public static void multipleClick(WebElement element,int howManyTimes)
    {
        int counter = howManyTimes;
        waitForElementToBeDisplayed(element);
        waitForElementToBeClickable(element);
        while (counter > 0)
        {
            element.click();
            counter--;
        }
    }
    public static void clickWithOutWait(WebElement element){
        element.click();
    }

    public static void waitForElementToBeDisplayed(WebElement element) {
        logger.info("Waiting for element to be displayed " + element);
        new WebDriverWait(Driver.getDriver(), 10)
                .until(ExpectedConditions.visibilityOf(element));
        logger.info("Element is displayed " + element);
    }

    public static void waitForElementToBeClickable(WebElement element) {
        logger.info("Waiting for element to be clickable");
        new WebDriverWait(Driver.getDriver(), 10)
                .until(ExpectedConditions.elementToBeClickable(element));
        logger.info("Element is clickable");
    }

    public static void clearExistingText(WebElement element, String newText) {
        element.clear();
        element.sendKeys(newText);
    }

    public static void pause(Integer milliseconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String getTextValue(WebElement element){
        logger.info("Trying to get text value");
        waitForElementToBeDisplayed(element);
        String text = element.getText();
        return text;
    }


    public static void highLighterMethod( WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
    }


    public static Boolean isDisplayedWithWait(WebElement element)
    {
        waitForElementToBeDisplayed(element);
        Boolean isDisplayed = element.isDisplayed();
        return isDisplayed;
    }

    public static Boolean isSelectedWithWait(WebElement element)
    {
        waitForElementToBeDisplayed(element);
        Boolean isSelected = element.isSelected();
        return  isSelected;
    }
    public static void waitForElementVisibilityOf(WebElement element){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static boolean avoidStaleElementClick(WebElement element) {
        boolean result = false;
        int attempts = 0;
        while(attempts < 2) {
            try {
                Actions actions = new Actions(Driver.getDriver());
                actions.click().perform();
                result = true;
                break;
            } catch(StaleElementReferenceException e) {
            }
            attempts++;
        }
        return result;
    }

    public static void jsClick(WebElement element) {
        waitForElementToBeDisplayed(element);
        waitForElementToBeClickable(element);
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();", element);
    }

    public static void jsScrollDownThePage() {
        JavascriptExecutor jse = (JavascriptExecutor)Driver.getDriver();
        jse.executeScript("window.scrollBy(0,800)");
    }

    public static void clearField(WebElement element) {
        waitForElementToBeDisplayed(element);
        element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        element.sendKeys(Keys.chord(Keys.DELETE));
    }

    public static void navigateToElement( WebElement element){
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element);
        actions.perform();
    }

    public static void jsScrollIntoView(WebElement element){
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);",element );
    }

    public static boolean retryingFindClick(By by) {
        boolean result = false;
        WebDriver driver = Driver.getDriver();
        int attempts = 0;
        while(attempts < 2) {
            try {
                driver.findElement(by).click();
                result = true;
                break;
            } catch(StaleElementReferenceException e) {
            }
            attempts++;
        }
        return result;
    }

    public static void sendKeys(WebElement element,String value){
        element.sendKeys(value);
    }

    // We can press keyboard buttons
    public static void sendKeys(WebElement element,Keys button){
        element.sendKeys(button);
    }

    public static String getAttributeByValue(WebElement element){
        waitForElementToBeDisplayed(element);
        return element.getAttribute("value");
    }

    public static void chooseDate(String date, WebElement calendarValue,
                                  WebElement forwardButton, WebElement backwardButton, WebElement day)
    {
        HashMap<String, String> monthKeeper = new HashMap<String, String>();
        monthKeeper.put("January","01" );monthKeeper.put("February","02");monthKeeper.put("March","03");
        monthKeeper.put("April","04");monthKeeper.put("May","05");monthKeeper.put("June","06");
        monthKeeper.put("July","07");monthKeeper.put("August","08");monthKeeper.put("September","09");
        monthKeeper.put("October","10");monthKeeper.put("November","11");monthKeeper.put("December","12");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "dd MM yyyy" );
        LocalDateTime now = LocalDateTime.now();
        String currentTimeString = formatter.format(now);
        boolean forward = true;

        String[] currentTimeSplitted = currentTimeString.split(" "),
                inputDateSplitted = date.split(" ");

        String neededDate = inputDateSplitted[1] + " " + inputDateSplitted[2];

        if(neededDate.equals(Helper.getTextValue(calendarValue)))
        {  Helper.click(day); }

        LocalDate inputDate = LocalDate.of(Integer.parseInt(inputDateSplitted[2]),
                Integer.parseInt(monthKeeper.get(inputDateSplitted[1])) ,Integer.parseInt(inputDateSplitted[0]));

        LocalDate currentDate = LocalDate.of(Integer.parseInt(currentTimeSplitted[2]),
                Integer.parseInt(currentTimeSplitted[1]), Integer.parseInt(currentTimeSplitted[0]));


        if(currentDate.isAfter(inputDate))
        {forward = false;}

        while(true)
        {
            String actualDate = Helper.getTextValue(calendarValue);
            if(neededDate.equals(actualDate))
            {
                break;
            }
            if(forward) {Helper.click(forwardButton);}
            else {Helper.click(backwardButton);}

        }

        String elementToString = day.toString();
        String path = elementToString.substring(elementToString.indexOf('/'));
        path= path.substring(0, path.length() - 1);
        path = path.replace("date", inputDateSplitted[0]);
        WebDriver driver = Driver.getDriver();

        driver.findElement(By.xpath(path)).click();
    }

    public static Boolean compareDates(String olderDate, String soonerDate)
    {
        String[] firstDateSplitted = olderDate.split("/");
        int year1, month1, day1;
        year1 = Integer.parseInt(firstDateSplitted[2]);
        month1 = Integer.parseInt((firstDateSplitted[0]));
        day1 = Integer.parseInt(firstDateSplitted[1]);

        String[] secondDateSplitted = soonerDate.split("/");
        int year2, month2, day2;
        year2 = Integer.parseInt(secondDateSplitted[2]);
        month2 = Integer.parseInt((secondDateSplitted[0]));
        day2 = Integer.parseInt(secondDateSplitted[1]);

        LocalDate older = LocalDate.of(year1, month1,day1 );
        LocalDate sooner = LocalDate.of(year2, month2, day2);

        return sooner.isAfter(older);
    }

}
