package com.assignment.mongodb;

import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public interface MongoDBActionsWrapper {
	public boolean insert(MongoClient client, String dbName, String tblName, DBObject ... objects);
	public DBCursor find(MongoClient client, String dbName, String tblName, DBObject toFind);
}
