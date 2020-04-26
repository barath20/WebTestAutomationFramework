package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Elements extends PageFactory {
	
	WebDriver wd;
	public Elements(WebDriver wd1) {
		wd = wd1;
		
	}
	
	public void click(String element) {
		System.out.println("Inside click !!!" + element);
		System.out.println("Value of a = "+a);
	//	wd.findElement(By.xpath(element)).click();
		wd.findElement(By.xpath("//input[@id='bmwradio']")).click();
	}
	
	public void sendText() {
		System.out.println("Inside sendText !!!");		
	}
}
