package com.assignment.requests;

import java.util.List;

import com.assignment.DBObjects.Bet;

public interface BettingRequests {
	public boolean createBet(Bet bet);
	public List<Bet> findBet(Bet toFind);
}
