<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" type="text/css" href="css/registration.css">
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
 <script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="javascript/registrationPage.js"></script>
<title>OBD - The Online Betting Company</title>
</head>
<body>


	<%@ include file="headerLoggedOut.jsp"%>
	<div id="middle_container">
		<div id="main_content">
			<div id="reg_form">
				<form id="registrationForm" name="registrationform" method="POST" action="succesfulRegistration.jsp">
					<div class="prompt">
						<label id="firstNameLabel">First name</label> 
						<input id="firstName" class="fields" type="text" name="firstname" /> 
						<span id="name_error" class="status"></span>
					</div>
					<div class="prompt">
						<label id="lastNameLabel">Last name</label>
						<input id="lastName" class="fields" type="text" name="lastname" />
						<span id="surname_error" class="status"></span>
					</div>
					<div class="prompt">
						<label id="usernameLabel">Username</label>
						<input class="fields" type="text" name="username">
					</div>
					<div class="prompt">
						<label id="userPasswordLabel">Password</label>
						<input class="fields" id="password" type="password" name="password" />
						<span id="password_error" class="status"></span>
					</div>
					<div class="prompt">
						<label id="dobLabel">Date of Birth</label>
						<input  class="fields" id='dob' type="date" name="dob" />
						<span id="dob_error" class="status"></span>
					</div>
					<div class="prompt">
						<label id="accountTypeLabel">Account Type</label> <input
							type="radio"  id="account" checked="checked" name="account" value="free">Free <input
							type="radio" id="account1" name="account" value="premium">Premium
							<span id="account_error" class="status"></span>
					</div>
					<div class="prompt">
						<label id="creditLabel">Credit card number</label>
						<input class="fields" id="creditcard" type="text" placeholder="card number" />
						<span id="creditcard_error" class="status"></span>
						
					</div>
					<div class="prompt">
						<label id="creditExpiryLabel">Expiry date</label>
						<input class="fields" id="expiry_date" type="date" placeholder="card expiry date" />
						<span id="expiry_error" class="status"></span>
					</div>
					<div class="prompt">
						<label id="cvvLabelCVV">CVV</label>
						<input class="fields" id="cvv" type="text" placeholder="cvv" />
						<span id="cvv_error" class="status"></span>
					</div>
					<input id="submitButton" type="submit"  value="Register">
				</form>
			</div>
		</div>
	</div>
</body>
</html>