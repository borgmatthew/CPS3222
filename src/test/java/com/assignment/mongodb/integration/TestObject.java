package com.assignment.mongodb.integration;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class TestObject extends BasicDBObject {

	private static final long serialVersionUID = 1L;

	int var1 = 0;
	String var2 = "";
	
	public TestObject(){	
	}
	
	public TestObject(DBObject test){
		this.var1 = (Integer) test.get("var1");
		this.var2 = (String) test.get("var2");
		this.put("var1", var1);
		this.put("var2", var2);
		this.put("_id", test.get("_id"));
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + var1;
		result = prime * result + ((var2 == null) ? 0 : var2.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		TestObject other = (TestObject) obj;
		if (var1 != other.var1)
			return false;
		if (var2 == null) {
			if (other.var2 != null)
				return false;
		} else if (!var2.equals(other.var2))
			return false;
		return true;
	}
}
