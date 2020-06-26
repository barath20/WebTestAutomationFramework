package edureka;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class HomePage extends Setup {
	@Test
	public void TopRibbon() throws Throwable {
		
		  test.log(LogStatus.INFO, "Inside test...");

		pD.Click("//input[@id='bmwradio']",Locator.xpath);
		pD.Selects("//select[@id='carselect']",1,Locator.xpath);
		pD.Selects("//select[@id='multiple-select-example']",1,Locator.xpath);
		pD.Click("//input[@id='hondacheck']", Locator.xpath);

  }
}