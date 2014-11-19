<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/common.css">
<title>Insert title here</title>
</head>
<body>
<%@ page import="com.assignment.functionalities.BettingImp"%>
<%

	String ammount=request.getParameter("amm");
	String risk=request.getParameter("betrisk");
	
	System.out.println(ammount);
	System.out.println(risk);
	System.out.println(session.getAttribute("user"));
	
	String message="";
	BettingImp betval=new BettingImp();
	if(betval.validateBets(session.getAttribute("user").toString(),risk,ammount)==false){					
        message =betval.getMessage();	
       
	}
	else{ %>
		//message="Bet Succesful to make another bet click here.";
		//need to add bet here.
		 alert("Bet succesful");
	<%}

%>
<%@ include file="headerLoggedIn.jsp"%>
<div id="middle_container">
		<div id="main_content">
			<div class="style">
				<p id="parag">
					<font size="6">
						<%out.println(message); %>
					</font>
				</p>

			</div>
		</div>
	</div>
</body>
</html>