package com.assignment.functionalities;

import java.util.List;

import com.assignment.DBObjects.Bet;
import com.assignment.DBObjects.User;
import com.assignment.requests.BettingRequestsImpl;
import com.assignment.requests.UserRequestImpl;
import com.assignment.validations.BettingValidationsImp;

public class BettingImp implements Betting {

	String message = "";
	
	public boolean validateBets(String user, String risk, double amount) {
		BettingValidationsImp validation = new BettingValidationsImp();
		User usr = getUser(user).get(0);
		boolean result = false;
		
		List<Bet> allBets = getAllBetsOfUser(user);
		if(isFreeUser(usr)){
			if(validation.validateRiskFree(risk)){
				if(validation.validateBetLimitNumberFree(allBets)){
					if(validation.validateAmountLimitsFree(amount)){
						result= true;
						message = "Bet placed successfully";
					}else{
						message = "Invalid amount";
					}
				}
				else{
					message = "Maximum number of bets reached";
				}
			}else{
				message = "Invalid risk";
			}
		}else{
			if(validation.validateAmountLimitsPremium(amount)){
				if(validation.validateCumulativeAmountPremium(allBets, amount)){
					result = true;
					message = "Bet placed successfully";
				}else{
					message = "Maximum cumulative amount reached";
				}
			}else{
				message = "Invalid amount";
			}
		}
		return result;
	}
	
	private boolean isFreeUser(User user){
		return user.getAccounttype().equals("free");
	}
	
	public String getMessage(){
		return message;
	}

	public void addBet(String risk, double amount, String user) {
		BettingRequestsImpl userRequest = new BettingRequestsImpl();
		Bet newBet = new Bet(risk, amount, user);
		userRequest.createBet(newBet);
	}

	public String getAllBets(String user) {
		List<Bet> bets = getAllBetsOfUser(user);
		StringBuilder builder = new StringBuilder();
		builder.append("<ul>");
		for (Bet b : bets) {
			builder.append("<li>");
			builder.append(b.getRisk());
			builder.append(", ");
			builder.append(b.getAmmount());
			builder.append("</li>");
		}
		builder.append("</ul>");
		return builder.toString();
	}

	private List<Bet> getAllBetsOfUser(String user) {
		BettingRequestsImpl betRequest = new BettingRequestsImpl();
		Bet tempbet = new Bet();
		tempbet.setUser(user);
		return betRequest.findBet(tempbet);
	}

	private List<User> getUser(String user) {
		UserRequestImpl req = new UserRequestImpl();
		User tempusr = new User();
		tempusr.setUsername(user);
		return req.getUser(tempusr);
	}
}
