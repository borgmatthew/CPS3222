package com.assignment.validations;

public interface RegistrationValidation {
	public boolean validateName(String name);
	public boolean validateSName(String name);
	public boolean validateUsername(String username);
	public boolean validatePassword(String password);
	public boolean validateDOB(String dob);
	public boolean validateCard(String account);
	public boolean validateEXP(String date);
	public boolean validateCvv(String cvv);
}
