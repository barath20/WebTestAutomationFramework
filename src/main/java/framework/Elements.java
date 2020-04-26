package framework;

import org.openqa.selenium.By;

public class Elements extends PageFactory {
	
	public void click(String element) {
		System.out.println("Inside click !!!" + element);
	//	wd.findElement(By.xpath(element)).click();
	//	wd.findElement(By.xpath("//input[@id='bmwradio']")).click();
	}
	
	public void sendText() {
		System.out.println("Inside sendText !!!");		
	}
}
