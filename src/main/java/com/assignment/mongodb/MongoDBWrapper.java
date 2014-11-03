package com.assignment.mongodb;

import java.util.List;

import com.mongodb.DBObject;

public interface MongoDBWrapper {
	public boolean insert(String dbName, String tblName, DBObject object);
	public List<DBObject> find(String dbName, String tblName, DBObject object);
	public void setActionsWrapper(MongoDBActionsWrapper actionsWrapper);
	public void setConnectionWrapper(MongoDBConnectionWrapper connectionWrapper);
}
