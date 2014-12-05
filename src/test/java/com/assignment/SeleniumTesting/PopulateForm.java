package com.assignment.SeleniumTesting;

import java.util.List;

import org.openqa.selenium.WebElement;

public interface PopulateForm {
	
	public void visit();
	public void close();
	public void populate();
	public void submit();
	public void clear(String field);
	public List<WebElement> findById(String name);
	public List<WebElement> findByClass(String classname);
	public  void populateName(String name);
	public void populateEmptyName();
	public void populateSName(String sname);
	public void populateEmptySName();
	public void populatePassword(String pass);
	public void populateEmptyDOB();
	public void populateDOB(String dob);
	public void populateEmptyCard();
	public void populateCard(String card);
	public void populateExpDate(String date);
	public void populateCvv(String date);
	public void populateEmptyCvv();
	public void submitForm();
}
