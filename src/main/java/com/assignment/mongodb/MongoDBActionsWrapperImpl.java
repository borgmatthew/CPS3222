package com.assignment.mongodb;

import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;
import com.mongodb.WriteResult;

public class MongoDBActionsWrapperImpl implements MongoDBAtionsWrapper {
	
	private MongoClient client;
	
	public MongoDBActionsWrapperImpl(MongoClient client){
		this.client = client;
	}
	
	@Override
	public boolean insert(String dbName, String tblName, DBObject... objects) {
		boolean result;
		try{
			WriteResult insertResult = client.getDB("dbName").getCollection("tblName").insert(WriteConcern.SAFE, objects);
			if(insertResult.getN() == objects.length){
				result = true;
			}else result = false;
		}catch(MongoException error){
			result = false;
		}
		return result;
	}

}
