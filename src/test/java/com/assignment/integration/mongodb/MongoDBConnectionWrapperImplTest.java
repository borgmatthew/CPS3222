package com.assignment.integration.mongodb;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.assignment.mongodb.MongoDBConnectionWrapper;
import com.assignment.mongodb.MongoDBConnectionWrapperImpl;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class MongoDBConnectionWrapperImplTest {

	private MongoDBConnectionWrapper connectionWrapper;

	@Before
	public void setUp() {
		connectionWrapper = new MongoDBConnectionWrapperImpl();
	}

	@Test
	public void testConnectSuccessfull() {
		// given
		// when
		MongoClient client = connectionWrapper.connect("localhost", 27017);
		connectionWrapper.disconnect(client);
		// then
		assertNotNull(client);
	}

	@Test(expected = IllegalStateException.class)
	public void testDisconnectSuccessfull() {
		// given
		String host = "localhost";
		int port = 27017;
		// when
		MongoClient client = connectionWrapper.connect(host, port);
		connectionWrapper.disconnect(client);
		// then
		DBCursor cursor = client.getDB("Tests").getCollection("tests").find();
		cursor.size();
	}

}
