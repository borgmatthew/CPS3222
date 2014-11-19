package com.assignment.validations;

import java.util.Date;
import java.util.List;

import com.assignment.DBObjects.User;

public class LoginValidationsImpl implements LoginValidation {

	@Override
	public boolean userExists(List<User> users) {
		return users.size() == 1;
	}

	@Override
	public boolean canAttemptLogin(User user) {
		return user.getAttempts() < 3 && !isLocked(user);
	}

	@Override
	public boolean validatePassword(User user, String password) {
		return user.getPassword().compareTo(password) == 0;
	}

	private boolean isLocked(User user){
		return ((new Date()).getTime() - user.getLockTime()) < 1000*60*5;
	}
}
