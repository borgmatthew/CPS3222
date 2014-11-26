package com.assignment.functionalities;

public interface Betting {
	public String getAllBets(String user);
	public boolean validateBets(String user, String risk, double amount);
	public void addBet(String risk, double amount, String user);
}
