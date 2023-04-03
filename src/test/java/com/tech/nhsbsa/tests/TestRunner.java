package com.tech.nhsbsa.tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = {"classpath:features/getHelpWithPaying.feature"},
        glue = {"com.tech.nhsbsa.stepdefinitions"},
        plugin = {"json:target/cucumber-report.json", "html:target/cucumber-html.html"})
public class TestRunner extends AbstractTestNGCucumberTests {
}
