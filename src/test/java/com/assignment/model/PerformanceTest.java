package com.assignment.model;

import static org.junit.Assert.assertEquals;
import nz.ac.waikato.modeljunit.Action;
import nz.ac.waikato.modeljunit.FsmModel;
import nz.ac.waikato.modeljunit.RandomTester;
import nz.ac.waikato.modeljunit.Tester;
import nz.ac.waikato.modeljunit.VerboseListener;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.assignment.SeleniumTesting.PopulateLoginForm;
import com.assignment.SeleniumTesting.PopulateLoginFormImp;

public class PerformanceTest implements FsmModel{

	private WebDriver browser;
	
	
	@Override
	public Object getState() {
		return States.Homepage;
	}

	@Override
	public void reset(boolean arg0) {
		browser = new FirefoxDriver();
		browser.get("http://localhost:8080/Assignment/");
	}
	
	public boolean loginGuard(){
		return getState().equals(States.Homepage);
	}
		
	@Action
	public void login(){
		PopulateLoginForm login = new PopulateLoginFormImp(browser);
		login.populateloginuserName("ali.speed6@gmail.com");
		login.populateloginpassword("Assignment");
		login.submit("login_button");
		assertEquals("http://localhost:8080/Assignment/betting.jsp", browser.getCurrentUrl());
	}
	
	@Test
	public void runner(){
		Tester t = new RandomTester(new PerformanceTest());
		t.addListener(new VerboseListener());
		t.generate(5);
		t.buildGraph();
	}

}
