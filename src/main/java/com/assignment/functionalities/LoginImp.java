package com.assignment.functionalities;

import java.util.Date;
import java.util.List;

import com.assignment.DBObjects.User;
import com.assignment.requests.UserRequest;
import com.assignment.requests.UserRequestImpl;
import com.assignment.validations.LoginValidation;
import com.assignment.validations.LoginValidationsImpl;

public class LoginImp implements Login {

	private LoginValidation loginValidation;
	
	public LoginImp(){
		loginValidation = new LoginValidationsImpl();
	}
	
	@Override
	public boolean validate(String username, String password) {
		User user = new User();
		user.setUsername(username);
		UserRequest request = new UserRequestImpl();
		List<User> query = request.getUser(user);
		if (loginValidation.userExists(query)) {
			user = query.get(0);
			if (loginValidation.canAttemptLogin(user)) {
				if (loginValidation.validatePassword(user, password)) {
					user.setAttempts(0);
					request.save(user);
					return true;
				} else {
					user.setAttempts(user.getAttempts() + 1);
					if(user.getAttempts() == 3){
						user.setLockTime(new Date().getTime());
						user.setAttempts(0);
					}
					request.save(user);
				}
			}
		}
		return false;
	}
}
