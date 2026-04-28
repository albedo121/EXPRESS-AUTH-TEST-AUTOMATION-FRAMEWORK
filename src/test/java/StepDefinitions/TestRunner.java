package StepDefinitions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
        glue = {"StepDefinitions"},
        monochrome = true,
        plugin = {"pretty","html:target/Reports/Html_report.html", "json:target/Reports/Json_report.json", "junit:target/Reports/Junit_report.xml"},
        tags = "@test")
public class TestRunner {
}
