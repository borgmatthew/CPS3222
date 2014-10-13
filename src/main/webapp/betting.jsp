<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" type="text/css" href="css/registration.css">
</head>
<body>
	<%@ include file="headerLoggedIn.jsp"%>
	<div id="middle_container">
		<div id="main_content">
			<div id="reg_form">
				<form>
					<p>Risk level</p>
					<input type="radio" name="betrisk" value="Low">low<br>
					<input type="radio" name="betrisk" value="Medium">medium<br>
					<input type="radio" name="betrisk" value="High">high<br>

					Ammount:<input class="fields" type="text" value="ammount"><br>

					<input type="submit" value="Submit">
				</form>
			</div>
		</div>
	</div>

</body>
</html>