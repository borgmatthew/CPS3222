package com.assignment.DBObjects;

import com.mongodb.BasicDBObject;

public class User extends BasicDBObject{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name = "";
	private String sname = "";
	private String username = "";
	private String password = "";
	private String dob = "";
	private String accounttype = "";
	private String creditcard = "";
	private String expdate = "";
	private String cvv = "";
	private int attempts = 0;

	public User(){
	}
	
	public User(String name,String sname,String username,String pass,String dob,String  accounttyp,String card,String exp,String cvv){
		this.name=name;
		this.sname=sname;
		this.username=username;
		this.password=pass;
		this.dob=dob;
		this.accounttype=accounttyp;
		this.creditcard=card;
		this.expdate=exp;
		this.cvv=cvv;
	}
	
	public void populateMap(){
		this.put("name", name);
		this.put("surname", sname);
		this.put("username", username);
		this.put("password", password);
		this.put("dob", dob);
		this.put("type", accounttype);
		this.put("card_no", creditcard);
		this.put("expiry", expdate);
		this.put("cvv", cvv);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAccounttype() {
		return accounttype;
	}

	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}

	public String getCreditcard() {
		return creditcard;
	}

	public void setCreditcard(String creditcard) {
		this.creditcard = creditcard;
	}

	public String getExpdate() {
		return expdate;
	}

	public void setExpdate(String expdate) {
		this.expdate = expdate;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	
	public int getAttempts() {
		return attempts;
	}

	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}
}
