package com.assignment.validations;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.assignment.DBObjects.Bet;

public class BettingValidationsImpTest {

	private BettingValidations validation;

	@Before
	public void setUp() throws Exception {
		validation = new BettingValidationsImp();
	}

	@Test
	public void testValidateRiskFreeUserNotLow() {
		// given
		// when
		// then
		assertFalse(validation.validateRiskFree("Medium"));
	}

	@Test
	public void testValidateRiskFreeUserLowRisk() {
		// given
		// when
		// then
		assertTrue(validation.validateRiskFree("Low"));
	}
	
	@Test
	public void testValidateBetLimitFreeUserLessThanThreeBets() {
		// given
		List<Bet> bets = new ArrayList<Bet>();
		// when
		// then
		assertTrue(validation.validateBetLimitNumberFree(bets));
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testValidateBetLimitFreeUserHasThreeBets() {
		// given
		List bets = mock(List.class);
		doReturn(3).when(bets).size();
		// when
		// then
		assertFalse(validation.validateBetLimitNumberFree(bets));
	}
	
	@Test
	public void testValidateAmountFreeUserNegativeBet() {
		// given
		// when
		// then
		assertFalse(validation.validateAmountLimitsFree(-1.0));
	}
	
	@Test
	public void testValidateAmountFreeUserInRangeBet() {
		// given
		// when
		// then
		assertTrue(validation.validateAmountLimitsFree(1.0));
	}
	
	@Test
	public void testValidateAmountFreeUserBetGreaterThanFive() {
		// given
		// when
		// then
		assertFalse(validation.validateAmountLimitsFree(5.01));
	}
	
	@Test
	public void testValidateAmountPremiumUserValidBet() {
		// given
		List<Bet> bets = new ArrayList<Bet>();
		// when
		// then
		assertTrue(validation.validateCumulativeAmountPremium(bets, 2000));
	}
	
	@Test
	public void testValidateAmountLimitsPremiumPositiveAmount() {
		// given
		// when
		// then
		assertTrue(validation.validateAmountLimitsPremium(2000));
	}
	
	@Test
	public void testValidateAmountPremiumUserNegativeBet() {
		// given
		// when
		// then
		assertFalse(validation.validateAmountLimitsPremium(-2000));
	}
	
	@Test
	public void testValidateAmountPremiumUserExceedCumulativeBetLimit() {
		// given
		List<Bet> bets = new ArrayList<Bet>();
		Bet b = new Bet();
		b.setAmount(5000);
		bets.add(b);
		// when
		// then
		assertFalse(validation.validateCumulativeAmountPremium(bets, 1.0));
	}
}
