package makeMyTrip_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.Status;

import framework.PageDriver;
import framework.InitialSetup;

public class SearchFlight extends InitialSetup {

	PageDriver pageDriver;
	WebDriver webDriver;

	@FindBy(xpath = "//li[@data-cy='account']")
	private static WebElement clearLogin;

	@FindBy(xpath = "//input[@id='fromCity']")
	private static WebElement fromCity;

	@FindBy(xpath = "//input[@placeholder='From']")
	private static WebElement fromPlaceHolder;

	@FindBy(xpath = "//input[@id='toCity']")
	private static WebElement toCity;

	@FindBy(xpath = "//input[@placeholder='To']")
	private static WebElement toPlaceHolder;

	@FindBy(xpath = "//span[contains(text(),'DEPARTURE')]")
	private static WebElement departure;

	@FindBy(xpath = "//a[contains(text(),'Search')]")
	private static WebElement searchButton;

	public SearchFlight(WebDriver webDriver, PageDriver pageDriver) {
		PageFactory.initElements(webDriver, this);
		this.pageDriver = pageDriver;
		this.webDriver = webDriver;
	}

	public void clearLogin() throws Exception {
		pageDriver.Click(clearLogin);
	}

	public void flightFrom() throws Exception {
		pageDriver.Click(fromCity);
		pageDriver.SendKeys(fromPlaceHolder, "BOM");
		// pageDriver.FindElements("//li[@role='option']","//p[contains(@class,'font14')]",Locator.tagName,
		// "Mumbai");
		// pageDriver.Click("//p[contains(text(),'Mumbai')]");
		extendTest.log(Status.INFO, "Inside flightFrom()");
	}

	public void flightTo() throws Exception {
		pageDriver.Click(toCity);
		Thread.sleep(2000);
		javaScriptExecutor.executeScript("arguments[0].click();", "//input[@placeholder='To']");
		pageDriver.SendKeys(toPlaceHolder, "MAA");
		// pageDriver.FindElements("//li[@role='option']","//p[contains(@class,'font14')]",Locator.tagName,
		// "Chennai");
		// pageDriver.Click("//p[contains(text(),'Chennai')]");
		extendTest.log(Status.INFO, "Inside flightTo()");
	}

	public void departureDate() throws Exception {
		pageDriver.Click(departure);
		// pageDriver.Click("//div[@aria-label='Wed Jul 15 2020']", Locator.xpath);
		extendTest.log(Status.INFO, "Inside departureDate()");
	}

	public void returnDate() throws Exception {
		// pageDriver.Click("//span[contains(text(),'RETURN')]");
		// pageDriver.Click("//div[@aria-label='Wed Aug 19 2020']", Locator.xpath);
		extendTest.log(Status.INFO, "Inside returnDate()");
	}

	public void flightSearch() throws Exception {
		pageDriver.Click(searchButton);
		Thread.sleep(6000);
		pageDriver.TakeScreenShot("Name.png");
		extendTest.log(Status.INFO, "Inside flightSearch()");
	}
}
