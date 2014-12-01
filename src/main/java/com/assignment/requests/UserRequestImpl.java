package com.assignment.requests;

import java.util.ArrayList;
import java.util.List;

import com.assignment.DBObjects.User;
import com.assignment.mongodb.MongoDBWrapper;
import com.assignment.mongodb.MongoDBWrapperImpl;
import com.assignment.util.Props;
import com.mongodb.DBObject;

public class UserRequestImpl implements UserRequest {

	MongoDBWrapper dbWrapper;

	public UserRequestImpl() {
		dbWrapper = new MongoDBWrapperImpl(Props.getProperty("host"), Integer.parseInt(Props.getProperty("port")));
		// TODO load properties from properties file
	}
	
	public UserRequestImpl(MongoDBWrapper wrapper){
		dbWrapper = wrapper;
	}

	@Override
	public boolean createUser(User toCreate) {
		return dbWrapper.insert(Props.getProperty("user_db"), Props.getProperty("user_tbl"), toCreate);
	}

	@Override
	public List<User> getUser(User toFind) {
		List<DBObject> query = dbWrapper.find(Props.getProperty("user_db"), Props.getProperty("user_tbl"), toFind);
		List<User> result = new ArrayList<User>(query.size());
		for(DBObject o : query){
			result.add(new User(o));
		}
		return result;
	}

	@Override
	public boolean save(User toUpdate) {
		return dbWrapper.save(Props.getProperty("user_db"), Props.getProperty("user_tbl"), toUpdate);
	}
}
