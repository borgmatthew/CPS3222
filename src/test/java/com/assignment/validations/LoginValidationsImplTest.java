package com.assignment.validations;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.assignment.DBObjects.User;

public class LoginValidationsImplTest {

	private LoginValidation loginValidation;
	
	@Before
	public void setUp() throws Exception {
		loginValidation = new LoginValidationsImpl();
	}

	@Test
	public void testUserExistsNoUsers() {
		//given
		List<User> users = new ArrayList<User>();
		//when
		//then
		assertFalse(loginValidation.userExists(users));
	}

	@Test
	public void testUserExistsOneUser() {
		//given
		List<User> users = new ArrayList<User>();
		users.add(new User());
		//when
		//then
		assertTrue(loginValidation.userExists(users));
	}
	
	@Test
	public void testUserExistsMultipleUsers() {
		//given
		List<User> users = new ArrayList<User>();
		users.add(new User());
		users.add(new User());
		//when
		//then
		assertFalse(loginValidation.userExists(users));
	}
	
	@Test
	public void testCanAttemptLoginValid() {
		//given
		User user = new User();
		user.setLockTime(0);
		user.setAttempts(2);
		//when
		//then
		assertTrue(loginValidation.canAttemptLogin(user));
	}
	
	@Test
	public void testCanAttemptLoginInvalidAttempts() {
		//given
		User user = new User();
		user.setLockTime(0);
		user.setAttempts(3);
		//when
		//then
		assertFalse(loginValidation.canAttemptLogin(user));
	}
	
	@Test
	public void testCanAttemptLoginInvalidTime() {
		//given
		User user = new User();
		user.setLockTime(new Date().getTime());
		user.setAttempts(0);
		//when
		//then
		assertFalse(loginValidation.canAttemptLogin(user));
	}
	
	@Test
	public void testCanAttemptLoginInvalidUpperLimit() {
		//given
		long fiveMinutes = (1000*60*5);
		User user = new User();
		user.setLockTime(new Date().getTime() - fiveMinutes + 1);
		user.setAttempts(0);
		//when
		//then
		assertFalse(loginValidation.canAttemptLogin(user));
	}
	
	@Test
	public void testCanAttemptLoginValidLowerLimit() {
		//given
		long fiveMinutes = (1000*60*5);
		User user = new User();
		user.setLockTime(new Date().getTime() - fiveMinutes);
		user.setAttempts(0);
		//when
		//then
		assertTrue(loginValidation.canAttemptLogin(user));
	}
}
