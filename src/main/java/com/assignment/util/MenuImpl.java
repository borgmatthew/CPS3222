package com.assignment.util;

public class MenuImpl implements Menu {

	@Override
	public String getLoggedInMenu() {
		return includeCss() + "<div id=\"menu_bar\">"
				+ "<div id=\"menu_wrapper\">"
				+ "<div id=\"logo\">OBC - The Online Betting Company</div>"
				+ "<div id=\"links\"><a href=\"logOut.jsp\">Logout</a></div>"
				+ "</div></div>";
	}

	@Override
	public String getLoggedOutMenu() {
		return includeCss() + "<div id=\"menu_bar\">"
				+ "<div id=\"menu_wrapper\">"
				+ "<div id=\"logo\">OBC - The Online Betting Company</div>"
				+ "<div id=\"links\"><a href=\"index.jsp\">Login</a> | <a href=\"registration.jsp\">Register</a></div>"
				+ "</div></div>";
	}
	
	private String includeCss(){
		return "<link rel=\"stylesheet\" type=\"text/css\" href=\"css/header.css\">";
	}

}
