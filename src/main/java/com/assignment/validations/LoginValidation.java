package com.assignment.validations;

import java.util.List;

import com.assignment.DBObjects.User;

public interface LoginValidation {
	public boolean userExists(List<User> users);
	public boolean canAttemptLogin(User user);
	public boolean validatePassword(User user, String password);
}
