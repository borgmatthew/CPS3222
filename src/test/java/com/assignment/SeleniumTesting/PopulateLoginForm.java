package com.assignment.SeleniumTesting;

import java.util.List;

import org.openqa.selenium.WebElement;

public interface PopulateLoginForm {
	public void visitLogin();
	public void submit(String button);
	public void clear(String field);
	public List<WebElement> findById(String name);
	public void populateloginuserName(String usrname);
	public void populateloginpassword(String pass);
}
