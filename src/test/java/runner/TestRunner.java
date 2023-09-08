package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@Test
@CucumberOptions(features = "src/test/java/features/",
        glue = {"stepDefinitions"},
        plugin = {"pretty", "html:target/HTML-Report.html", "json:target/cucumber.json"},
        dryRun = false,
        monochrome = true,
        publish =true)
public class TestRunner extends AbstractTestNGCucumberTests {

}