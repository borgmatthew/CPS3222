package com.assignment.validations;

import com.assignment.DBObjects.User;
import com.assignment.requests.UserRequest;
import com.assignment.requests.UserRequestImpl;

public class LoginImp implements Login{

		public boolean validate(String username,String pass){
			if(validateUsername(username)==false){
			return false;
			}
			return true;
		}
		
		public boolean validateUsername(String user){
			UserRequest request=new UserRequestImpl();
			User tempUser=new User();
			tempUser.setUsername(user);
			if(request.getUser(tempUser).size()>0){
				return true;
			}else{
				return false;
			}
		}
}
