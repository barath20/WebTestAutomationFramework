package framework;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Elements {
	
	@FindBy(xpath="//input[@id='fromCity']")
	private static WebElement fromCity;
	
	
	WebElement getter(String element) {
		return fromCity;
	}

}
