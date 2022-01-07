package com.obtaincare.UI.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class EdgeWebDriver {



    public static WebDriver loadEdgeDriver(){

        WebDriver driver;
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));

        return driver;

    }
}
