package com.assignment.functionalities;

import com.assignment.DBObjects.User;
import com.assignment.requests.UserRequestImpl;
import com.assignment.validations.RegistrationValidationImp;

public class RegistrationImp implements Registration{
private String message="";
	
	public boolean validateForm(String name,String sname,String username,String password,String dob,String account,String card,String expdate,String cvv){
		RegistrationValidationImp validation=new RegistrationValidationImp();
		if(validation.validateName(name)==false){	
			message="Invalid name";
	        return false;					
		}
		else{
			if(validation.validateSName(sname)==false){
				message="Invalid surname";
				return false;
			}
			else{
				if(validation.validateUsername(username)==false){
					message="Username already exists";
					return false;
				}
				else{
					if(validation.validatePassword(password)==false){
						message="Invalid password";
						return false;
					}
					else{
						if(validation.validateDOB(dob)==false){
							message="invalid Date of Birth";
							return false;
						}
						else{
							if(validation.validateCard(card)==false){	
								message="Invalid Card number";
								return false;
							}
							else{
								if(validation.validateEXP(expdate)==false){
									message="Invalid Expiry date";
									return false;
								}
								else{
									if(validation.validateCvv(cvv)==false){
										message="Invalid CVV number";
										return false;
									}
									else{										
										return true;
									}
								}
							}
						}
					}
				}
			}
			
		}
	}
	public String getMessage(){
		return message;
	}
	
	public void addUser(String name,String sname,String username,String password,String dob,String account,String card,String expdate,String cvv){
		 UserRequestImpl userRequest=new UserRequestImpl();
		User newUser=new User(name,sname,username,password,dob,account,card,expdate,cvv,0);
		 userRequest.createUser(newUser);
	}

}
