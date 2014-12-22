package com.assignment.SeleniumTesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PopulateFormImp implements PopulateForm {
	WebDriver browser;
	//Constructor
	public PopulateFormImp(WebDriver brows){
		browser=brows;
	}
	
	public void visit(){
		browser.get("http://localhost:8080/Assignment/registration.jsp");
	}
	
	public void close(){
		browser.quit();
	}
	
	public void populate(){
		browser.findElement(By.id("firstName")).sendKeys("Alastair");
		browser.findElement(By.id("lastName")).sendKeys("Vella");		
		browser.findElement(By.id("userName")).sendKeys("ali.speed6@gmail.com");
		browser.findElement(By.id("password")).sendKeys("Assignment");
		browser.findElement(By.id("dob")).sendKeys("01/08/1991");
		browser.findElement(By.id("creditcard")).sendKeys("378282246310005");
		browser.findElement(By.id("expiry_date")).sendKeys("01/08/2017");
		browser.findElement(By.id("cvv")).sendKeys("123");
	}
	
	public void populate(String user, String password, String type){
		if(type.compareTo("premium") == 0){
			new WebDriverWait(browser, 10).until(ExpectedConditions.elementToBeClickable(By.id("account1"))).click();
		}
		browser.findElement(By.id("firstName")).sendKeys("Alastair");
		browser.findElement(By.id("lastName")).sendKeys("Vella");		
		browser.findElement(By.id("userName")).sendKeys(user);
		browser.findElement(By.id("password")).sendKeys(password);
		browser.findElement(By.id("dob")).sendKeys("01/08/1991");
		browser.findElement(By.id("creditcard")).sendKeys("378282246310005");
		browser.findElement(By.id("expiry_date")).sendKeys("01/08/2017");
		browser.findElement(By.id("cvv")).sendKeys("123");
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
	public List<WebElement> findByClass(String classname){
		return browser.findElements(By.className("status"));
	}
	
	
	
	public void populateName(String name){
		browser.findElement(By.id("firstName")).sendKeys(name+="\t");

	}
	public void populateEmptyName(){
		browser.findElement(By.id("firstName")).sendKeys("\t");

	}
	public void populateEmptySName(){
		browser.findElement(By.id("lastName")).sendKeys("\t");

	}
	public void populateSName(String sname){
		browser.findElement(By.id("lastName")).sendKeys(sname+="\t");

	}
	
	public void populatePassword(String pass){
		browser.findElement(By.id("password")).sendKeys(pass+="\t");
	}
	
	public void populateDOB(String dob){
		browser.findElement(By.id("dob")).sendKeys(dob+="\t");

	}
	
	public void populateEmptyDOB(){
		browser.findElement(By.id("dob")).sendKeys("\t");
	}
	
	public void populateCard(String card){
		browser.findElement(By.id("creditcard")).sendKeys(card+="\t");

	}
	
	public void populateEmptyCard(){
		browser.findElement(By.id("creditcard")).sendKeys("\t");
	}
	
	public void populateExpDate(String exp){
		browser.findElement(By.id("expiry_date")).sendKeys(exp+="\t");

	}
	public void populateCvv(String cvv){
		browser.findElement(By.id("cvv")).sendKeys(cvv+="\t");

	}
	public void populateEmptyCvv(){
		browser.findElement(By.id("cvv")).sendKeys("\t");

	}
	
	public void submitForm(){
		browser.findElement(By.id("submitButton")).submit();
	}
	
}
