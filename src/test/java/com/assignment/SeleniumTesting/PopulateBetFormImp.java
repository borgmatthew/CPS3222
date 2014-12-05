package com.assignment.SeleniumTesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PopulateBetFormImp implements PopulateBetForm {
	WebDriver browser;

	// Constructor

	public PopulateBetFormImp(WebDriver brows) {
		browser = brows;
	}

	public void populateammount(String ammount) {
		new WebDriverWait(browser, 10).until(ExpectedConditions.elementToBeClickable(By.id("ammount"))).sendKeys(ammount);
	}

	public void setRisk(String risk){
		new WebDriverWait(browser, 10).until(ExpectedConditions.elementToBeClickable(By.id(risk))).click();
	}	
	
	public void submit(String button) {
		new WebDriverWait(browser, 10).until(ExpectedConditions.elementToBeClickable(By.id(button))).submit();
	}

	public List<WebElement> findById(String name) {
		List<WebElement> paragraph = browser.findElements(By.id(name));
		return paragraph;
	}

	public void visit() {
		browser.get("http://localhost:8080/Assignment/betting.jsp");
	}

	public String getUrl() {
		return browser.getCurrentUrl();
	}

}
