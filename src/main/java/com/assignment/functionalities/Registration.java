package com.assignment.functionalities;

public interface Registration {
	public boolean validateForm(String name,String sname,String username,String password,String dob,String account,String card,String expdate,String cvv);
	public String getMessage();
}
