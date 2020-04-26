package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Elements extends PageFactory {
	
	WebDriver wd;
	public Elements(WebDriver wd1) {
		wd = wd1;
	}
	
	public void click(String element) {
		wd.findElement(By.xpath(element)).click();
	}
	
	public void SendKeys(String element, String keys) {
		wd.findElement(By.xpath(element)).sendKeys(keys);	
	}
}
