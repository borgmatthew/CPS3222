package com.assignment.requests.integration;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.assignment.DBObjects.Bet;
import com.assignment.requests.BettingRequests;
import com.assignment.requests.BettingRequestsImpl;
import com.assignment.util.Props;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;

public class BettingRequestsImplTest {

	private BettingRequests bettingRequest;
	private MongoClient client;
	private String dbname = Props.getProperty("betting_db");
	private String tblname = Props.getProperty("betting_tbl");

	@Before
	public void setUp() throws Exception {
		bettingRequest = new BettingRequestsImpl();
		client = new MongoClient(Props.getProperty("host"),
				Integer.parseInt(Props.getProperty("port")));
	}

	@After
	public void tearDown() throws Exception {
		client.getDB(Props.getProperty("betting_db"))
				.getCollection(Props.getProperty("betting_tbl"))
				.remove(new BasicDBObject());
		client.close();
	}

	@Test
	public void testCreateBetRiskSavedCorrectly() {
		// given
		Bet b = new Bet("low", 2.0, "testUser");
		// when
		bettingRequest.createBet(b);
		Bet fromDb = new Bet(client.getDB(dbname).getCollection(tblname)
				.find(b).toArray().get(0));
		// then
		assertEquals("low", fromDb.getRisk());
	}

	@Test
	public void testCreateBetAmountSavedCorrectly() {
		// given
		Bet b = new Bet("low", 2.0, "testUser");
		// when
		bettingRequest.createBet(b);
		Bet fromDb = new Bet(client.getDB(dbname).getCollection(tblname)
				.find(b).toArray().get(0));
		// then
		assertEquals(2.0, fromDb.getAmmount(), 0);
	}

	@Test
	public void testCreateBetUserSavedCorrectly() {
		// given
		Bet b = new Bet("low", 2.0, "testUser");
		// when
		bettingRequest.createBet(b);
		Bet fromDb = new Bet(client.getDB(dbname).getCollection(tblname)
				.find(b).toArray().get(0));
		// then
		assertEquals("testUser", fromDb.getUser());
	}

	@Test
	public void testFindBetOneBet() {
		// given
		Bet b = new Bet("low", 2.0, "testUser");
		// when
		bettingRequest.createBet(b);
		List<Bet> fromDb = bettingRequest.findBet(b);
		// then
		assertEquals(b, fromDb.get(0));
	}

	@Test
	public void testFindMultipleBets() {
		// given
		Bet b = new Bet("low", 2.0, "testUser");
		Bet c = new Bet("high", 100.0, "testUser");
		Bet d = new Bet("medium", 3.0, "user2");
		Bet search = new Bet();
		search.setUser("testUser");
		// when
		bettingRequest.createBet(b);
		bettingRequest.createBet(c);
		bettingRequest.createBet(d);
		List<Bet> fromDb = bettingRequest.findBet(search);
		// then
		assertEquals(2, fromDb.size());
	}
}
