package edureka;

import org.testng.annotations.Test;
import framework.Elements;
import framework.LaunchWebPage;
import framework.PageFactory;

public class HomePage extends PageFactory {
	
	
  @Test
  public void TopRibbon() {
	    LaunchWebPage lwp =new LaunchWebPage();
		lwp.SetWebPage();
		Elements ele = new Elements();
		ele.click("//input[@id='bmwradio']");
		System.out.println("Test Ones");
  }
}
