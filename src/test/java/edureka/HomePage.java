package edureka;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import framework.InitialSetup;
import framework.PageDriver;

public class HomePage extends PageDriver {
	
	public WebDriver wd;
	
  @Test
  public void TopRibbon() throws Throwable {

	    InitialSetup lwp =new InitialSetup();
		wd = lwp.SetWebPage();
		PageDriver pD = new PageDriver();
		pD.Driver(wd);
//		wd.findElement(By.xpath("//input[@id='bmwradio']"));		
		pD.click("//input[@id='bmwradio']","xpath");
		System.out.println("A= " + a);
  }
}
