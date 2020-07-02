package makeMyTrip;

import com.relevantcodes.extentreports.LogStatus;

import framework.PageDriver;

public class SearchFlight extends PageDriver {
	
	public PageDriver pageDriver;
	
	public SearchFlight(PageDriver pageDriver) {
		this.pageDriver = pageDriver;
		
	}
	public void clearLogin() throws Exception {
		pageDriver.Click("//li[@data-cy='account']",Locator.xpath);
	}
	
	public void flightFrom() throws Exception {
		pageDriver.Click("//input[@id='fromCity']",Locator.xpath);
		pageDriver.SendKeys("//input[@placeholder='From']","BOM",Locator.xpath);
		pageDriver.FindElements("//li[@role='option']",Locator.xpath,"//p[contains(@class,'font14')]",Locator.tagName, "Mumbai");
//		pageDriver.Click("//p[contains(text(),'Mumbai')]",Locator.xpath);
		extendTest.log(LogStatus.INFO,"Inside flightFrom()");
	}
	
	public void flightTo() throws Exception {
		pageDriver.Click("//input[@id='toCity']",Locator.xpath);
		Thread.sleep(2000);
		javaScriptExecutor.executeScript("arguments[0].click();", "//input[@placeholder='To']");
		pageDriver.SendKeys("//input[@placeholder='To']","MAA",Locator.xpath);
		pageDriver.FindElements("//li[@role='option']",Locator.xpath,"//p[contains(@class,'font14')]",Locator.tagName, "Chennai");
		pageDriver.Click("//p[contains(text(),'Chennai')]",Locator.xpath);
		extendTest.log(LogStatus.INFO,"Inside flightTo()");
	}
	
	public void departureDate() throws Exception {
		pageDriver.Click("//span[contains(text(),'DEPARTURE')]",Locator.xpath);
		pageDriver.Click("//div[@aria-label='Wed Jul 15 2020']", Locator.xpath);
		extendTest.log(LogStatus.INFO,"Inside departureDate()");
	}
	
	public void returnDate() throws Exception {
		pageDriver.Click("//span[contains(text(),'RETURN')]",Locator.xpath);
		pageDriver.Click("//div[@aria-label='Wed Aug 19 2020']", Locator.xpath);
		extendTest.log(LogStatus.INFO,"Inside returnDate()");
	}
	
	public void flightSearch() throws Exception {
		pageDriver.Click("//a[contains(text(),'Search')]",Locator.xpath);
		Thread.sleep(6000);
		pageDriver.TakeScreenShot("Name.png");
		extendTest.log(LogStatus.INFO,"Inside flightSearch()");
	}

}
