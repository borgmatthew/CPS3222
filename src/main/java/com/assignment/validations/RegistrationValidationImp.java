package com.assignment.validations;

public class RegistrationValidationImp implements RegistrationValidation {
	
	public boolean validateName(String name){
		
		//int len=name.length();
		String regex = "^[A-Za-z\\s]*";
		if(name.matches(regex)){
			return true;
		}
		else{
			return false;
		}
	}

}
