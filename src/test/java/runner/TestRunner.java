package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/features",
		glue={"stepDefinitions","hooks"},
		plugin={"pretty","html:target/CucumberReports/Reports/reports.html"},
		publish=true
)
public class TestRunner {
	
	

}
