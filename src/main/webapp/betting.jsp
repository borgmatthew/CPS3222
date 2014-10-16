<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" type="text/css" href="css/betting.css">
</head>
<body>
	<%@ include file="headerLoggedIn.jsp"%>
	<div id="middle_container">
		<div id="main_content">
			<div id="betting_form_placeholder">
			<h1>Place your bet</h1>
				<form id="betting_form">
					<div id="risk_level">
						<label>Risk level</label> 
						<input type="radio" name="betrisk" value="Low">low
						<input type="radio"	name="betrisk" value="Medium">medium
						<input type="radio" name="betrisk" value="High">high
					</div>
					<div id="amount">
						<label>Amount:</label>
						<input class="fields" type="text" placeholder="amount">
					</div>
					<div id="submit_button_wrapper">
						<input id="submitButton" type="submit" value="Submit">
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>