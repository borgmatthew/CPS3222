package com.assignment.requests;

import java.util.ArrayList;
import java.util.List;

import com.assignment.DBObjects.Bets;
import com.assignment.mongodb.MongoDBWrapper;
import com.assignment.mongodb.MongoDBWrapperImpl;
import com.mongodb.DBObject;

public class BettingRequestsImpl implements BettingRequests {

	MongoDBWrapper dbWrapper;
	
	public BettingRequestsImpl() {
		dbWrapper = new MongoDBWrapperImpl("localhost", 27017);
		// TODO load properties from properties file
	}
	
	public BettingRequestsImpl(MongoDBWrapper wrapper){
		dbWrapper = wrapper;
	}
	
	@Override
	public boolean createBet(Bets bet) {
		return dbWrapper.insert("SoftwareTesting", "Bets", bet);
	}

	@Override
	public List<Bets> findBet(Bets toFind) {
		List<DBObject> query = dbWrapper.find("SoftwareTesting", "Bets", toFind);
		List<Bets> result = new ArrayList<Bets>(query.size());
		for(DBObject o : query){
			result.add(new Bets(o));
		}
		return result;
	}

	@Override
	public boolean saveBet(Bets toSave) {
		return dbWrapper.insert("SoftwareTesting", "Bets", toSave);
	}
}
