package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features", 
    plugin = { "json:target/jsonReports/cucumber-report.json"}, 
    tags = "not @ignore",
    glue = { "stepDefinitions" })
public class TestRunner {
    
}