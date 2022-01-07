package UI.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepDefinitions",
        tags = "@",
        monochrome = true,
        dryRun = false,
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "timeline:target/test-output-thread/"
        },
        publish = true
)
public class RegressionRunner {

}
