package com.assignment.DBObjects;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class User extends BasicDBObject{

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
	private long lockTime;

	public User(){
	}
	
	public User(DBObject fromObject){
		this.name = (String)fromObject.get("name");
		this.sname = (String) fromObject.get("surname");
		this.username = (String) fromObject.get("username");
		this.password = (String) fromObject.get("password");
		this.dob = (String) fromObject.get("dob");
		this.accounttype = (String) fromObject.get("type");
		this.creditcard = (String) fromObject.get("card_no");
		this.cvv = (String) fromObject.get("cvv");
		this.attempts = (Integer) fromObject.get("attempts");
		this.lockTime = (Long) fromObject.get("lockTime");
		this.put("_id", fromObject.get("_id"));
		populateMap();
	}
	
	public User(String name,String sname,String username,String pass,String dob,String  accounttyp,String card,String exp,String cvv, int attempts, long lockTime){
		this.name=name;
		this.sname=sname;
		this.username=username;
		this.password=pass;
		this.dob=dob;
		this.accounttype=accounttyp;
		this.creditcard=card;
		this.expdate=exp;
		this.cvv=cvv;
		this.attempts = attempts;
		this.lockTime = lockTime;
		populateMap();
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
		this.put("attempts", attempts);
		this.put("lockTime", lockTime);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		this.put("name", name);
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
		this.put("surname", sname);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
		this.put("username", username);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
		this.put("password", password);
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
		this.put("dob", dob);
	}
	
	public String getAccounttype() {
		return accounttype;
	}

	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
		this.put("type", accounttype);
	}

	public String getCreditcard() {
		return creditcard;
	}

	public void setCreditcard(String creditcard) {
		this.creditcard = creditcard;
		this.put("card_no", creditcard);
	}

	public String getExpdate() {
		return expdate;
	}

	public void setExpdate(String expdate) {
		this.expdate = expdate;
		this.put("expiry", expdate);
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
		this.put("cvv", cvv);
	}
	
	public int getAttempts() {
		return attempts;
	}

	public void setAttempts(int attempts) {
		this.attempts = attempts;
		this.put("attempts", attempts);
	}

	public long getLockTime() {
		return lockTime;
	}

	public void setLockTime(long lockTime) {
		this.lockTime = lockTime;
		this.put("lockTime", lockTime);
	}
}
