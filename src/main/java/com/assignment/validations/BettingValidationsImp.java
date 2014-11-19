package com.assignment.validations;

import java.util.List;

import com.assignment.DBObjects.User;
import com.assignment.requests.UserRequestImpl;

public class BettingValidationsImp {
	public boolean validateRisk(String user, String risk) {
		UserRequestImpl req = new UserRequestImpl();
		User tempusr = new User();
		tempusr.setUsername(user);
		List<User> usr = req.getUser(tempusr);
		//System.out.println("account type of user is: "+usr.get(0).getAccounttype());

		if ((usr.get(0).getAccounttype()).equals("free")) {
			//System.out.println("hawn dahal");
			if(risk.equals("High")){
				return false;
			}
			else if(risk.equals("Medium")){
				return false;
			}
			else{
				return true;
			}
		}
		return true;
	}
}
