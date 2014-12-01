package com.assignment.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.assignment.functionalities.BettingImp;

public class BettingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BettingImp betval;
	private String message = "";
	private boolean success = false;

	public void init() throws ServletException {
		betval = new BettingImp();
	}

	private boolean validateBet(HttpServletRequest request) {
		boolean result = false;
		
		HttpSession session = request.getSession();
		
		String risk = request.getParameter("betrisk");
		if(risk == null){
			risk = "";
		}
		
		Double amount = -1.0;
		try {
			amount = Double.parseDouble(request.getParameter("amm"));
		} catch (NumberFormatException nfe) {
			message = "Invalid amount";
			amount = -1.0;
		} catch (NullPointerException npe) {
			message = "Invalid amount";
			amount = -1.0;
		}
		
		if (!betval.validateBets(session.getAttribute("user").toString(),
				risk, amount)) {
			message = "An error occured. Please try again.";
		} else {
			betval.addBet(risk, amount, session.getAttribute("user")
					.toString());
			message = "Bet placed successfully";
			success = true;
		}
		return result;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		if (session.getAttribute("user") == null) {
			response.sendRedirect("index.jsp");
			return;
		}
		
		validateBet(request);
		
		PrintWriter out = response.getWriter();
		out.println("{ \"success\" : \"" + success
				+ "\" , \"message\" : \"" + message + "\"}");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
	}
}
