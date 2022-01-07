package com.obtaincare.UI.utils;

import com.obtaincare.UI.dataProviders.ConfigReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import java.time.Duration;



public class Driver {

    private static Logger logger = LogManager.getLogger(Driver.class);


    private Driver() {
    }

    private static WebDriver driver;
    public static WebDriver getDriver() {
        if (driver == null) { // chrome
            switch (ConfigReader.getProperty("browser").toLowerCase()) {
                default:
                    logger.warn("Starting Chromedriver");
                    driver = ChromeWebDriver.loadChromeDriver();
                    logger.info("Chrome driver started successfully");
                    break;
                case "firefox":
                    driver = FirefoxWebDriver.loadFirefoxDriver();
                    break;
                case "safari":
                    driver = new SafariDriver();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
                    break;
                case "edge":
                    driver = EdgeWebDriver.loadEdgeDriver();
                    break;
            }
        }
        return driver;
    }

    public static void closeDriver() {
        try {
            if (driver != null) {
                driver.close();
                driver.quit();
                driver = null;
                logger.info("Driver is closed");
            }
        } catch (Exception e) {
            logger.error("Driver is not closed");
            e.printStackTrace();
        }
    }
}