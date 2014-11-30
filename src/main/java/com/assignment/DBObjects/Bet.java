package com.assignment.DBObjects;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class Bet extends BasicDBObject {

	private static final long serialVersionUID = 1L;
	private int betId;
	private String risk;
	private double amount;
	private int userId;
	private String user;

	public Bet() {
	}

	public Bet(DBObject fromObject) {
		this.amount = (Double) fromObject.get("amount");
		this.betId = (Integer) fromObject.get("betId");
		this.risk = (String) fromObject.get("risk");
		this.userId = (Integer) fromObject.get("userId");
		this.put("_id", fromObject.get("_id"));
		populateMap();
	}

	public Bet(int betId, int userId, String risk, double amount) {
		this.betId = betId;
		this.risk = risk;
		this.amount = amount;
		this.userId = userId;
		populateMap();
	}

	public Bet(String risk, double amount, String user) {

		this.risk = risk;
		this.amount = amount;

		this.user = user;
		populateMap();
	}

	public void populateMap() {
		this.put("betId", betId);
		this.put("risk", risk);
		this.put("amount", amount);
		this.put("userId", userId);
		this.put("user", user);
	}

	public int getBetId() {
		return betId;
	}

	public void setUser(String user) {
		this.user = user;
		this.put("user", user);
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

	public double getAmmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
		this.put("amount", amount);
	}

	public void setUserId(int userId) {
		this.userId = userId;
		this.put("userId", userId);
	}

	public int getUserId() {
		return userId;
	}

}
