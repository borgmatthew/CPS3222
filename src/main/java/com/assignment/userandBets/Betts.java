package com.assignment.userandBets;

public class Betts {
	
	private int betId;
	private String risk;
	private String ammount;
	
	public Betts(int betId, String risk, String ammount) {
		super();
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
	
	

}
