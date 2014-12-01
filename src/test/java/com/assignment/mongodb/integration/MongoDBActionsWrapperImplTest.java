package com.assignment.mongodb.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.assignment.mongodb.MongoDBActionsWrapper;
import com.assignment.mongodb.MongoDBActionsWrapperImpl;
import com.assignment.mongodb.MongoDBConnectionWrapper;
import com.assignment.mongodb.MongoDBConnectionWrapperImpl;
import com.assignment.util.Props;
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
		client = connectionsWrapper.connect(Props.getProperty("host"), Integer.parseInt(Props.getProperty("port")));
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
		actionsWrapper.insert(client, dbName, tblName,	testObject);
		DBCursor found = actionsWrapper.find(client, dbName, tblName, testObject);
		TestObject fromDb = new TestObject(found.next());
		// then
		assertTrue(testObject.equals(fromDb));
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
	public void testFindNoObjectsMatch(){
		//given
		TestObject testObject = new TestObject(1, "test");
		TestObject toFind = new TestObject();
		toFind.setVar1(0);
		actionsWrapper.insert(client, dbName, tblName, testObject);
		//when
		DBCursor result = actionsWrapper.find(client, dbName, tblName, toFind);
		//then
		assertEquals(0, result.count());
	}
	
	@Test
	public void testSaveSuccessfull(){
		//given
		TestObject testObject = new TestObject(2, "abc");
		actionsWrapper.insert(client, dbName, tblName, testObject);
		//when
		DBCursor result = actionsWrapper.find(client, dbName, tblName, testObject);
		TestObject toUpdate = new TestObject(result.next());
		toUpdate.setVar1(123);
		actionsWrapper.save(client, dbName, tblName, toUpdate);
		TestObject query = new TestObject();
		query.setVar2("abc");
		TestObject checkUpdated = new TestObject(actionsWrapper.find(client, dbName, tblName, query).next());
		//then
		assertEquals(123, checkUpdated.getVar1());
	}
}
