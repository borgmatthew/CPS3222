package com.assignment.validations;

import java.util.List;

import com.assignment.DBObjects.Bet;

public interface BettingValidations {
	public boolean validateRiskFree(String risk);
	public boolean validateBetLimitNumberFree(List<Bet> allBets);
	public boolean validateAmountLimitsFree(double amount);
	public boolean validateAmountLimitsPremium(double amount);
	public boolean validateCumulativeAmountPremium(List<Bet> bets, double amount);	
}
