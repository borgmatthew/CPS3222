package com.assignment.requests;

import java.util.List;

import com.assignment.DBObjects.Bets;

public interface BettingRequests {
	public boolean createBet(Bets bet);
	public List<Bets> findBet(Bets toFind);
}
