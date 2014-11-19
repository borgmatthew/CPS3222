package com.assignment.functionalities;

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
}
