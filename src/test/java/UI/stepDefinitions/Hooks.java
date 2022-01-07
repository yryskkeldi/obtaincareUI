package UI.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import com.obtaincare.UI.utils.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;


public class Hooks {

    private static Logger logger = LogManager.getLogger(Hooks.class);

    @Before
    public void setUp() {
        logger.info("Before hook started");
    }

    @After
    public void tearDown(Scenario scenario) {
        logger.info("After hook started");
        if(scenario.isFailed()) {
            try {
                logger.info("Started to take screenshot");
                byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "screenshot");
            } catch (WebDriverException noSupportScreenshot) {
                logger.error("Screenshot is not take");
                System.err.println(noSupportScreenshot.getMessage());
            }
        }
        Driver.closeDriver();
    }
}
