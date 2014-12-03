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
import com.assignment.DBObjects.User;

public class BettingValidationsImpTest {

	private BettingValidations validation;
	private User user;

	@Before
	public void setUp() throws Exception {
		validation = new BettingValidationsImp();
		user = new User();
	}

	@Test
	public void testValidateRiskFreeUserNotLow() {
		// given
		user.setAccounttype("free");
		// when
		// then
		assertFalse(validation.validateRisk(user, "Medium"));
	}

	@Test
	public void testValidateRiskFreeUserLowRisk() {
		// given
		user.setAccounttype("free");
		// when
		// then
		assertTrue(validation.validateRisk(user, "Low"));
	}
	
	@Test
	public void testValidateRiskPremiumUser() {
		// given
		user.setAccounttype("premium");
		// when
		// then
		assertTrue(validation.validateRisk(user, "Low"));
	}
	
	@Test
	public void testValidateAmountFreeUserLessThanThreeBets() {
		// given
		List<Bet> bets = new ArrayList<Bet>();
		user.setAccounttype("free");
		// when
		// then
		assertTrue(validation.validateAmount(user, 1.0, bets));
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testValidateAmountFreeUserHasThreeBets() {
		// given
		user.setAccounttype("free");
		List bets = mock(List.class);
		doReturn(3).when(bets).size();
		// when
		// then
		assertFalse(validation.validateAmount(user, 1.0, bets));
	}
	
	@Test
	public void testValidateAmountFreeUserNegativeBet() {
		// given
		List<Bet> bets = new ArrayList<Bet>();
		user.setAccounttype("free");
		// when
		// then
		assertFalse(validation.validateAmount(user, -1.0, bets));
	}
	
	@Test
	public void testValidateAmountFreeUserBetGreaterThanFive() {
		// given
		List<Bet> bets = new ArrayList<Bet>();
		user.setAccounttype("free");
		// when
		// then
		assertFalse(validation.validateAmount(user, 5.01, bets));
	}
	
	@Test
	public void testValidateAmountPremiumUserValidBet() {
		// given
		List<Bet> bets = new ArrayList<Bet>();
		user.setAccounttype("premium");
		// when
		// then
		assertTrue(validation.validateAmount(user, 2000, bets));
	}
	
	@Test
	public void testValidateAmountPremiumUserNegativeBet() {
		// given
		List<Bet> bets = new ArrayList<Bet>();
		user.setAccounttype("premium");
		// when
		// then
		assertFalse(validation.validateAmount(user, -2000, bets));
	}
	
	@Test
	public void testValidateAmountPremiumUserExceedCumulativeBetLimit() {
		// given
		List<Bet> bets = new ArrayList<Bet>();
		Bet b = new Bet();
		b.setAmount(5000);
		bets.add(b);
		user.setAccounttype("premium");
		// when
		// then
		assertFalse(validation.validateAmount(user, 1, bets));
	}
}
