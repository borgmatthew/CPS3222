package com.assignment.mongodb;

import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;

public class MongoDBActionsWrapperImpl implements MongoDBActionsWrapper {

	@Override
	public boolean insert(MongoClient client, String dbName, String tblName, DBObject... objects) {
		boolean result;
		try {
			client.getDB(dbName)
					.getCollection(tblName)
					.insert(WriteConcern.SAFE, objects);
			result = true;
		} catch (MongoException error) {
			result = false;
		}
		return result;
	}

	@Override
	public DBCursor find(MongoClient client, String dbName, String tblName, DBObject toFind) {
		DBCursor result = null;
		result = client.getDB(dbName).getCollection(tblName).find(toFind);
		return result;
	}
}
