package UI.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "UI/stepDefinitions",
        tags = "@signup",
        monochrome = true,
        dryRun = false,
        plugin = {
                "pretty",
                "html:target/default-cucumber-reports",
                "json:target/cucumber.json"

    },
        publish = true
)
public class SmokeRunner {

}
