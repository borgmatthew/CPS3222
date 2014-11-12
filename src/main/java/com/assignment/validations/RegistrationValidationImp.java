package com.assignment.validations;

import java.text.SimpleDateFormat;
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
						if(validateDOB(dob)==false){
							return true;
						}
						else{
							if(validateCard(card)==false){	
								return false;
							}
							else{
								if(validateEXP(expdate)==false){
									return false;
								}
								else{
									if(validateCvv(cvv)==false){
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
		 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		   Date date;
		   try{
		  date  = sdf.parse(dob);
		   }catch(Exception e){
			   return false;
		   }
		   Date today = new Date();   
			if(today.getYear()-date.getYear()<18){
				return false;
			}
			 
			 return true;
	   }
		
		
		
		
		
		
		
		
		/*Date today = new Date();   
		 String[] parts = dob.split("/");
		
		 String year=parts[2];
		 //Date myDate = new Date(year,month,date);
		 int birthyear=Integer.parseInt(year);
		 if(today.getYear()-birthyear<18){
			 return false;
		 }
		 
		 return true;*/
	
	
	
	
	public boolean validateCard(String number) {
		if(isAmerican(number) || isVisa(number) || isMaster(number)){
			return true;
		}
		else{
			return false;
		}
    }
	private boolean isMaster(String card){
		if(luhn(card) && card.length()==16 && ((card.charAt(0)=='5' && card.charAt(1)=='1')||(card.charAt(0)=='5' && card.charAt(1)=='2')||(card.charAt(0)=='5' && card.charAt(1)=='3')||(card.charAt(0)=='5' && card.charAt(1)=='4')||(card.charAt(0)=='5' && card.charAt(1)=='5'))){
			return true;
		}
		else{
			return false;
		}
	}
	private boolean isAmerican(String card){
		if(((card.charAt(0)=='3' && card.charAt(1)=='4') || (card.charAt(0)=='3' && card.charAt(1)=='7')) && card.length()==15 && luhn(card)){
			return true;
		}
		else{
			return false;
		}
	}
	private boolean isVisa(String card){
		if(card.charAt(0)=='4' && (card.length()==13 || card.length()==16) && luhn(card)){
			return true;
		}
		else{
			return false;
		}
	}

   private boolean luhn(String card){
	   int[] numbers=new int[card.length()];	   
	   String reverse = new StringBuilder().append(card).reverse().toString();
	   ArrayList<Integer> evens=new ArrayList<Integer>();
	   ArrayList<Integer> odds=new ArrayList<Integer>();
	   ArrayList<Integer> evendoubles=new ArrayList<Integer>();
	   
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
			   
			   evens.add(numbers[i]);
		   }
	   }
	   for(int i=0;i<evens.size();i++){
		   //evendoubles.add(2*evens.get(i));
		   int temp=2*evens.get(i);
		   String strtemp=Integer.toString(temp);
		   if(strtemp.length()==2){
			   char tempchar=strtemp.charAt(0);
			   char tempchar1=strtemp.charAt(1);
			   int temptotal=Integer.parseInt(""+tempchar)+Integer.parseInt(""+tempchar1);
			   totalEvens+=temptotal;
		   }
		   else{
			   totalEvens+=Integer.parseInt(strtemp);
		   }
	   }
	   
	   int total=totalOdds+totalEvens;
	   if(total%10==0){
		   return true;
	   }
	   else{
		   return false;
	   }
	  
   }
   
   public boolean validateEXP(String expdate){
	   SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	   Date expirydate;
	   try{
	  expirydate  = sdf.parse(expdate);
	   }catch(Exception e){
		   return false;
	   }
	   Date today = new Date();   
		if(expirydate.after(today)){
			return true;
		}
		 
		 return false;
   }
   
   public boolean validateCvv(String cvv){
	   String regex = "^[0-9\\s]{3}";
		if(cvv.matches(regex)){
			return true;
		}
		else{
			return false;
		}
   }
}
