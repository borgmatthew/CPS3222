package com.assignment.validations;

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
		assertTrue(regval.validateSName("Alastair"));
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
		assertTrue(regval.validateName("Vella"));
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
		assertTrue(regval.validatePassword("Assignment"));
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
		assertTrue(regval.validateDOB("01/08/1991"));
	}
	@Test
	public void testValidateDOBDoesnotacceptletters(){
		//given
		//when
		//then
		assertFalse(regval.validateDOB("a"));
	}
	@Test
	public void testValidateCardletters(){
		//given
		//when
		//then
		assertFalse(regval.validateCard("4568820B41600813"));
	}
	@Test
	public void testValidateCardShortVisaCard(){
		//given
		//when
		//then
		assertFalse(regval.validateCard("456882024160"));
	}
	@Test
	public void testValidateCardLongVisaCard(){
		//given
		//when
		//then
		assertFalse(regval.validateCard("4568820241600813234"));
	}
	@Test
	public void testValidateCardAcceptsAValidVisaCard(){
		//given
		//when
		//then
		assertTrue(regval.validateCard("4568820241600813"));
	}
	
	@Test
	public void testValidateCardInValidVisaCard(){
		//given
		//when
		//then
		assertFalse(regval.validateCard("45688202455600813"));
	}
	@Test
	public void testValidateCardInvalidAmericanCard(){
		//given
		//when
		//then
		assertFalse(regval.validateCard("123456789123456"));
	}
	@Test
	public void testValidateCardAcceptsAValidAmericanCard(){
		//given
		//when
		//then
		assertTrue(regval.validateCard("371449635398431"));
	}
	
	@Test
	public void testValidateCardLongAmericanCard(){
		//given
		//when
		//then
		assertFalse(regval.validateCard("371449635398431234"));
	}
	
	@Test
	public void testValidateCardShortAmericanCard(){
		//given
		//when
		//then
		assertFalse(regval.validateCard("3714496353"));
	}
	
	@Test
	public void testValidateCardAcceptsAValidMasterCard(){
		//given
		//when
		//then
		assertTrue(regval.validateCard("5555555555554444"));
	}
	@Test
	public void testValidateCardAcceptsAShortMasterCard(){
		//given
		//when
		//then
		assertFalse(regval.validateCard("555555555555"));
	}
	@Test
	public void testValidateCardAcceptsALongMasterCard(){
		//given
		//when
		//then
		assertFalse(regval.validateCard("5555555555554444444"));
	}
	
	@Test
	public void testValidateCardAcceptsInvalidMasterCard(){
		//given
		//when
		//then
		assertFalse(regval.validateCard("5555555465554444"));
	}
	@Test
	public void testEXPDateAcceptsvalidDate(){
		//given
		//when
		//then
		assertTrue(regval.validateEXP("01/08/2017"));
	}
	@Test
	public void testEXPDateDoesnotAcceptletters(){
		//given
		//when
		//then
		assertFalse(regval.validateEXP("01/0f/2017"));
	}
	@Test
	public void testEXPDatedoesnotAcceptslettersonly(){
		//given
		//when
		//then
		assertFalse(regval.validateEXP("asdf"));
	}
	@Test
	public void testEXPDateInvalidDate(){
		//given
		//when
		//then
		assertFalse(regval.validateEXP("11/12/2013"));
	}
	@Test
	public void testCvvvalidCvv(){
		//given
		//when
		//then
		assertTrue(regval.validateCvv("123"));
	}
	@Test
	public void testCvvInvalidCvv(){
		//given
		//when
		//then
		assertFalse(regval.validateCvv("1a3"));
	}
	@Test
	public void testCvvLongCvv(){
		//given
		//when
		//then
		assertFalse(regval.validateCvv("123456789"));
	}
}
