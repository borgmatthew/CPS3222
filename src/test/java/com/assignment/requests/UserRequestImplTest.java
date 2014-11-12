package com.assignment.requests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.assignment.DBObjects.User;

public class UserRequestImplTest {

	private UserRequest userRequest;
	
	@Before
	public void setUp(){
		userRequest = new UserRequestImpl();
	}

	@Test
	public void test() {
		User testuser = new User("joe", "borg", "username", "password", "1/1/94", "free", "123456", "1/1/15", "313");
		assertTrue(userRequest.createUser(testuser));
	}

}
