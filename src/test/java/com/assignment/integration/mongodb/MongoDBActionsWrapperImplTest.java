package com.assignment.integration.mongodb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.assignment.mongodb.MongoDBActionsWrapper;
import com.assignment.mongodb.MongoDBActionsWrapperImpl;
import com.assignment.mongodb.MongoDBConnectionWrapper;
import com.assignment.mongodb.MongoDBConnectionWrapperImpl;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class MongoDBActionsWrapperImplTest {

	private MongoDBActionsWrapper actionsWrapper = new MongoDBActionsWrapperImpl();
	private MongoDBConnectionWrapper connectionsWrapper = new MongoDBConnectionWrapperImpl();
	private MongoClient client;
	private final String dbName = "Tests";
	private final String tblName = "tests";

	@Before
	public void setUp() {
		client = connectionsWrapper.connect("localhost", 27017);
	}

	@After
	public void tearDown() {
		//clear collection and close connection
		client.getDB(dbName).getCollection(tblName).remove(new BasicDBObject());
		connectionsWrapper.disconnect(client);
	}

	@Test
	public void testInsertSuccessfull() {
		// given
		TestObject testObject = new TestObject(1, "test");
		// when
		boolean result = actionsWrapper.insert(client, dbName, tblName,
				testObject);
		// then
		assertTrue(result);
	}

	@Test
	public void testFindOneObject() {
		// given
		TestObject testObject = new TestObject(1, "test");
		TestObject toFind = new TestObject();
		toFind.setVar1(1);
		// when
		actionsWrapper.insert(client, dbName, tblName,	testObject);
		DBCursor result = actionsWrapper.find(client, dbName, tblName, toFind);
		// then
		assertEquals(1, result.count());
	}
	
	@Test
	public void testFindNoObjects(){
		//given
		TestObject testObject = new TestObject(1, "test");
		TestObject toFind = new TestObject();
		toFind.setVar1(0);
		//when
		actionsWrapper.insert(client, dbName, tblName, testObject);
		DBCursor result = actionsWrapper.find(client, dbName, tblName, toFind);
		//then
		assertEquals(0, result.count());
	}

}
