package edureka;

import org.testng.annotations.Test;

public class HomePage extends Setup {
	@Test
	public void TopRibbon() throws Throwable {

		pD.Click("//input[@id='bmwradio']",Locator.xpath);
		pD.Selects("//select[@id='carselect']",1,Locator.xpath);
		pD.Selects("//select[@id='multiple-select-example']",1,Locator.xpath);
		pD.Click("//input[@id='hondacheck']", Locator.xpath);

  }
}