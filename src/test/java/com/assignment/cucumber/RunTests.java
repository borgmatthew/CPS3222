package com.assignment.cucumber;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

 
@RunWith(Cucumber.class)
@CucumberOptions(format="pretty", glue = { "StepDefinitions" }, features = { "Resources.feature" }, monochrome = true)
public class RunTests {
}
