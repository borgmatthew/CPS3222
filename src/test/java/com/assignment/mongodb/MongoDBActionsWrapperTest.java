package com.assignment.mongodb;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.assignment.mongodb.MongoDBActionsWrapperImpl;
import com.assignment.mongodb.MongoDBActionsWrapper;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;
import com.mongodb.WriteResult;

public class MongoDBActionsWrapperTest {

	MongoDBActionsWrapper database;

	@Mock
	MongoClient client;

	@Mock
	DB db;

	@Mock
	DBCollection collection;

	@Mock
	DBObject object;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		database = new MongoDBActionsWrapperImpl();
	}

	@Test
	public void testInsertSuccessfull() {
		// given
		WriteResult writeResult = mock(WriteResult.class);
		// when
		doReturn(db).when(client).getDB(anyString());
		doReturn(collection).when(db).getCollection(anyString());
		doReturn(writeResult).when(collection).insert(WriteConcern.SAFE, object);
		// then
		assertTrue(database.insert(client, "databaseName", "tableName", object));
	}

	@Test
	public void testInsertMongoExceptionOccurs() {
		// given
		DBObject object = mock(DBObject.class);
		// when
		doReturn(db).when(client).getDB(anyString());
		doReturn(collection).when(db).getCollection(anyString());
		doThrow(new MongoException("test")).when(collection).insert(WriteConcern.SAFE, object);
		// then
		assertFalse(database.insert(client, "databaseName", "tableName", object));
	}
}
