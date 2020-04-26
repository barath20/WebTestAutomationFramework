package edureka;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import framework.Elements;
import framework.LaunchWebPage;
import framework.PageFactory;

public class HomePage extends PageFactory {
	
	
  @Test
  public void TopRibbon() {
	    WebDriver wd;
	    LaunchWebPage lwp =new LaunchWebPage();
		wd = lwp.SetWebPage();
		Elements ele = new Elements(wd);
		ele.click("//input[@id='bmwradio']");
  }
}
