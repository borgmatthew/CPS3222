package com.assignment.cucumber;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

 
@RunWith(Cucumber.class)
@CucumberOptions(plugin={"pretty"},glue = { "com.assignment.cucumber.stepdefs" }, features = { "src/test/resources/features" }, monochrome = true)
public class RunTests {
}
