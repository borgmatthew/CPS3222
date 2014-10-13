<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" type="text/css" href="css/registration.css">
<script src="javascript/registrationpage_validation.js"></script>
<title>Insert title here</title>
</head>
<body>
	<%@ include file="headerLoggedOut.jsp"%>
	<div id="middle_container">
		<div id="main_content">
			<div id="reg_form">
				<form name="registrationform" onsubmit="return validateForm()">
					First name: <input class="fields" type="text" name="firstname"><br>
					Last name: <input  class="fields" type="text" name="lastname"><br>
					Username:<input  class="fields" type="text" name="username"><br>
					Password:<input  class="fields" type="password" name="password"><br>
					Date of Birth:<input  class="fields" type="date" name="dob"><br>
					<p>Account type
					</p>
						<input type="radio" name="account" value="free">Free<br>
						<input type="radio" name="account" value="premium">Premium<br>
						Credit card number:<input  class="fields" type="text" value="card"><br>
						Credit card Expiry date:<input class="fields" type="date" value="cardexp"><br>
						CVV:<input  class="fields" type="text" value="cvv"><br>
						<input type="submit" value="Submit">
				</form>
			</div>
		</div>
	</div>


</body>
</html>