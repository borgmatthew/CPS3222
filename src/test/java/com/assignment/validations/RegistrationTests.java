package com.assignment.validations;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.assignment.functionalities.Registration;
import com.assignment.functionalities.RegistrationImp;

public class RegistrationTests {
	Registration reg;
	@Before
	public void setUp() throws Exception {
		reg=new RegistrationImp();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void CorrectFieldsTest() {
		String name="Alastair";
		String sname="Vella";
		String username="alx.speed6@gmail.com";
		String password="Assignmentpass";
		String dob="11/12/1991";
		String type="free";
		String card="378282246310005";
		String exp="11/12/2017";
		String cvv="123";
		assertTrue(reg.validateForm(name, sname, username, password, dob, type, card, exp, cvv));
	}
	
	@Test
	public void TestingValidateFormWithIncorrectNameFieldTest() {
		String name="Alast5air";
		String sname="Vella";
		String username="alx.speed6@gmail.com";
		String password="Assignmentpass";
		String dob="11/12/1991";
		String type="free";
		String card="378282246310005";
		String exp="11/12/2017";
		String cvv="123";
		assertFalse(reg.validateForm(name, sname, username, password, dob, type, card, exp, cvv));
	}
	@Test
	public void TestingValidateFormWithIncorrectSNameFieldTest() {
		String name="Alastair";
		String sname="Vel4la";
		String username="alx.speed6@gmail.com";
		String password="Assignmentpass";
		String dob="11/12/1991";
		String type="free";
		String card="378282246310005";
		String exp="11/12/2017";
		String cvv="123";
		assertFalse(reg.validateForm(name, sname, username, password, dob, type, card, exp, cvv));
	}
	@Test
	public void TestingValidateFormWithIncorrectUserNameFieldTest() {
		String name="Alastair";
		String sname="Vella";
		String username="ali.speed6@gmail.com";
		String password="Assignmentpass";
		String dob="11/12/1991";
		String type="free";
		String card="378282246310005";
		String exp="11/12/2017";
		String cvv="123";
		assertFalse(reg.validateForm(name, sname, username, password, dob, type, card, exp, cvv));
	}
	@Test
	public void TestingValidateFormWithIncorrectPasswordFieldTest() {
		String name="Alastair";
		String sname="Vella";
		String username="alx.speed6@gmail.com";
		String password="As";
		String dob="11/12/1991";
		String type="free";
		String card="378282246310005";
		String exp="11/12/2017";
		String cvv="123";
		assertFalse(reg.validateForm(name, sname, username, password, dob, type, card, exp, cvv));
	}
	@Test
	public void TestingValidateFormWithIncorrectDobFieldTest() {
		String name="Alastair";
		String sname="Vella";
		String username="alr.speed6@gmail.com";
		String password="Assignmentpass";
		String dob="11/12/1999";
		String type="free";
		String card="378282246310005";
		String exp="11/12/2017";
		String cvv="123";
		assertFalse(reg.validateForm(name, sname, username, password, dob, type, card, exp, cvv));
	}
	@Test
	public void TestingValidateFormWithIncorrectCardFieldTest() {
		String name="Alastair";
		String sname="Vella";
		String username="alx.speed6@gmail.com";
		String password="Assignmentpass";
		String dob="11/12/1991";
		String type="free";
		String card="308282246310005";
		String exp="11/12/2017";
		String cvv="123";
		assertFalse(reg.validateForm(name, sname, username, password, dob, type, card, exp, cvv));
	}
	@Test
	public void TestingValidateFormWithIncorrectExpiryFieldTest() {
		String name="Alastair";
		String sname="Vella";
		String username="alx.speed6@gmail.com";
		String password="Assignmentpass";
		String dob="11/12/1991";
		String type="free";
		String card="378282246310005";
		String exp="11/12/2013";
		String cvv="123";
		assertFalse(reg.validateForm(name, sname, username, password, dob, type, card, exp, cvv));
	}
	@Test
	public void TestingValidateFormWithIncorrectCvvFieldTest() {
		String name="Alastair";
		String sname="Vella";
		String username="alx.speed6@gmail.com";
		String password="Assignmentpass";
		String dob="11/12/1991";
		String type="free";
		String card="378282246310005";
		String exp="11/12/2017";
		String cvv="12";
		assertFalse(reg.validateForm(name, sname, username, password, dob, type, card, exp, cvv));
	}
	
	@Test
	public void getMessageTest() {
		String name="Alas5air";
		String sname="Vella";
		String username="alx.speed6@gmail.com";
		String password="Assignmentpass";
		String dob="11/12/1991";
		String type="free";
		String card="378282246310005";
		String exp="11/12/2017";
		String cvv="123";
		reg.validateForm(name, sname, username, password, dob, type, card, exp, cvv);
		assertEquals("Invalid name",reg.getMessage());
	}

}
