package com.assignment.mongodb.integration;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

import com.assignment.mongodb.MongoDBConnectionWrapper;
import com.assignment.mongodb.MongoDBConnectionWrapperImpl;
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
		int collectionSize = client.getDB("Tests").getCollection("tests").find().size();
		connectionWrapper.disconnect(client);
		// then
		assertTrue(collectionSize >= 0);
	}
	
	@Test
	public void verifyConnectionIsTerminated(){
		//given
		String host = "localhost";
		int port = 27017;
		MongoClient client = connectionWrapper.connect(host, port);
		MongoClient clientSpy = spy(client);
		//when
		connectionWrapper.disconnect(clientSpy);
		//then
		client.close();
		verify(clientSpy).close();
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
		client.getDB("Tests").getCollection("tests").find().size();
	}

}
