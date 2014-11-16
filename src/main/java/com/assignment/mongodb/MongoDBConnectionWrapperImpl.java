package com.assignment.mongodb;

import java.net.UnknownHostException;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;

public class MongoDBConnectionWrapperImpl implements MongoDBConnectionWrapper {

	public MongoDBConnectionWrapperImpl() {
	}

	@Override
	public MongoClient connect(String host, int port) {
		MongoClient result = null;
		if (host != null && port > 0) {
			try {
				result = new MongoClient(host, port);
			} catch (UnknownHostException unknown) {
				result = null;
			} catch (MongoException mongoError){
				result = null;
			}
		}
		return result;
	}

	@Override
	public void disconnect(MongoClient client) {
		client.close();
	}

}
