package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features ="src/test/resources/features/",
		glue= {"stepDefinations"},
		plugin = {"pretty","json:target/cucumber-reports/Cucumber.json",
				 "junit:target/cucumber-reports/Cucumber.xml",
				 "html:target/cucumber-reports"},
		tags= {"@test1"},
		monochrome=true
		)



public class TestRunner {
	

}
