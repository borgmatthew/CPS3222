import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Filling {
	WebDriver browser;
	@Before
	public void setUp() throws Exception {
		browser = new FirefoxDriver();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		browser .get("http://localhost:8080/Assignment/registration.jsp");
		browser.findElement(By.id("firstName")).sendKeys("Alastair");;
	}

}
