package com.assignment.validations;

import java.util.ArrayList;
import java.util.Date;

public class RegistrationValidationImp implements RegistrationValidation {
	
	
	public boolean validateForm(String name,String sname,String username,String password,String dob,String account,String card,String expdate,String cvv){
		if(validateName(name)==false){					
	        return false;					
		}
		else{
			if(validateSName(sname)==false){
				return false;
			}
			else{
				if(validateUsername(username)==false){
					return false;
				}
				else{
					if(validatePassword(password)==false){
						return false;
					}
					else{
						return true;//need to continue
					}
				}
			}
			
		}
	}
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
	
	public boolean validateSName(String sname){
		String regex = "^[A-Za-z\\s]*";
		if(sname.matches(regex)){
			return true;
		}
		else{
			return false;
		}
	}
	public boolean validateUsername(String user){
		return true;
	}
	public boolean validatePassword(String pass){
		if(pass.length()<8){
			return false;
		}
		return true;
	}
	
	public boolean validateDOB(String dob){
		 Date today = new Date();   
		 String[] parts = dob.split("/");
		
		 String year=parts[2];
		 //Date myDate = new Date(year,month,date);
		 int birthyear=Integer.parseInt(year);
		 if(today.getYear()-birthyear<18){
			 return false;
		 }
		 
		 return true;
	}
	
	
	
	public boolean validateCard(String number) {
		luhn(number);
		return true;
    }

   private boolean luhn(String card){
	   int[] numbers=new int[card.length()];	   
	   String reverse = new StringBuilder().append(card).reverse().toString();
	   ArrayList<Integer> evens=new ArrayList<Integer>();
	   ArrayList<Integer> odds=new ArrayList<Integer>();
	   
	   for(int k=0;k<numbers.length;k++){
		   numbers[k]=Integer.parseInt(""+reverse.charAt(k));
		  
	   }
	   int totalOdds=0;
	   int totalEvens=0;
	   
	   for(int i=0;i<numbers.length;i++){
		   if(i%2==0){
			   totalOdds+=numbers[i];
			   odds.add(numbers[i]);
		   }
		   else{
			   totalEvens+=numbers[i];
			   evens.add(numbers[i]);
		   }
	   }
	   System.out.println(reverse);
	   for(int k=0;k<card.length();k++){
		   System.out.print(numbers[k]);
		  
	   }
	   return true;
   }
}
