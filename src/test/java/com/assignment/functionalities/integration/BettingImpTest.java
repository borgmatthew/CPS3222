package com.assignment.functionalities.integration;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.assignment.DBObjects.Bet;
import com.assignment.DBObjects.User;
import com.assignment.functionalities.Betting;
import com.assignment.functionalities.BettingImp;
import com.assignment.requests.BettingRequests;
import com.assignment.requests.BettingRequestsImpl;
import com.assignment.requests.UserRequest;
import com.assignment.requests.UserRequestImpl;
import com.assignment.util.Props;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;

public class BettingImpTest {

	private Betting betting;
	private MongoClient client;
	private String user_dbname = Props.getProperty("user_db");
	private String user_tblname = Props.getProperty("user_tbl");
	private String bets_dbname = Props.getProperty("betting_db");
	private String bets_tblname = Props.getProperty("betting_tbl");

	@Before
	public void setUp() throws Exception {
		betting = new BettingImp();
		client = new MongoClient(Props.getProperty("host"),
				Integer.parseInt(Props.getProperty("port")));
	}

	@After
	public void tearDown() throws Exception {
		client.getDB(user_dbname).getCollection(user_tblname).remove(new BasicDBObject());
		client.getDB(bets_dbname).getCollection(bets_tblname).remove(new BasicDBObject());
		client.close();
	}

	@Test
	public void testValidateBetsEverythingValid() {
		//given
		UserRequest userRequest = new UserRequestImpl();
		User freeUser = new User("", "","user", "","", "free","", "","", 0,0);
		userRequest.createUser(freeUser);
		//when
		//then
		assertTrue(betting.validateBets("user", "Low", 5));	
	}
	
	@Test
	public void testValidateBetsInvalidRisk() {
		//given
		UserRequest userRequest = new UserRequestImpl();
		User freeUser = new User("", "","user", "","", "free","", "","", 0,0);
		userRequest.createUser(freeUser);
		//when
		//then
		assertFalse(betting.validateBets("user", "Medium", 5));
	}

	@Test
	public void testValidateBetsInvalidAmount() {
		//given
		UserRequest userRequest = new UserRequestImpl();
		User premUser = new User("", "","user", "","", "premium","", "","", 0,0);
		userRequest.createUser(premUser);
		//when
		//then
		assertFalse(betting.validateBets("user", "Low", 5001));	
	}
	
	@Test
	public void testGetAllBets(){
		//given
		Bet bet1 = new Bet("low", 1.0, "user1");
		Bet bet2 = new Bet("high", 2.0, "user1");
		BettingRequests bettingRequest = new BettingRequestsImpl();
		bettingRequest.createBet(bet1);
		bettingRequest.createBet(bet2);
		String expected = "<ul><li>low, 1.0</li><li>high, 2.0</li></ul>";
		//when
		String result = betting.getAllBets("user1");
		//then
		assertEquals(expected, result);
	}
}
