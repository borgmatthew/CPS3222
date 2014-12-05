package com.assignment.validations;

import java.util.List;

import com.assignment.DBObjects.Bet;

public class BettingValidationsImp implements BettingValidations{
	
	public boolean validateRiskFree(String risk) {
		return risk.compareTo("Low") == 0;
	}
	
	public boolean validateAmountLimitsFree(double amount){
		return amount > 0 && amount <= 5;
	}
	
	public boolean validateAmountLimitsPremium(double amount){
		return amount > 0;
	}
	
	public boolean validateCumulativeAmountPremium(List<Bet> bets, double amount){
		double total = 0;
		for(Bet b : bets){
			total += b.getAmmount();
		}
		
		if(total + amount > 5000){
			return false;
		}
		return true;
	}

	public boolean validateBetLimitNumberFree(List<Bet> allBets) {
			return allBets.size() < 3;
	}
}
