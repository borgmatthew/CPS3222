package com.assignment.functionalities.integration;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.assignment.DBObjects.User;
import com.assignment.functionalities.Login;
import com.assignment.functionalities.LoginImp;
import com.assignment.requests.UserRequest;
import com.assignment.requests.UserRequestImpl;
import com.assignment.util.Props;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;

public class LoginImpTest {

	private Login login;
	private UserRequest userRequest;
	private MongoClient client;
	private String user_dbname = Props.getProperty("user_db");
	private String user_tblname = Props.getProperty("user_tbl");
	
	@Before
	public void setUp() throws Exception {
		login = new LoginImp();
		client = new MongoClient(Props.getProperty("host"),
				Integer.parseInt(Props.getProperty("port")));
		userRequest = new UserRequestImpl();
	}

	@After
	public void tearDown() throws Exception {
		client.getDB(user_dbname).getCollection(user_tblname).remove(new BasicDBObject());
		client.close();
	}

	@Test
	public void testValidateUserValid() {
		//given
		userRequest.createUser(new User("", "","user", "password","", "free","", "","", 0,0));
		//when
		//then
		assertTrue(login.validate("user", "password"));
	}
	
	@Test
	public void testValidateUserInvalid() {
		//given
		userRequest.createUser(new User("", "","user", "password","", "free","", "","", 0,0));
		//when
		//then
		assertFalse(login.validate("us", "password"));
	}
	
	@Test
	public void testValidatePasswordInvalid() {
		//given
		userRequest.createUser(new User("", "","user", "password","", "free","", "","", 0,0));
		//when
		//then
		assertFalse(login.validate("user", "pass"));
	}

	@Test
	public void testValidateCannotAttemptLogin(){
		//given
		userRequest.createUser(new User("", "","user", "password","", "free","", "","", 3,0));
		//when
		//then
		assertFalse(login.validate("user", "password"));
	}
	
	@Test
	public void testValidateLockTimeSet(){
		//given
		userRequest.createUser(new User("", "","user", "password","", "free","", "","", 2,0));
		//when
		login.validate("user", "pass");
		//then
		User toFind = new User();
		toFind.setUsername("user");
		assertTrue(userRequest.getUser(toFind).get(0).getLockTime() != 0);
	}
}
