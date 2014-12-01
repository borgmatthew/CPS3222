package com.assignment.requests.integration;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.assignment.DBObjects.User;
import com.assignment.requests.UserRequest;
import com.assignment.requests.UserRequestImpl;
import com.assignment.util.Props;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;

public class UserRequestImplTest {

	private UserRequest userRequest;
	private MongoClient client;
	private String dbname = Props.getProperty("user_db");
	private String tblname = Props.getProperty("user_tbl");

	@Before
	public void setUp() throws Exception {
		userRequest = new UserRequestImpl();
		client = new MongoClient(Props.getProperty("host"),
				Integer.parseInt(Props.getProperty("port")));
	}

	@After
	public void tearDown() throws Exception {
		client.getDB(dbname).getCollection(tblname).remove(new BasicDBObject());
		client.close();
	}
	
	@Test
	public void testCreateUserNameSavedCorrectly() {
		// given
		User b = new User("name", "surname", "username", "password", "dob", "acctype", "1234", "expdate", "cvv", 2, 999999L);
		// when
		userRequest.createUser(b);
		User fromDb = new User(client.getDB(dbname).getCollection(tblname)
				.find(b).toArray().get(0));
		// then
		assertEquals("name", fromDb.getName());
	}

	@Test
	public void testCreateUserSurnameSavedCorrectly() {
		// given
		User b = new User("name", "surname", "username", "password", "dob", "acctype", "1234", "expdate", "cvv", 2, 999999L);
		// when
		userRequest.createUser(b);
		User fromDb = new User(client.getDB(dbname).getCollection(tblname)
				.find(b).toArray().get(0));
		// then
		assertEquals("surname", fromDb.getSname());
	}

	@Test
	public void testCreateUserUsernameSavedCorrectly() {
		// given
		User b = new User("name", "surname", "username", "password", "dob", "acctype", "1234", "expdate", "cvv", 2, 999999L);
		// when
		userRequest.createUser(b);
		User fromDb = new User(client.getDB(dbname).getCollection(tblname)
				.find(b).toArray().get(0));
		// then
		assertEquals("username", fromDb.getUsername());
	}
	
	@Test
	public void testCreateUserPasswordSavedCorrectly() {
		// given
		User b = new User("name", "surname", "username", "password", "dob", "acctype", "1234", "expdate", "cvv", 2, 999999L);
		// when
		userRequest.createUser(b);
		User fromDb = new User(client.getDB(dbname).getCollection(tblname)
				.find(b).toArray().get(0));
		// then
		assertEquals("password", fromDb.getPassword());
	}

	@Test
	public void testCreateUserDobSavedCorrectly() {
		// given
		User b = new User("name", "surname", "username", "password", "dob", "acctype", "1234", "expdate", "cvv", 2, 999999L);
		// when
		userRequest.createUser(b);
		User fromDb = new User(client.getDB(dbname).getCollection(tblname)
				.find(b).toArray().get(0));
		// then
		assertEquals("dob", fromDb.getDob());
	}
	
	@Test
	public void testCreateUserAccountTypeSavedCorrectly() {
		// given
		User b = new User("name", "surname", "username", "password", "dob", "acctype", "1234", "expdate", "cvv", 2, 999999L);
		// when
		userRequest.createUser(b);
		User fromDb = new User(client.getDB(dbname).getCollection(tblname)
				.find(b).toArray().get(0));
		// then
		assertEquals("acctype", fromDb.getAccounttype());
	}
	
	@Test
	public void testCreateUserCardSavedCorrectly() {
		// given
		User b = new User("name", "surname", "username", "password", "dob", "acctype", "1234", "expdate", "cvv", 2, 999999L);
		// when
		userRequest.createUser(b);
		User fromDb = new User(client.getDB(dbname).getCollection(tblname)
				.find(b).toArray().get(0));
		// then
		assertEquals("1234", fromDb.getCreditcard());
	}
	
	@Test
	public void testCreateUserExpDateSavedCorrectly() {
		// given
		User b = new User("name", "surname", "username", "password", "dob", "acctype", "1234", "expdate", "cvv", 2, 999999L);
		// when
		userRequest.createUser(b);
		User fromDb = new User(client.getDB(dbname).getCollection(tblname)
				.find(b).toArray().get(0));
		// then
		assertEquals("expdate", fromDb.getExpdate());
	}
	
	@Test
	public void testCreateUserCvvSavedCorrectly() {
		// given
		User b = new User("name", "surname", "username", "password", "dob", "acctype", "1234", "expdate", "cvv", 2, 999999L);
		// when
		userRequest.createUser(b);
		User fromDb = new User(client.getDB(dbname).getCollection(tblname)
				.find(b).toArray().get(0));
		// then
		assertEquals("cvv", fromDb.getCvv());
	}
	
	@Test
	public void testCreateUserAttemptsSavedCorrectly() {
		// given
		User b = new User("name", "surname", "username", "password", "dob", "acctype", "1234", "expdate", "cvv", 2, 999999L);
		// when
		userRequest.createUser(b);
		User fromDb = new User(client.getDB(dbname).getCollection(tblname)
				.find(b).toArray().get(0));
		// then
		assertEquals(2, fromDb.getAttempts(), 0);
	}
	
	@Test
	public void testCreateUserTimeoutSavedCorrectly() {
		// given
		User b = new User("name", "surname", "username", "password", "dob", "acctype", "1234", "expdate", "cvv", 2, 999999L);
		// when
		userRequest.createUser(b);
		User fromDb = new User(client.getDB(dbname).getCollection(tblname)
				.find(b).toArray().get(0));
		// then
		assertEquals(999999L, fromDb.getLockTime());
	}
	
	@Test
	public void testFindUserOneUser() {
		// given
		User b = new User("name", "surname", "username", "password", "dob", "acctype", "1234", "expdate", "cvv", 2, 999999L);
		// when
		userRequest.createUser(b);
		List<User> fromDb = userRequest.getUser(b);
		// then
		assertEquals(b, fromDb.get(0));
	}

	@Test
	public void testFindMultipleUsers() {
		// given
		User b = new User("name", "surname", "user1", "password", "dob", "free", "1234", "expdate", "cvv", 2, 999999L);
		User c = new User("name", "surname", "user2", "password", "dob", "free", "1234", "expdate", "cvv", 2, 999999L);
		User d = new User("name", "surname", "user3", "password", "dob", "premium", "1234", "expdate", "cvv", 2, 999999L);
		User search = new User();
		search.setAccounttype("free");
		// when
		userRequest.createUser(b);
		userRequest.createUser(c);
		userRequest.createUser(d);
		List<User> fromDb = userRequest.getUser(search);
		// then
		assertEquals(2, fromDb.size());
	}
	
	@Test
	public void testSave(){
		//given
		User b = new User("name", "surname", "user1", "password", "dob", "free", "1234", "expdate", "cvv", 2, 999999L);
		userRequest.createUser(b);
		//when
		b.setName("newName");
		userRequest.save(b);
		//then
		User search = new User();
		search.setUsername("user1");
		List<User> result = userRequest.getUser(search);
		
		assertEquals("newName", result.get(0).getName());
	}
}
