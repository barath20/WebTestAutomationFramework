package makeMyTrip;

import framework.PageDriver;
import framework.PageDriver.Locator;

public class SearchFlight {
	
	public PageDriver pageDriver = new PageDriver();
	
	public SearchFlight(PageDriver pageDriver) {
		this.pageDriver = pageDriver;
		
	}
	public void clearLogin() throws Exception {
		pageDriver.Click("//li[@data-cy='account']",Locator.xpath);
	}
	
	public void flightFrom() throws Exception {
		pageDriver.Click("//input[@id='fromCity']",Locator.xpath);
		pageDriver.SendKeys("//input[@placeholder='From']","BOM",Locator.xpath);
		pageDriver.FindElements("//ul[@role='listbox']",Locator.xpath,"li",Locator.tagName);
		pageDriver.Click("//p[contains(text(),'Mumbai')]",Locator.xpath);
	}
	
	public void flightTo() throws Exception {
		pageDriver.SendKeys("//input[@placeholder='To']","MAA",Locator.xpath);
		pageDriver.Click("//p[contains(text(),'Chennai')]",Locator.xpath);

	}
	
	public void departureDate() throws Exception {
		pageDriver.Click("//span[contains(text(),'DEPARTURE')]",Locator.xpath);
		pageDriver.Click("//div[@aria-label='Mon Jun 29 2020']", Locator.xpath);
		
	}
	
	public void returnDate() throws Exception {
		pageDriver.Click("//span[contains(text(),'RETURN')]",Locator.xpath);
		pageDriver.Click("//div[@aria-label='Wed Jul 29 2020']", Locator.xpath);
	}
	
	public void flightSearch() throws Exception {
		pageDriver.Click("//a[contains(text(),'Search')]",Locator.xpath);
		Thread.sleep(6000);
		pageDriver.TakeScreenShot();
	}

}
