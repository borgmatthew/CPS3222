package com.assignment.mongodb.integration;

import com.mongodb.BasicDBObject;

public class TestObject extends BasicDBObject {

	private static final long serialVersionUID = 1L;

	int var1 = 0;
	String var2 = "";
	
	public TestObject(){	
	}
	
	public TestObject(int var1, String var2){
		this.var1 = var1;
		this.var2 = var2;
		this.put("var1", var1);
		this.put("var2", var2);
	}
	
	public int getVar1() {
		return var1;
	}

	public void setVar1(int var1) {
		this.var1 = var1;
		this.put("var1", var1);
	}

	public String getVar2() {
		return var2;
	}

	public void setVar2(String var2) {
		this.var2 = var2;
		this.put("var2", var2);
	}
}
