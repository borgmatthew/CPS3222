package com.assignment.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.assignment.functionalities.Login;
import com.assignment.functionalities.LoginImp;
import com.assignment.util.MessagePageImpl;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Login login;

	public void init() throws ServletException {
		login = new LoginImp();
	}

	private boolean isValidLogin(HttpServletRequest request) {
		boolean result = false;
		String username = request.getParameter("user");
		String password = request.getParameter("pass");
		if (login.validate(username, password)) {
			request.getSession().setAttribute("user", username);
			result = true;
		}
		return result;
	}

	private String printErrorPage() {
		return (new MessagePageImpl()).printMessagePageLoggedOut("Wrong username or password Please Try again");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (isValidLogin(request)) {
			response.sendRedirect("betting.jsp");
			return;
		}

		PrintWriter out = response.getWriter();
		out.println(printErrorPage());
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response){
	}
}
