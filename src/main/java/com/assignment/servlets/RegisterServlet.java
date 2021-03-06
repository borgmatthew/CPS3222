package com.assignment.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.assignment.DBObjects.User;
import com.assignment.functionalities.Registration;
import com.assignment.functionalities.RegistrationImpl;
import com.assignment.requests.UserRequest;
import com.assignment.requests.UserRequestImpl;
import com.assignment.util.MessagePageImpl;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Registration registration;
	private UserRequest userRequest;
	private String message = "";

	public void init() throws ServletException {
		registration = new RegistrationImpl();
		userRequest = new UserRequestImpl();
	}

	public void setRegistration(Registration register) {
		registration = register;
	}
	
	public void setUserRequest(UserRequest request){
		userRequest = request;
	}

	private void validateRegistration(HttpServletRequest request) {
		String name = request.getParameter("firstname");
		String sname = request.getParameter("lastname");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String dob = request.getParameter("dob");
		String account = request.getParameter("account");
		String card = request.getParameter("card");
		String expdate = request.getParameter("expirydate");
		String cvv = request.getParameter("cvv");

		if (!registration.validateForm(name, sname, username, password, dob,
				account, card, expdate, cvv)) {
			message = registration.getMessage();
		} else {
			message = "Succesful registration. Please Login.";
			userRequest.createUser(new User(name, sname, username, password,
					dob, account, card, expdate, cvv, 0, 0));
		}
	}

	private String printMessagePage() {
		return (new MessagePageImpl()).printMessagePageLoggedOut(message);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		validateRegistration(request);
		PrintWriter out = response.getWriter();
		out.println(printMessagePage());
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
	}
}
