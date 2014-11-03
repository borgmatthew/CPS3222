package SeleniumTesting;

import java.util.List;

import org.openqa.selenium.WebElement;

public interface PopulateForm {
	
	public void visit();
	public void close();
	public void populate();
	public List<WebElement> findById(String name);
	public  void populateName(String name);
	

}
