package com.assignment.validations;

import java.util.List;

import com.assignment.DBObjects.User;

public interface Login {
	public boolean validate(String user,String pass);
	public boolean userExists(List<User> users);
	public boolean canLogin(User user);
	public boolean validatePassword(User user, String password);
}
