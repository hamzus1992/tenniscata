package com.cata.tennis.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = "com.cata.tennis.cucumber",
    plugin = {"pretty", "json:target/cucumber.json", "html:target/cucumber-reports.html"},
    monochrome = true
)
public class CucumberTestRunner {
}
