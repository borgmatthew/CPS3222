import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Filling {
	WebDriver browser;
	
	@Before
	public void setUp() throws Exception {
		

		browser = new FirefoxDriver();
	}

	@After
	public void tearDown() throws Exception {
		//browser.quit();
	}

	@Test
	public void test() {
		browser .get("http://localhost:8080/Assignment/registration.jsp");
		browser.findElement(By.id("firstName")).sendKeys("Alastair");
		browser.findElement(By.id("lastName")).sendKeys("Vella");
		browser.findElement(By.id("userName")).sendKeys("ali.speed6@gmail.com");
		browser.findElement(By.id("password")).sendKeys("Assignment");
		browser.findElement(By.id("dob")).sendKeys("01/08/1991");
		browser.findElement(By.id("creditcard")).sendKeys("4568820241600813");
		browser.findElement(By.id("expiry_date")).sendKeys("01/08/2017");
		browser.findElement(By.id("cvv")).sendKeys("123");
		browser.findElement(By.id("submitButton")).submit();
		List<WebElement> paragraph=browser.findElements(By.id("parag"));
		assertTrue(paragraph.size()>0);
		
	}

}
