package com.assignment.SeleniumTesting;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.assignment.SeleniumTesting.PopulateForm;
import com.assignment.SeleniumTesting.PopulateFormImp;

public class RegistrationFormTest {
	WebDriver browser;
	PopulateForm form;
	@Before
	public void setUp() throws Exception {
		browser = new FirefoxDriver();
		form=new PopulateFormImp(browser);
		form.visit();
	}

	@After
	public void tearDown() throws Exception {
		//form.close();
	}

	@Test
	public void validFormtest() {
		
		form.populate();
		assertTrue(form.findById("parag").size()>0);
		
	}
	@Test
	public void InvalidNameTest(){
		form.populateName("6");
		assertEquals("Invalid characters",form.findById("name_error").get(0).getText());
		form.visit();
		form.populateEmptyName();
		assertEquals("Invalid characters",form.findById("name_error").get(0).getText());
	}
	@Test
	public void InvalidSNameTest(){
		form.populateSName("6");
		assertEquals("Invalid characters",form.findById("surname_error").get(0).getText());
		form.visit();
		form.populateEmptySName();
		assertEquals("Invalid characters",form.findById("surname_error").get(0).getText());
	}
	@Test
	public void InvalidPasswordTest(){
		form.populatePassword("6");
		assertEquals("Password is too short",form.findById("password_error").get(0).getText());
	}
	@Test
	public void InvalidDOBTest(){
		form.populateDOB("11/12/2013");
		assertEquals("Under age",form.findById("dob_error").get(0).getText());
		form.visit();
		form.populateEmptyDOB();
		assertEquals("Please enter date of birth",form.findById("dob_error").get(0).getText());
		form.visit();
		form.populateDOB("aaaa");
		assertEquals("Please enter date of birth",form.findById("dob_error").get(0).getText());
	}
	
	@Test
	public void InvalidcardTest(){
		form.populateCard("4568820251600813");
		assertEquals("Invalid card",form.findById("creditcard_error").get(0).getText());
		form.visit();
		form.populateEmptyCard();
		assertEquals("Invalid card",form.findById("creditcard_error").get(0).getText());
	}
	
	@Test
	public void InvalidexpiryTest(){
		form.populateExpDate("11/12/2013");
		assertEquals("Invalid Expirary date",form.findById("expiry_error").get(0).getText());	
		form.visit();
		form.populateExpDate("aaaa");
		assertEquals("Invalid Expirary date",form.findById("expiry_error").get(0).getText());	
	}
	
	@Test
	public void InvalidxtcvvTest(){
		form.populateCvv("aaa");
		assertEquals("Invalid CVV number",form.findById("cvv_error").get(0).getText());	
		form.visit();
		form.populateEmptyCvv();
		assertEquals("Invalid CVV number",form.findById("cvv_error").get(0).getText());	
		form.visit();
		form.populateCvv("123456");
		assertEquals("Invalid CVV number",form.findById("cvv_error").get(0).getText());	
	}
	
	@Test
	public void invalidFormTest(){
		form.submitForm();
		List<WebElement> errors=form.findByClass("status");
		assertEquals("Invalid characters",errors.get(0).getText());
		assertEquals("Invalid characters",errors.get(1).getText());
		assertEquals("Password is too short",errors.get(2).getText());
		assertEquals("Please enter date of birth",errors.get(3).getText());
		//System.out.print(errors.size());
		
		assertEquals("Invalid card",errors.get(5).getText());
		assertEquals("Invalid Expirary date",errors.get(6).getText());
		assertEquals("Invalid CVV number",errors.get(7).getText());
	}
	
	
}
