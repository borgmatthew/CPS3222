package com.assignment.validations;

import java.util.List;

import com.assignment.DBObjects.Bet;
import com.assignment.DBObjects.User;

public interface BettingValidations {
	public boolean validateRisk(User user, String risk);
	public boolean validateAmount(User user, double amount, List<Bet> bets);
}
