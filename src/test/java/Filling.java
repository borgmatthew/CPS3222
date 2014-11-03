import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import SeleniumTesting.PopulateForm;
import SeleniumTesting.PopulateFormImp;

public class Filling {
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
		form.close();
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
	public void InvXtalidxtcvvTest(){
		form.populateCvv("aaa");
		assertEquals("Invalid CVV number",form.findById("cvv_error").get(0).getText());	
		form.visit();
		form.populateEmptyCvv();
		assertEquals("Invalid CVV number",form.findById("cvv_error").get(0).getText());	
		form.visit();
		form.populateCvv("123456");
		assertEquals("Invalid CVV number",form.findById("cvv_error").get(0).getText());	
	}
	
	
}
