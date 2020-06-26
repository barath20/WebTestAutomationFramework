package letKodeIt;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class HomePage extends Setup {
	@Test
	public void Radio() throws Throwable {
		
		  test.log(LogStatus.INFO, "Inside test...");

		pD.Click("//input[@id='bmwradio']",Locator.xpath);
  }
	@Test
	public void Select1() throws Throwable {
		
		  test.log(LogStatus.INFO, "Inside test...");

		pD.Selects("//select[@id='carselect']",1,Locator.xpath);

  }
	@Test
	public void Select2() throws Throwable {
		
		  test.log(LogStatus.INFO, "Inside test...");

		pD.Selects("//select[@id='multiple-select-example']",1,Locator.xpath);

  }
	@Test
	public void Click2() throws Throwable {
		
		  test.log(LogStatus.INFO, "Inside test...");

		pD.Click("//input[@id='hondachec']", Locator.xpath);

  }
	
}