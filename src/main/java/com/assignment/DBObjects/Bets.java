package com.assignment.DBObjects;

public class Bets {
	
	private int betId;
	private String risk;
	private String ammount;
	private int userId;
	
	public Bets(int betId, int userId, String risk, String ammount) {
		this.betId = betId;
		this.risk = risk;
		this.ammount = ammount;
	}

	public int getBetId() {
		return betId;
	}

	public void setBetId(int betId) {
		this.betId = betId;
	}

	public String getRisk() {
		return risk;
	}

	public void setRisk(String risk) {
		this.risk = risk;
	}

	public String getAmmount() {
		return ammount;
	}

	public void setAmmount(String ammount) {
		this.ammount = ammount;
	}
	
	public void setUserId(int userId){
		this.userId = userId;
	}
	
	public int getUserId(){
		return userId;
	}

}
