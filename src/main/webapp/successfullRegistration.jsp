<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" type="text/css" href="css/succesfulRegistration.css">
<title>Insert title here</title>
</head>
<body>
		<%@ include file="headerLoggedOut.jsp"%>
		<%@ page import="com.assignment.validations.RegistrationValidationImp" %>
		<%@ page import="com.assignment.DBObjects.User" %>
		<%@ page import="javax.script.*;" %>
		
		<%-- Java code to validate form --%>
		<%
			RegistrationValidationImp validation=new RegistrationValidationImp();
				
				String name=request.getParameter("firstname");
				String sname=request.getParameter("lastname");
				String username=request.getParameter("username");
				String password=request.getParameter("password");
				String dob=request.getParameter("dob");
				String account=request.getParameter("account");
				String card=request.getParameter("card");
				String expdate=request.getParameter("expirydate");
				String cvv=request.getParameter("cvv");
				
				System.out.println(validation.validateName("6"));
				
				String message="";
				if(validation.validateName(name)==false){					
			        message ="Something went wrong";					
				}
				else{
					//need to continue from here
					message="Succesful registration. Please Login.";
					
				}
				//User user=new User(name,sname,username,password,dob,account,card,expdate,cvv);
				
				/*System.out.println(name);
				System.out.println(sname);
				System.out.println(username);
				System.out.println(password);
				System.out.println(dob);
				System.out.println(account);
				System.out.println(card);
				System.out.println(expdate);
				System.out.println(cvv);*/
		%>
		
		
	<div id="middle_container">
		<div id="main_content">
		<div class="style">
			<p id="parag"><font size="6"><% out.println(message); %></font></p>
			
		</div>
		</div>
	</div>
</body>
</html>