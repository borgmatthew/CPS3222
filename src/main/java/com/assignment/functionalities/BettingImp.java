package com.assignment.functionalities;

import java.util.List;

import com.assignment.DBObjects.Bet;
import com.assignment.DBObjects.User;
import com.assignment.requests.BettingRequestsImpl;
import com.assignment.requests.UserRequestImpl;
import com.assignment.validations.BettingValidationsImp;

public class BettingImp implements Betting {

	public boolean validateBets(String user, String risk, double amount) {
		BettingValidationsImp validation = new BettingValidationsImp();
		User usr = getUser(user).get(0);
		boolean result = false;
		if (validation.validateRisk(usr, risk)) {
			if(validation.validateAmount(usr, amount, getAllBetsOfUser(user))){
				result = true;
			}
		}
		return result;
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
