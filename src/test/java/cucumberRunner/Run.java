package cucumberRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/main/java/FeatureFiles"},
        tags = "@test"//directory name
        , glue = {"StepDefinition"},
        plugin = {"pretty", "html:target/cucumber-report.html"}//pack name

)
public class Run extends AbstractTestNGCucumberTests{}

