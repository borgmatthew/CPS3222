package com.assignment.model;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import nz.ac.waikato.modeljunit.Action;
import nz.ac.waikato.modeljunit.FsmModel;
import nz.ac.waikato.modeljunit.RandomTester;
import nz.ac.waikato.modeljunit.Tester;
import nz.ac.waikato.modeljunit.VerboseListener;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.assignment.DBObjects.User;
import com.assignment.SeleniumTesting.PopulateBetForm;
import com.assignment.SeleniumTesting.PopulateBetFormImp;
import com.assignment.SeleniumTesting.PopulateForm;
import com.assignment.SeleniumTesting.PopulateFormImp;
import com.assignment.SeleniumTesting.PopulateLoginForm;
import com.assignment.SeleniumTesting.PopulateLoginFormImp;
public class PerformanceTest implements FsmModel{

	private WebDriver browser;
	
	private User user;
	
	@Override
	public Object getState() {
		if(browser.getCurrentUrl().equals("http://localhost:8080/Assignment/")){
			return States.Home_Page;
		}
		else if(browser.getCurrentUrl().equals("http://localhost:8080/Assignment/registration.jsp")){
			return States.Registration_Page;
		}else if(browser.getCurrentUrl().equals("http://localhost:8080/Assignment/register")){
			return States.Registration_Message_Page;
		}else if(browser.getCurrentUrl().equals("http://localhost:8080/Assignment/betting.jsp")){
			return States.Betting_Page;
		}else{
			return States.Login_Error_Page;
		}
		
	}

	@Override
	public void reset(boolean arg0) {
		proceedToHompage();
	}
	
	public boolean registerGaurd(){
		States state = (States) getState();
		return state.equals(States.Home_Page) || state.equals(States.Registration_Message_Page);
	}
	
	public boolean proceedToHomepageGaurd(){
		States state = (States) getState();
		return state.equals(States.Registration_Message_Page) || state.equals(States.Login_Error_Page);
	}
	
	public boolean sumbitDetailsGaurd(){
		return getState().equals(States.Registration_Page);
	}
	
	public boolean validLoginGuard(){
		return getState().equals(States.Home_Page);
	}
	
	public boolean placeBetGaurd(){
		return getState().equals(States.Betting_Page);
	}
	
	@Action
	public void register(){
		browser.findElement(By.id("register_link")).click();
		assertEquals("http://localhost:8080/Assignment/registration.jsp", browser.getCurrentUrl());
	}
	
	@Action
	public void proceedToHompage(){
		browser.get("http://localhost:8080/Assignment/");
		assertEquals("http://localhost:8080/Assignment/", browser.getCurrentUrl());
	}
	
	@Action
	public void submitDetails(){
		PopulateForm regForm = new PopulateFormImp(browser);
		regForm.populate();
		regForm.submitForm();
		assertEquals("http://localhost:8080/Assignment/register", browser.getCurrentUrl());
	}
		
	@Action
	public void validLogin(){
		PopulateLoginForm login = new PopulateLoginFormImp(browser);
		login.populateloginuserName(user.getUsername());
		login.populateloginpassword(user.getPassword());
		login.submit("login_button");
		assertEquals("http://localhost:8080/Assignment/betting.jsp", browser.getCurrentUrl());
	}
	
	@Action
	public void placeBet(){
		PopulateBetForm betForm = new PopulateBetFormImp(browser);
		Random random = new Random();
		if(user.getAccounttype().compareTo("free") == 0){
			int randomAmount = random.nextInt(5) + 1;
			betForm.populateammount(randomAmount+"");
			betForm.setRisk("Low");
		}else{
			int randomAmount = random.nextInt(1900) + 100;
			betForm.populateammount(randomAmount + "");
			betForm.setRisk("High");
		}
		betForm.submit("submitButton");
		assertEquals("http://localhost:8080/Assignment/betting.jsp", browser.getCurrentUrl());
	}
	
	public void before(){
		browser = new FirefoxDriver();
	}
	
	public void after(){
		browser.quit();
	}
	
	@Test
	public void runner(){
		PerformanceTest ptest = new PerformanceTest();
		ptest.before();
		Tester t = new RandomTester(ptest);
		t.addListener(new VerboseListener());
		t.generate(2);
		t.buildGraph();
		ptest.after();
	}

}
