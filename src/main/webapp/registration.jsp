<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" type="text/css" href="css/registration.css">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="headerLoggedOut.jsp"%>
	<div id="middle_container">
		<div id="main_content">
			<div id="reg_form">
				<form>
					<label id="firstNameLabel">First name</label><input class="fields" type="text" name="firstname"><br>
					<label id="lastNameLabel">Last name</label><input  class="fields" type="text" name="lastname"><br>
					<label id="usernameLabel">Username</label><input  class="fields" type="text" name="username"><br>
					<label id="userPasswordLabel">Password</label><input  class="fields" type="password" name="password"><br>
					<label id="dobLabel">Date of Birth</label><input  class="fields" type="date" name="dob"><br>
					<label id="accountTypeLabel">Account Type</label>
						<input type="radio" name="account" value="free">Free<br>
						<input type="radio" name="account" value="premium">Premium<br>
					<label id="creditLabel">Credit card number</label><input  class="fields" type="text" value="card"><br>
					<label id="creditExpiryLabel">Credit card Expiry date</label><input class="fields" type="date" value="cardexp"><br>
					<label id="cvvLabelCVV">CVV</label><input  class="fields" type="text" value="cvv"><br>
						<input type="submit" value="Submit">
				</form>
			</div>
		</div>
	</div>


</body>
</html>