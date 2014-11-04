package Runner;


import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;

 
@RunWith(Cucumber.class)
@Cucumber.Options(format="pretty", glue = { "Stepdefs" }, features = { "src/test/java/resources/features" }, monochrome = true)
public class RunTests {
}
