package com.assignment.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.assignment.functionalities.Betting;
import com.assignment.functionalities.BettingImp;

public class BettingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Betting betval;
	private String message = "";

	public void init() throws ServletException {
		betval = new BettingImp();
	}

	public void setBettingImpl(Betting betting) {
		this.betval = betting;
	}

	private boolean validateBet(HttpServletRequest request) {
		boolean result = false;

		HttpSession session = request.getSession();

		String risk = request.getParameter("betrisk");
		if (risk == null) {
			risk = "";
			message = "Invalid risk";
			return result;
		}

		Double amount = -1.0;
		try {
			amount = Double.parseDouble(request.getParameter("amm"));
		} catch (NumberFormatException nfe) {
			message = "Invalid amount";
			amount = -1.0;
			return result;
		} catch (NullPointerException npe) {
			message = "Invalid amount";
			amount = -1.0;
			return result;
		}

		if (betval.validateBets(session.getAttribute("user").toString(), risk,
				amount)) {
			betval.addBet(risk, amount, session.getAttribute("user").toString());
			result = true;
		}
		message = betval.getMessage();
		return result;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		if (session.getAttribute("user") == null) {
			response.sendRedirect("index.jsp");
			return;
		}

		boolean success = validateBet(request);

		PrintWriter out = response.getWriter();
		out.println("{ \"success\" : \"" + success + "\" , \"message\" : \""
				+ message + "\"}");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
	}
}
