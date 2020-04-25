package framework;

import org.openqa.selenium.By;

public class Elements extends LaunchWebPage {

	public void click(String element) {
		System.out.println("Inside click !!!" + element);
		wd.findElement(By.xpath(element)); 
	}
	
	public void sendText() {
		System.out.println("Inside sendText !!!");		
	}
}
