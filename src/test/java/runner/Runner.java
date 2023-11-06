package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty",
                "json:target/cucumber.json",
                "utilities.formatter.PrettyReports:target/cucumber-pretty-reports",
                "io.qameta.allure.cucumber6jvm.AllureCucumber7Jvm"
        },
        features = "src/test/resources/features",
        glue = {"stepDefinitions","runner"},
        tags = "@firstTest",
        dryRun = false
)
public class Runner {
}
