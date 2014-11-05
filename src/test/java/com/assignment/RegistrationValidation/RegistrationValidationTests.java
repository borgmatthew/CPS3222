package com.assignment.RegistrationValidation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.assignment.validations.RegistrationValidation;
import com.assignment.validations.RegistrationValidationImp;

public class RegistrationValidationTests {

	RegistrationValidation regval;
	
	@Before
	public void setUp(){
		regval=new RegistrationValidationImp();
	}

	@Test
	public void testValidateNameDoesNotAcceptNumbers() {
		//given
		//when
		//then
		assertFalse(regval.validateName("56"));
	}

	@Test
	public void testValidateNameDoesNotAcceptSpecialCharacters() {
		//given
		//when
		//then
		assertFalse(regval.validateName("!'%"));
	}
	
	@Test
	public void testValidateNameAcceptsWhitespace() {
		//given
		//when
		//then
		assertTrue(regval.validateName("\t "));
	}
	
	@Test
	public void testValidateNameDoesNotAcceptNumbersWithCharacters(){
		//given
		//when
		//then
		assertFalse(regval.validateName("mat6"));
	}

	@Test
	public void testValidateNameAcceptsCharacters(){
		//given
		//when
		//then
		assertTrue(regval.validateName("test"));
	}
	
	@Test
	public void testValidateNameAcceptsUppercaseCharacters(){
		//given
		//when
		//then
		assertTrue(regval.validateName("TEST"));
	}
}
