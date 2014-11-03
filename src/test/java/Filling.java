import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import SeleniumTesting.PopulateForm;
import SeleniumTesting.PopulateFormImp;

public class Filling {
	WebDriver browser;
	PopulateForm form;
	@Before
	public void setUp() throws Exception {
		browser = new FirefoxDriver();
		form=new PopulateFormImp(browser);
		form.visit();
	}

	@After
	public void tearDown() throws Exception {
		form.close();
	}

	@Test
	public void validFormtest() {
		//form.visit();
		form.populate();
		//List<WebElement> paragraph=browser.findElements(By.id("parag"));
		assertTrue(form.findById("parag").size()>0);
		
	}
	@Test
	public void InvalidNameTest(){
		form.populateName("6");
		assertEquals("Invalid characters",form.findById("name_error").get(0).getText());
	}
}
