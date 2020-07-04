package framework;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InitialSetup {
	
	public WebDriver webDriver;
	public enum Locator {xpath, name, id, linkText, partialLinkText, className, tagName, cssSelector}
	public static ExtentReports extendReport;
	public static ExtentTest extendTest;
	public static Actions actions;
	public static JavascriptExecutor javaScriptExecutor;
	public static final Logger log = LogManager.getLogger(InitialSetup.class.getName()); 

	public WebDriver SetWebPage(String url) {
		
		log.info("Inside InitialSetup.SetWebPage() infos");
		log.debug("Inside InitialSetup.SetWebPage() debugs");
		log.fatal("Inside InitialSetup.SetWebPage() fatals");
		log.error("Inside InitialSetup.SetWebPage() errors");
		System.setProperty("log4j.configurationFile", "logFile.log");
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Resources\\chromedriver.exe");
		webDriver = new ChromeDriver();
		webDriver.get(url);
		webDriver.manage().window().maximize();
		return webDriver;
	}
}
