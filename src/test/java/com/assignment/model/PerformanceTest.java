package com.assignment.model;

import static org.junit.Assert.assertEquals;

import java.util.Random;
import java.util.Vector;

import nz.ac.waikato.modeljunit.Action;
import nz.ac.waikato.modeljunit.AllRoundTester;
import nz.ac.waikato.modeljunit.FsmModel;
import nz.ac.waikato.modeljunit.Tester;
import nz.ac.waikato.modeljunit.VerboseListener;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.assignment.DBObjects.User;
import com.assignment.SeleniumTesting.PopulateBetForm;
import com.assignment.SeleniumTesting.PopulateBetFormImp;
import com.assignment.SeleniumTesting.PopulateForm;
import com.assignment.SeleniumTesting.PopulateFormImp;
import com.assignment.SeleniumTesting.PopulateLoginForm;
import com.assignment.SeleniumTesting.PopulateLoginFormImp;

public class PerformanceTest implements FsmModel, Runnable {

	private FirefoxDriver browser;
	int userNo = 0;
	private User user = null;

	private Vector<Long> loadTimes;

	public PerformanceTest(Vector<Long> loadTimes) {
		this.loadTimes = loadTimes;
	}

	@Override
	public States getState() {

		if (browser.getCurrentUrl().equals(
				"http://localhost:8080/Assignment/registration.jsp")) {
			return States.Registration_Page;
		} else if (browser.getCurrentUrl().equals(
				"http://localhost:8080/Assignment/register")) {
			return States.Registration_Message_Page;
		} else if (browser.getCurrentUrl().equals(
				"http://localhost:8080/Assignment/betting.jsp")) {
			return States.Betting_Page;
		} else if (browser.getCurrentUrl().equals(
				"http://localhost:8080/Assignment/login")) {
			return States.Login_Error_Page;
		} else {
			if (user == null) {
				return States.Home_Page;
			} else {
				return States.Login;
			}
		}
	}

	@Override
	public void reset(boolean arg0) {
		user = null;
		long before = getTime();
		browser.get("http://localhost:8080/Assignment/");
		loadTimes.add(getTime() - before);
	}

	public boolean registerGuard() {
		States state = getState();
		return state.equals(States.Home_Page);
	}

	@Action
	public void register() {
		long before = getTime();
		browser.findElement(By.id("register_link")).click();
		assertEquals("http://localhost:8080/Assignment/registration.jsp",
				browser.getCurrentUrl());
		loadTimes.add(getTime() - before);
	}

	public boolean proceedToLoginGuard() {
		States state = getState();
		return state.equals(States.Registration_Message_Page)
				|| state.equals(States.Login_Error_Page);
	}

	@Action
	public void proceedToLogin() {
		long before = getTime();
		browser.get("http://localhost:8080/Assignment/");
		assertEquals("http://localhost:8080/Assignment/",
				browser.getCurrentUrl());
		loadTimes.add(getTime() - before);
	}

	public boolean submitDetailsGuard() {
		return getState().equals(States.Registration_Page);
	}

	@Action
	public void submitDetails() {
		PopulateForm regForm = new PopulateFormImp(browser);
		String username = generateUsername();
		String password = "Assignment";
		user = new User();
		user.setUsername(username);
		user.setPassword(password);
		double ran = Math.random();
		String type;
		if (ran < 0.75) {
			type = "free";
		} else {
			type = "premium";
		}
		regForm.populate(username, password, type);
		user.setAccounttype(type);
		
		long before = getTime(); 
		regForm.submitForm();
		assertEquals("http://localhost:8080/Assignment/register",
				browser.getCurrentUrl());
		loadTimes.add(getTime() - before);
	}

	public boolean validLoginGuard() {
		double ran = Math.random();
		if (ran > 0.25 && getState().equals(States.Login)) {
			return true;
		} else {
			return false;
		}
	}

	@Action
	public void validLogin() {
		PopulateLoginForm login = new PopulateLoginFormImp(browser);
		login.populateloginuserName(user.getUsername());
		login.populateloginpassword(user.getPassword());
		long before = getTime();
		login.submit("login_button");
		assertEquals("http://localhost:8080/Assignment/betting.jsp",
				browser.getCurrentUrl());
		loadTimes.add(getTime() - before);
	}

	public boolean placeBetGuard() {
		double ran = Math.random();
		if (ran <= 0.5 && getState().equals(States.Betting_Page)) {
			return true;
		} else {
			return false;
		}
	}

	@Action
	public void placeBet() {
		PopulateBetForm betForm = new PopulateBetFormImp(browser);
		Random random = new Random();
		if (user.getAccounttype().compareTo("free") == 0) {
			int randomAmount = random.nextInt(5) + 1;
			betForm.populateammount(randomAmount + "");
			betForm.setRisk("low");
		} else {
			int randomAmount = random.nextInt(1900) + 100;
			betForm.populateammount(randomAmount + "");
			betForm.setRisk("high");
		}
		long before = getTime();
		betForm.submit("submitButton");
		assertEquals("http://localhost:8080/Assignment/betting.jsp",
				browser.getCurrentUrl());
		loadTimes.add(getTime() - before);
	}

	public boolean logoutGuard() {
		double ran = Math.random();
		if (ran < 0.5 && getState().equals(States.Betting_Page)) {
			return true;
		} else {
			return false;
		}
	}

	@Action
	public void logout() {
		long before = getTime();
		browser.findElement(By.id("logout_link")).click();
		user = null;
		assertEquals("http://localhost:8080/Assignment/index.jsp",
				browser.getCurrentUrl());
		loadTimes.add(getTime() - before);
	}

	public boolean invalidLoginGuard() {
		double ran = Math.random();
		if (ran < 0.25 && getState().equals(States.Login)) {
			return true;
		} else {
			return false;
		}
	}

	@Action
	public void invalidLogin() {
		PopulateLoginForm login = new PopulateLoginFormImp(browser);
		login.populateloginuserName(user.getUsername());
		login.populateloginpassword(user.getPassword() + " ");
		
		long before = getTime();
		login.submit("login_button");
		assertEquals("http://localhost:8080/Assignment/login",
				browser.getCurrentUrl());
		loadTimes.add(getTime() - before);
	}

	public void before() {
		browser = new FirefoxDriver();//new HtmlUnitDriver(true);
		//browser.setThrowExceptionOnFailingStatusCode(false);
		//browser.setJavascriptEnabled(true);
	}

	public void after() {
		browser.quit();
	}

	public String generateUsername() {
		userNo++;
		return "iswed" + userNo;
	}
	
	public long getTime(){
		return System.currentTimeMillis();
	}

	@Override
	public void run() {
		this.before();
		Tester t = new AllRoundTester(this);
		t.addListener(new VerboseListener());
		t.generate(100);
		t.buildGraph();
		this.after();
	}
}
