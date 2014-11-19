<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" type="text/css" href="css/betting.css">
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="javascript/bettingPage.js"></script>
</head>
<body>
	<%@ page import="com.assignment.DBObjects.User"%>
	<%@ page import="com.assignment.requests.UserRequestImpl"%>
	<%@ page import="java.util.*"%>
	<% 
    
	 if ((session.getAttribute("user") == null) || (session.getAttribute("user") == "")) {
		/* session.setAttribute("user","");
		 session.invalidate();*/
		 
%>
	<%@ include file="headerLoggedOut.jsp"%>
	<div id="middle_container">
		<div id="main_content">

			You are not logged in<br />

		</div>
	</div>


	<%
}  else {
	
%>

	


	<%@ include file="headerLoggedIn.jsp"%>
	<div id="middle_container">
		<div id="main_content">
			<div id="betting_form_placeholder">
				<h1>Place your bet</h1>
				<form id="betting_form" method="POST" action="successfullBetting.jsp">
					<div id="risk_level">
						<label>Risk level</label> <input type="radio" name="betrisk"
							checked="checked" value="Low">low <input id="medium"
							type="radio" name="betrisk" value="Medium">medium <input
							id="High" type="radio" name="betrisk" value="High">high
					</div>
					<div id="amount">
						<label>Amount:</label> <input id="ammount" name="amm" class="fields"
							type="text" placeholder="amount"> <span
							id="ammount_error" class="status"></span>
					</div>
					<div id="submit_button_wrapper">
						<input id="submitButton" type="submit" value="Submit">
					</div>
				</form>
				<div id="past_ids"></div>
			</div>
		</div>
	</div>


	<%
}
%>

</body>
</html>