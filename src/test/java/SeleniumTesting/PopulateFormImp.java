package SeleniumTesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PopulateFormImp implements PopulateForm {
	WebDriver browser;
	//Constructor
	public PopulateFormImp(WebDriver brows){
		browser=brows;
	}
	
	public void visit(){
		browser .get("http://localhost:8080/Assignment/registration.jsp");
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
		browser.findElement(By.id("creditcard")).sendKeys("4568820241600813");
		browser.findElement(By.id("expiry_date")).sendKeys("01/08/2017");
		browser.findElement(By.id("cvv")).sendKeys("123");
		browser.findElement(By.id("submitButton")).submit();
	}
	
	public List<WebElement> findById(String name){
		List<WebElement> paragraph=browser.findElements(By.id(name));
		return paragraph;
	}
	public void populateName(String name){
		browser.findElement(By.id("firstName")).sendKeys(name+="\t");

	}

}
