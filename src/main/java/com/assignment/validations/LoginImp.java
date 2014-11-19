package com.assignment.validations;

import java.util.List;

import com.assignment.DBObjects.User;
import com.assignment.requests.UserRequest;
import com.assignment.requests.UserRequestImpl;

public class LoginImp implements Login{

		public boolean validate(String username,String password){
			User user = new User();
			user.setUsername(username);
			UserRequest request = new UserRequestImpl();
			List<User> query = request.getUser(user);
			if(userExists(query)){
				user = query.get(0);
				if(canLogin(user)){
					if(validatePassword(user, password)){
						return true;
					}else{
						user.setAttempts(user.getAttempts() + 1);
						request.save(user);
					}
				}
			}
			return false;
		}
		
		public boolean userExists(List<User> users){
			return users.size() == 1;
		}
		
		public boolean canLogin(User user){
			return user.getAttempts() % 3 != 0;
		}
		
		public boolean validatePassword(User user, String password){
			return user.getPassword().compareTo(password) == 0;
		}
}
