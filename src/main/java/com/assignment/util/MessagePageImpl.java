package com.assignment.util;

public class MessagePageImpl implements MessagePage {

	@Override
	public String printMessagePageLoggedOut(String message) {
		return "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\"><html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\"><link rel=\"stylesheet\" type=\"text/css\" href=\"css/common.css\">"
				+ "<title>Error!</title></head>"
				+ (new MenuImpl()).getLoggedOutMenu()
				+ "<body><div id=\"middle_container\">"
				+ "<div id=\"main_content\">"
				+ "<div class=\"style\">"
				+ message
				+ "</div>"
				+ "</div></div></body></html>";
	}

}
