package com.assignment.requests;

import java.util.ArrayList;
import java.util.List;

import com.assignment.DBObjects.User;
import com.assignment.mongodb.MongoDBWrapper;
import com.assignment.mongodb.MongoDBWrapperImpl;
import com.mongodb.DBObject;

public class UserRequestImpl implements UserRequest {

	MongoDBWrapper dbWrapper;

	public UserRequestImpl() {
		dbWrapper = new MongoDBWrapperImpl("localhost", 27017);
		// TODO load properties from properties file
	}

	@Override
	public boolean createUser(User toCreate) {
		return dbWrapper.insert("SoftwareTesting", "Users", toCreate);
	}

	@Override
	public List<User> getUser(User toFind) {
		List<DBObject> query = dbWrapper.find("SoftwareTesting", "Users", toFind);
		List<User> result = new ArrayList<User>(query.size());
		for(DBObject o : query){
			result.add(new User(o));
		}
		return result;
	}

	@Override
	public boolean save(User toUpdate) {
		return dbWrapper.insert("SoftwareTesting", "Users", toUpdate);
	}
}
