package com.assignment.cucumber;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

 
@RunWith(Cucumber.class)
@CucumberOptions(glue = { "src.test.java.com.assignment.cucumber" }, features = { "src/test/resources/features" }, monochrome = true)
public class RunTests {
}
