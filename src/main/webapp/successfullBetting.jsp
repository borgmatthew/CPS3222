<%@ page import="com.assignment.functionalities.BettingImp"%>
<%
	if (session.getAttribute("user") == null) {
		response.sendRedirect("index.jsp");
	}

	String message = "";
	boolean success = false;

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

	String risk = request.getParameter("betrisk");
	if(risk == null){
		risk = "";
	}

	//validate
	BettingImp betval = new BettingImp();
	if (!betval.validateBets(session.getAttribute("user").toString(),
			risk, amount)) {
		message = "An error occured. Please try again.";
	} else {
		betval.addBet(risk, amount, session.getAttribute("user")
				.toString());
		message = "Bet placed successfully";
		success = true;
	}
	out.println("{ \"success\" : \"" + success
			+ "\" , \"message\" : \"" + message + "\"}");
%>