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
	public void testValidateSNameDoesNotAcceptNumbers() {
		//given
		//when
		//then
		assertFalse(regval.validateSName("56"));
	}

	@Test
	public void testValidateSNameDoesNotAcceptSpecialCharacters() {
		//given
		//when
		//then
		assertFalse(regval.validateSName("!'%"));
	}
	
	@Test
	public void testValidateSNameAcceptsWhitespace() {
		//given
		//when
		//then
		assertTrue(regval.validateSName("\t "));
	}
	
	@Test
	public void testValidateSNameDoesNotAcceptNumbersWithCharacters(){
		//given
		//when
		//then
		assertFalse(regval.validateSName("mat6"));
	}

	@Test
	public void testValidateSNameAcceptsCharacters(){
		//given
		//when
		//then
		assertTrue(regval.validateSName("test"));
	}
	
	@Test
	public void testValidateSNameAcceptsUppercaseCharacters(){
		//given
		//when
		//then
		assertTrue(regval.validateSName("TEST"));
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
	
	@Test
	public void testValidatePasswordDoesNotAcceptSmallerThanEight(){
		//given
		//when
		//then
		assertFalse(regval.validatePassword("TEST"));
	}
	@Test
	public void testValidatePasswordAcceptsAValidPassword(){
		//given
		//when
		//then
		assertTrue(regval.validatePassword("TEST123456"));
	}
	
	@Test
	public void testValidateDobUnderAge(){
		//given
		//when
		//then
		assertFalse(regval.validateDOB("11/12/2003"));
	}
	@Test
	public void testValidateDOBAcceptsAValidAge(){
		//given
		//when
		//then
		assertTrue(regval.validatePassword("11/13/1991"));
	}
	
	@Test
	public void testValidateCardAcceptsAValidCard(){
		//given
		//when
		//then
		assertTrue(regval.validateCard("4568820241600813"));
	}
}
