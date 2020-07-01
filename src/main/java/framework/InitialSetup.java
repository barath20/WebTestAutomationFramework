package framework;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class InitialSetup {
	
	public WebDriver webDriver;
	public enum Locator {xpath, name, id, linkText, partialLinkText, className, tagName, cssSelector}
	public static ExtentReports extendReport;
	public static ExtentTest extendTest;
	public static Actions actions;
	public static JavascriptExecutor javaScriptExecutor;

	public WebDriver SetWebPage(String url) {
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		webDriver = new ChromeDriver();
		webDriver.get(url);
		webDriver.manage().window().maximize();
		return webDriver;
	}
}
