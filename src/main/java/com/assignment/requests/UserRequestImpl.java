package com.assignment.requests;

import java.util.List;

import com.assignment.DBObjects.User;
import com.assignment.mongodb.MongoDBWrapper;
import com.assignment.mongodb.MongoDBWrapperImpl;

public class UserRequestImpl implements UserRequest {

	MongoDBWrapper dbWrapper;

	public UserRequestImpl() {
		dbWrapper = new MongoDBWrapperImpl("localhost", 27017);
		// TODO load properties from properties file
	}

	@Override
	public boolean createUser(User toCreate) {
		toCreate.populateMap();
		return dbWrapper.insert("SoftwareTesting", "Users", toCreate);
	}

	@Override
	public List<User> getUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}
}
