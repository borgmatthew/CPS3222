import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	}

	@After
	public void tearDown() throws Exception {
		//browser.quit();
	}

	@Test
	public void test() {
		form.visit();
		form.populate();
		//List<WebElement> paragraph=browser.findElements(By.id("parag"));
		assertTrue(form.find("parag").size()>0);
		
	}

}
