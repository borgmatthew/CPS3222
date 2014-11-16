package com.assignment.requests;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.assignment.DBObjects.User;
import com.assignment.mongodb.MongoDBWrapperImpl;
import com.mongodb.DBObject;

public class UserRequestImplTest {

	private UserRequest userRequest;
	
	@Mock
	MongoDBWrapperImpl wrapper;
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		userRequest = new UserRequestImpl(wrapper);
	}

	@Test
	public void testGetUser() {
		//given
		List<DBObject> query = new ArrayList<DBObject>();
		User usr1 = new User("", "","", "","", "","", "","", 0);
		User usr2 = new User("", "","", "","", "","", "","", 0);
		query.add(usr1);
		query.add(usr2);
		doReturn(query).when(wrapper).find(anyString(), anyString(), any(DBObject.class));
		//when
		List<User> fromDb = userRequest.getUser(new User());
		//then
		assertEquals(2, fromDb.size());
	}

}
