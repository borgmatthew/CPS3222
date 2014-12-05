package com.assignment.SeleniumTesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PopulateBetFormImp implements PopulateBetForm {
	WebDriver browser;
	//Constructor
	
	public PopulateBetFormImp(WebDriver brows){
		browser=brows;
	}
	public void populateammount(String ammount){
		browser.findElement(By.id("ammount")).sendKeys(ammount+="\t");
	}
	public void submit(String button){
		browser.findElement(By.id(button)).submit();
	}
	public List<WebElement> findById(String name){
		List<WebElement> paragraph=browser.findElements(By.id(name));
		return paragraph;
	}
	public void visit(){
		browser.get("http://localhost:8080/Assignment/betting.jsp");
	}
	public void close(){
		browser.quit();
	}
	
	public String getUrl(){
		return browser.getCurrentUrl();
	}

}
