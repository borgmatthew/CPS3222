package com.assignment.functionalities.integration;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.assignment.DBObjects.User;
import com.assignment.functionalities.Registration;
import com.assignment.functionalities.RegistrationImpl;
import com.assignment.requests.UserRequest;
import com.assignment.requests.UserRequestImpl;
import com.assignment.util.Props;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;

public class RegistrationImplTest {
	
	private Registration reg;
	private MongoClient client;
	private String dbname = Props.getProperty("user_db");
	private String tblname = Props.getProperty("user_tbl");

	@Before
	public void setUp() throws Exception {
		reg = new RegistrationImpl();
		client = new MongoClient(Props.getProperty("host"),
				Integer.parseInt(Props.getProperty("port")));
	}

	@After
	public void tearDown() throws Exception {
		client.getDB(dbname).getCollection(tblname).remove(new BasicDBObject());
		client.close();
	}

	@Test
	public void TestingValidateFormWithIncorrectUserNameFieldTest() {
		//given
		UserRequest request = new UserRequestImpl();
		User user = new User("", "","ali.speed6@gmail.com", "","", "","", "","", 0,0);
		request.createUser(user);
		String name="Alastair";
		String sname="Vella";
		String username="ali.speed6@gmail.com";
		String password="Assignmentpass";
		String dob="11/12/1991";
		String type="free";
		String card="378282246310005";
		String exp="11/12/2017";
		String cvv="123";
		//when
		boolean result = reg.validateForm(name, sname, username, password, dob, type, card, exp, cvv);
		//then
		assertFalse(result);
	}
	
	@Test
	public void TestingValidateFormWithCorrectUserNameFieldTest() {
		//given
		String name="Alastair";
		String sname="Vella";
		String username="ali.speed6@gmail.com";
		String password="Assignmentpass";
		String dob="11/12/1991";
		String type="free";
		String card="378282246310005";
		String exp="11/12/2017";
		String cvv="123";
		//when
		boolean result = reg.validateForm(name, sname, username, password, dob, type, card, exp, cvv);
		//then
		assertTrue(result);
	}

}
