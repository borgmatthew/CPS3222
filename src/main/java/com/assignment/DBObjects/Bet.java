package com.assignment.DBObjects;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class Bet extends BasicDBObject{
	
	private static final long serialVersionUID = 1L;
	private int betId;
	private String risk;
	private String amount;
	private int userId;
	
	public Bet(){
	}
	
	public Bet(DBObject fromObject){
		this.amount = (String) fromObject.get("amount");
		this.betId = (Integer) fromObject.get("betId");
		this.risk = (String) fromObject.get("risk");
		this.userId = (Integer) fromObject.get("userId");
		populateMap();
	}
	
	public Bet(int betId, int userId, String risk, String ammount) {
		this.betId = betId;
		this.risk = risk;
		this.amount = ammount;
		this.userId = userId;
		populateMap();
	}
	
	public void populateMap(){
		this.put("betId", betId);
		this.put("risk", risk);
		this.put("amount", amount);
		this.put("userId", userId);
	}

	public int getBetId() {
		return betId;
	}

	public void setBetId(int betId) {
		this.betId = betId;
		this.put("betId", betId);
	}

	public String getRisk() {
		return risk;
	}

	public void setRisk(String risk) {
		this.risk = risk;
		this.put("risk", risk);
	}

	public String getAmmount() {
		return amount;
	}

	public void setAmmount(String amount) {
		this.amount = amount;
		this.put("amount", amount);
	}
	
	public void setUserId(int userId){
		this.userId = userId;
		this.put("userId", userId);
	}
	
	public int getUserId(){
		return userId;
	}

}
