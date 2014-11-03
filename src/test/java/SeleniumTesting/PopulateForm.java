package SeleniumTesting;

import java.util.List;

import org.openqa.selenium.WebElement;

public interface PopulateForm {
	
	public void visit();
	public void populate();
	public List<WebElement> find(String name);
	

}
