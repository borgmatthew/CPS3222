<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" type="text/css" href="css/betting.css">
<script src="javascript/jquery-2.1.1.min.js"></script>
<script src="javascript/bettingPage.js"></script>
</head>
<body>
	<%@ page
		import="com.assignment.DBObjects.Bet,com.assignment.requests.BettingRequestsImpl, com.assignment.functionalities.BettingImp, com.assignment.functionalities.Betting"%>
	<%
		if (request.getSession(false).getAttribute("user") == null) {
			response.sendRedirect("index.jsp");
			return;
		}
	%>




	<%@ include file="headerLoggedIn.jsp"%>
	<div id="middle_container">
		<div id="main_content">
			<div id="betting_form_placeholder">
				<h1>Place your bet</h1>
				<form id="betting_form" method="post">
					<div id="risk_level">
						<label>Risk level</label> <input type="radio" name="betrisk"
							checked="checked" value="Low">low <input id="medium"
							type="radio" name="betrisk" value="Medium">medium <input
							id="High" type="radio" name="betrisk" value="High">high
					</div>
					<div id="amount">
						<label>Amount:</label> <input id="ammount" name="amm"
							class="fields" type="text" placeholder="amount"> <span
							id="ammount_error" class="status"></span>
					</div>
					<div id="submit_button_wrapper">
						<input id="submitButton" type="submit" value="Submit">
					</div>
				</form>
				<span id="Bett_error"></span>
				<div id="past_bets" class="status">
					<%
						Betting betting = new BettingImp();
						out.println(betting.getAllBets(session.getAttribute("user").toString()));
					%>
				</div>
			</div>
		</div>
	</div>
</body>
</html>