package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	    features = "src/test/resources/features",
	    glue = {"stepdefs", "hooks"}, // include your hooks package
	    plugin = {
	        "pretty",
	        "html:target/cucumber-report.html",
	        "json:target/cucumber.json"
	    },
	    monochrome = true
	)
public class TestRunner {

}
