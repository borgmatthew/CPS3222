package com.assignment.requests;

import java.util.ArrayList;
import java.util.List;

import com.assignment.DBObjects.Bet;
import com.assignment.mongodb.MongoDBWrapper;
import com.assignment.mongodb.MongoDBWrapperImpl;
import com.assignment.util.Props;
import com.mongodb.DBObject;

public class BettingRequestsImpl implements BettingRequests {

	MongoDBWrapper dbWrapper;
	
	public BettingRequestsImpl() {
		dbWrapper = new MongoDBWrapperImpl(Props.getProperty("host"), Integer.parseInt(Props.getProperty("port")));
	}
	
	public BettingRequestsImpl(MongoDBWrapper wrapper){
		dbWrapper = wrapper;
	}
	
	@Override
	public boolean createBet(Bet bet) {
		return dbWrapper.insert(Props.getProperty("betting_db"), Props.getProperty("betting_tbl"), bet);
	}

	@Override
	public List<Bet> findBet(Bet toFind) {
		List<DBObject> query = dbWrapper.find(Props.getProperty("betting_db"), Props.getProperty("betting_tbl"), toFind);
		List<Bet> result = new ArrayList<Bet>(query.size());
		for(DBObject o : query){
			result.add(new Bet(o));
		}
		return result;
	}

	@Override
	public boolean saveBet(Bet toSave) {
		return dbWrapper.insert(Props.getProperty("betting_db"), Props.getProperty("betting_tbl"), toSave);
	}
}
