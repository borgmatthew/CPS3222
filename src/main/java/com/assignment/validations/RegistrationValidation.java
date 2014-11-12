package com.assignment.validations;

public interface RegistrationValidation {
	public boolean validateForm(String name,String sname,String username,String password,String dob,String account,String card,String expdate,String cvv);
	public boolean validateName(String name);
	public boolean validateSName(String name);
	public boolean validateUsername(String username);
	public boolean validatePassword(String password);
	public boolean validateDOB(String dob);
	public boolean validateCard(String account);
}
