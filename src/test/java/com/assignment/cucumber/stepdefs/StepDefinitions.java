package com.assignment.cucumber.stepdefs;

import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.assignment.SeleniumTesting.PopulateBetForm;
import com.assignment.SeleniumTesting.PopulateBetFormImp;
import com.assignment.SeleniumTesting.PopulateForm;
import com.assignment.SeleniumTesting.PopulateFormImp;
import com.assignment.SeleniumTesting.PopulateLoginForm;
import com.assignment.SeleniumTesting.PopulateLoginFormImp;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitions {
	WebDriver browser;
	PopulateForm form;
	PopulateLoginForm logform;
	PopulateBetForm betform;
	
	@Given("^I am a user trying to register$")
	public void i_am_a_user_trying_to_register() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		browser = new FirefoxDriver();
		form=new PopulateFormImp(browser);
		form.visit();
	    //throw new PendingException();
	}


@When("^I register providing correct information$")
public void i_register_providing_correct_information() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	form.populate();
	form.submit("submitButton");
	//throw new PendingException();
}

@Then("^I should be told that the registration was successful$")
public void i_should_be_told_that_the_registration_was_successful() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	assertEquals(form.findById("message").get(0).getText(), "Succesful registration. Please Login.");	
	form.close();
	//throw new PendingException();
}

@When("^I fill in a form with correct data and I change the \"(.*?)\" field to have incorrect input$")
public void i_fill_in_a_form_with_correct_data_and_I_change_the_field_to_have_incorrect_input(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    form.populate();
    form.clear(arg1);
    form.findById(arg1).get(0).sendKeys("6\t \t");
	//throw new PendingException();
}

@Then("^I  should  be  told in \"(.*?)\"  that  the  data  in  \"(.*?)\"  is \"(.*?)\"$")
public void i_should_be_told_in_that_the_data_in_is(String arg1, String arg2, String arg3) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    assertEquals(form.findById(arg1).get(0).getText(),arg3);
    form.close();
	//throw new PendingException();
}


@Given("^I am a user with a free account$")
public void i_am_a_user_with_a_free_account() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	browser = new FirefoxDriver();
	logform=new PopulateLoginFormImp(browser);
	logform.visitLogin();
	logform.populateloginuserName("ali.speed6@gmail.com");
	logform.populateloginpassword("Assignment");
	logform.submit("login_button");
    //throw new PendingException();
}

@When("^I try to place a bet of (\\d+) euros$")
public void i_try_to_place_a_bet_of_euros(int arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
   betform=new PopulateBetFormImp(browser);
   betform.populateammount(arg1+"");
   betform.submit("submitButton");
   
	//throw new PendingException();
}

@Then("^I should be told the bet was successfully placed$")
public void i_should_be_told_the_bet_was_successfully_placed() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	assertEquals(betform.findById("Bett_error").get(0).getText(),"Bet placed successfully");
	betform.close();
    //throw new PendingException();
}
}
