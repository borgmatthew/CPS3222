package com.assignment.DBObjects;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class Bet extends BasicDBObject {

	private static final long serialVersionUID = 1L;
	private String risk;
	private double amount;
	private String user;

	public Bet() {
	}

	public Bet(DBObject fromObject) {
		this.amount = (Double) fromObject.get("amount");
		this.risk = (String) fromObject.get("risk");
		this.user = (String) fromObject.get("user");
		this.put("_id", fromObject.get("_id"));
		populateMap();
	}

	public Bet(String risk, double amount, String user) {

		this.risk = risk;
		this.amount = amount;

		this.user = user;
		populateMap();
	}

	public void populateMap() {
		this.put("risk", risk);
		this.put("amount", amount);
		this.put("user", user);
	}

	public void setUser(String user) {
		this.user = user;
		this.put("user", user);
	}
	
	public String getUser(){
		return user;
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((risk == null) ? 0 : risk.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bet other = (Bet) obj;
		if (Double.doubleToLongBits(amount) != Double
				.doubleToLongBits(other.amount))
			return false;
		if (risk == null) {
			if (other.risk != null)
				return false;
		} else if (!risk.equals(other.risk))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

}
