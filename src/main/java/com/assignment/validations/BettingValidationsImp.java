package com.assignment.validations;

import java.util.List;

import com.assignment.DBObjects.Bet;
import com.assignment.DBObjects.User;

public class BettingValidationsImp implements BettingValidations{
	
	public boolean validateRisk(User user, String risk) {
		if (isFreeUser(user)) {
			if(!risk.equals("Low")){
				return false;
			}
		}
		return true;
	}
	
	public boolean validateAmount(User user, double amount, List<Bet> bets){
		if(isFreeUser(user)){
			return validateAmountFree(bets, amount);
		}
		else{
			return validateAmountPremium(bets, amount);
		}
	}
	
	private boolean validateAmountFree(List<Bet> bets, double amount){
		return bets.size() < 3 && amount > 0 && amount <= 5;
	}
	
	private boolean validateAmountPremium(List<Bet> bets, double amount){
		if(amount < 0){
			return false;
		}
		
		double total = 0;
		for(Bet b : bets){
			total += b.getAmmount();
		}
		
		if(total + amount > 5000){
			return false;
		}
		return true;
	}
	
	private boolean isFreeUser(User user){
		return user.getAccounttype().equals("free");
	}
}
