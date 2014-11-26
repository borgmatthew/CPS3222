package com.assignment.requests;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.assignment.DBObjects.Bet;
import com.assignment.mongodb.MongoDBWrapperImpl;
import com.mongodb.DBObject;

public class BettingRequestsImplTest {

	private BettingRequests bettingRequest;

	@Mock
	MongoDBWrapperImpl wrapper;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		bettingRequest = new BettingRequestsImpl(wrapper);
	}

	@Test
	public void testFindBet() {
		// given
		List<DBObject> query = new ArrayList<DBObject>();
		Bet bet1 = new Bet(1,1, "", 1.1);
		Bet bet2 = new Bet(1,1, "", 2);
		query.add(bet1);
		query.add(bet2);
		doReturn(query).when(wrapper).find(anyString(), anyString(),
				any(DBObject.class));
		// when
		List<Bet> fromDb = bettingRequest.findBet(new Bet());
		// then
		assertEquals(2, fromDb.size());
	}

}
