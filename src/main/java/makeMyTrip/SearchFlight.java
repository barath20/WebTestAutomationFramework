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
		pageDriver.FindElements("//input[@id='fromCity']",0,Locator.xpath);
		pageDriver.SendKeys("//input[@placeholder='From']","BOM",Locator.xpath);
		pageDriver.Click("//p[contains(text(),'Mumbai')]",Locator.xpath);
	}
	
	public void flightTo() throws Exception {
//		pageDriver.Click("//input[@id='toCity']",Locator.xpath);
		pageDriver.SendKeys("//input[@placeholder='To']","MAA",Locator.xpath);
		pageDriver.Click("//p[contains(text(),'Chennai')]",Locator.xpath);

	}
	
	public void departureDate() {
		System.out.println("Inside...");
	}
	
	public void returnDate() {
		System.out.println("Inside...");
	}
	
	public void flightSearch() {
		System.out.println("Inside...");
	}

}
