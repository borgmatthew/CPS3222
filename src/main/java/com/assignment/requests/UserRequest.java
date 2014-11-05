package com.assignment.requests;

import java.util.List;

import com.assignment.DBObjects.User;

public interface UserRequest {
	public boolean createUser();
	public List<User> getUser(int userId);
}
