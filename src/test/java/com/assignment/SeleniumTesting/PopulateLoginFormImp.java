package com.assignment.SeleniumTesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PopulateLoginFormImp implements PopulateLoginForm{
	WebDriver browser;
	//Constructor
	public PopulateLoginFormImp(WebDriver brows){
		browser=brows;
	}
	
	private void waitForPageToLoad(){
		new WebDriverWait(browser, 10).until(ExpectedConditions.elementToBeClickable(By.id("username")));
	}
	
	public void visitLogin(){
		browser.get("http://localhost:8080/Assignment/index.jsp");
		waitForPageToLoad();
	}
	
	public void submit(String button){
		new WebDriverWait(browser, 10).until(ExpectedConditions.elementToBeClickable(By.id(button))).submit();
	}
	public void clear(String field){
		browser.findElement(By.id(field)).clear();
	}
	
	
	public List<WebElement> findById(String name){
		List<WebElement> paragraph=browser.findElements(By.id(name));
		return paragraph;
	}
	public void populateloginuserName(String usrname){
		new WebDriverWait(browser, 10).until(ExpectedConditions.elementToBeClickable(By.id("username"))).sendKeys(usrname);

	}
	public void populateloginpassword(String pass){
		new WebDriverWait(browser, 10).until(ExpectedConditions.elementToBeClickable(By.id("password"))).sendKeys(pass);

	}

}
