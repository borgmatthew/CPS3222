package com.assignment.functionalities;

import java.util.List;

import com.assignment.DBObjects.Bet;
import com.assignment.requests.BettingRequestsImpl;
import com.assignment.validations.BettingValidationsImp;

public class BettingImp implements Betting {
    private String message="";   
	public boolean validateBets(String user,String risk,String ammount){
		BettingValidationsImp validation=new BettingValidationsImp();
    	   if(validation.validateRisk(user,risk)){
   			/*System.out.println("fucker1");
			System.out.println(user);
			System.out.println(risk);*/


    		   return true;
    	   }
    	   else{
    		   message="A free user can only make low risk bets.";
    		   return false;
    	   }
       }
	
	public String getMessage(){
		return message;
	}
	
	public void addBet(String risk, String ammount,String user) {
		BettingRequestsImpl userRequest = new BettingRequestsImpl();
		Bet newBet =new Bet(risk,ammount,user);
		userRequest.createBet(newBet);
	}
	
	public String getAllBets(String user){
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
	
	private List<Bet> getAllBetsOfUser(String user){
		BettingRequestsImpl betRequest = new BettingRequestsImpl();
		Bet tempbet = new Bet();
		tempbet.setUser(user);
		return betRequest.findBet(tempbet);
	}
}
