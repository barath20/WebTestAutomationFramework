package edureka;

import org.testng.annotations.Test;
import framework.InitialSetup;
import framework.PageDriver;

public class HomePage extends PageDriver {
	
  @Test
  public void TopRibbon() throws Throwable {

	    InitialSetup lwp =new InitialSetup();
		wd = lwp.SetWebPage();
		PageDriver pD = new PageDriver();
		pD.Driver(wd);
//		wd.findElement(By.xpath("//input[@id='bmwradio']"));		
		pD.Click("//input[@id='bmwradio']",Locator.xpath);
		pD.Selects("//select[@id='carselect']",1,Locator.xpath);
		pD.Selects("//select[@id='multiple-select-example']",1,Locator.xpath);
		pD.Click("//input[@id='hondacheck']", Locator.xpath);

  }
}
