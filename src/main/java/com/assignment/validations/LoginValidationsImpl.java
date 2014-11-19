package com.assignment.validations;

import java.util.List;

import com.assignment.DBObjects.User;

public class LoginValidationsImpl implements LoginValidation {

	@Override
	public boolean userExists(List<User> users) {
		return users.size() == 1;
	}

	@Override
	public boolean canLogin(User user) {
		return user.getAttempts() < 3;
	}

	@Override
	public boolean validatePassword(User user, String password) {
		return user.getPassword().compareTo(password) == 0;
	}

}
