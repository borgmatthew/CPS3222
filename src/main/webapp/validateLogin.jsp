<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/common.css">
<title>Insert title here</title>
</head>


<%@ page import="com.assignment.functionalities.LoginImp"%>
<%@ page import="javax.script.*;"%>
<% 
    //boolean flag=true;;
  
	   String username=request.getParameter("user");
	String password=request.getParameter("pass");
	
	//System.out.println(username);
	//System.out.println(password);
	
	LoginImp userlogin=new LoginImp();
	 if (userlogin.validate(username,password)) {
		 session.setAttribute("user", username);
		 session.setAttribute("bet","");
%>
<jsp:forward page="betting.jsp" />
<%
   }  else {
	   //session.setAttribute( "theName", "Wrong username" );
%>
<%@ include file="headerLoggedOut.jsp"%>
<div id="middle_container">
	<div id="main_content">
		<div class="style">Wrong username or password Please Try again</div>
	</div>
</div>


<%
   }
%>
</html>