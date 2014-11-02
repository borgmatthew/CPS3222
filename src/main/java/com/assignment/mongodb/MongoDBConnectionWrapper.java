package com.assignment.mongodb;

import com.mongodb.MongoClient;

public interface MongoDBConnectionWrapper {
	public MongoClient connect(String host, int port);
	public void disconnect(MongoClient client);
}
