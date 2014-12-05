package com.assignment.SeleniumTesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PopulateLoginFormImp implements PopulateLoginForm{
	WebDriver browser;
	//Constructor
	public PopulateLoginFormImp(WebDriver brows){
		browser=brows;
	}
	
	public void visitLogin(){
		browser.get("http://localhost:8080/Assignment");
	}
	public void close(){
		browser.quit();
	}
	
	public void submit(String button){
		browser.findElement(By.id(button)).submit();
	}
	public void clear(String field){
		browser.findElement(By.id(field)).clear();
	}
	
	
	public List<WebElement> findById(String name){
		List<WebElement> paragraph=browser.findElements(By.id(name));
		return paragraph;
	}
	public void populateloginuserName(String usrname){
		browser.findElement(By.id("username")).sendKeys(usrname+="\t");

	}
	public void populateloginpassword(String pass){
		browser.findElement(By.id("password")).sendKeys(pass+="\t");

	}

}
