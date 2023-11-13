package com.kwi.base;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.kwi"},
        plugin = {"pretty",
                "html:target/cucumberReport/cucumberReport.html",
                "json:target/cucumberReport/cucumberReport.json"},
//        dryRun = true,
//        tags = "@",
        monochrome = true)

public class TestsRunner {
}
