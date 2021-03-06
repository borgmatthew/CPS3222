package com.assignment.requests;

import java.util.List;

import com.assignment.DBObjects.User;

public interface UserRequest {
	public boolean createUser(User user);
	public List<User> getUser(User toFind);
	public boolean save(User toUpdate);
}
