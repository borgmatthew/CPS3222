package com.assignment.mongodb;

import java.util.List;

import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class MongoDBWrapperImpl implements MongoDBWrapper {

	private final String host;
	private final int port;
	private MongoDBActionsWrapper actionsWrapper;
	private MongoDBConnectionWrapper connectionWrapper;
	
	public MongoDBWrapperImpl(String host, int port) {
		this.host = host;
		this.port = port;
		this.actionsWrapper = new MongoDBActionsWrapperImpl();
		this.connectionWrapper = new MongoDBConnectionWrapperImpl();
	}
	
	public MongoDBWrapperImpl(String host, int port, MongoDBActionsWrapper actions, MongoDBConnectionWrapper connections) {
		this.host = host;
		this.port = port;
		this.actionsWrapper = actions;
		this.connectionWrapper = connections;
	}
	
	@Override
	public boolean insert(String dbName, String tblName, DBObject object) {
		boolean result = false;
		MongoClient client = connectionWrapper.connect(host, port);
		if(client != null){
			result = actionsWrapper.insert(client, dbName, tblName, object);
			connectionWrapper.disconnect(client);
		}
		return result;
	}

	@Override
	public List<DBObject> find(String dbName, String tblName, DBObject object) {
		List<DBObject> result = null;
		MongoClient client = connectionWrapper.connect(host, port);
		if(client != null){
			result = actionsWrapper.find(client, dbName, tblName, object).toArray();
			connectionWrapper.disconnect(client);
		}
		return result;
	}

	@Override
	public void setActionsWrapper(MongoDBActionsWrapper actionsWrapper){
		this.actionsWrapper = actionsWrapper;
	}
	
	@Override
	public void setConnectionWrapper(MongoDBConnectionWrapper connectionWrapper){
		this.connectionWrapper = connectionWrapper;
	}

	@Override
	public boolean save(String dbName, String tblName, DBObject object) {
		boolean result = false;
		MongoClient client = connectionWrapper.connect(host, port);
		if(client != null){
			result = actionsWrapper.save(client, dbName, tblName, object);
			connectionWrapper.disconnect(client);
		}
		return result;
	}
}
