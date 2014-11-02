package com.assignment.mongodb;

import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import com.assignment.mongodb.MongoDBConnectionWrapper;
import com.assignment.mongodb.MongoDBConnectionWrapperImpl;

public class MongoDBConnectionWrapperTest {

	MongoDBConnectionWrapper connectionWrapper;
	
	@Before
	public void setUp(){
		connectionWrapper = new MongoDBConnectionWrapperImpl();
	}

	@Test
	public void testConnectHostIsNull() {
		//given
		//when
		//then
		assertNull(connectionWrapper.connect(null, 27017));
	}
	
	@Test
	public void testConnectionPortIsNegative(){
		//given
		//when
		//then
		assertNull(connectionWrapper.connect("", -27017));
	}
}
