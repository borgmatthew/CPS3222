package com.assignment.SeleniumTesting;

import java.util.List;

import org.openqa.selenium.WebElement;

public interface PopulateBetForm {
	public void populateammount(String ammount);
	public void submit(String button);
	public List<WebElement> findById(String name);
	public void visit();
	public void setRisk(String risk);
	public String getUrl();
}
