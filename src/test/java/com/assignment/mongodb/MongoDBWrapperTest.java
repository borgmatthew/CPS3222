package com.assignment.mongodb;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class MongoDBWrapperTest {

	private MongoDBWrapperImpl mongoDBwrapper;

	@Mock
	private MongoDBConnectionWrapper connectionWrapper;

	@Mock
	private MongoDBActionsWrapper actionsWrapper;

	@Mock
	private DBObject object;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mongoDBwrapper = new MongoDBWrapperImpl("", 1, actionsWrapper,
				connectionWrapper);
	}

	@Test
	public void testInsertConnectionIsNull() {
		// given
		// when
		doReturn(null).when(connectionWrapper).connect(anyString(), anyInt());
		// then
		assertFalse(mongoDBwrapper.insert("", "", object));
	}

	@Test
	public void testFindConnectionIsNull() {
		// given
		// when
		doReturn(null).when(connectionWrapper).connect(anyString(), anyInt());
		// then
		assertNull(mongoDBwrapper.find("", "", object));
	}

	@Test
	public void testInsertConnectionNotNull() {
		// given
		MongoClient mockClient = mock(MongoClient.class);
		// when
		doReturn(mockClient).when(connectionWrapper).connect(anyString(),
				anyInt());
		doReturn(true).when(actionsWrapper).insert(any(MongoClient.class), anyString(),	anyString(), any(DBObject.class));
		// then
		assertTrue(mongoDBwrapper.insert("", "", object));
	}

	@Test
	public void testInsertConnectionIsTerminated() {
		// given
		MongoClient mockClient = mock(MongoClient.class);
		MongoDBConnectionWrapper testspy = spy(new MongoDBConnectionWrapperImpl());
		mongoDBwrapper.setConnectionWrapper(testspy);
		// when
		doReturn(mockClient).when(testspy).connect(anyString(),
				anyInt());
		doReturn(true).when(actionsWrapper).insert(any(MongoClient.class), anyString(),	anyString(), any(DBObject.class));
		mongoDBwrapper.insert("", "", object);
		// then
		verify(testspy).disconnect(mockClient);
	}
	
	@Test
	public void testFindConnectionNotNull() {
		// given
		MongoClient mockClient = mock(MongoClient.class);
		DBCursor mockCursor = mock(DBCursor.class);
		List<DBObject> result = new ArrayList<DBObject>();
		result.add(object);
		// when
		doReturn(result).when(mockCursor).toArray();
		doReturn(mockClient).when(connectionWrapper).connect(anyString(),
				anyInt());
		doReturn(mockCursor).when(actionsWrapper).find(any(MongoClient.class), anyString(),	anyString(), any(DBObject.class));
		// then
		assertNotNull(mongoDBwrapper.find("", "", object));
	}
}
