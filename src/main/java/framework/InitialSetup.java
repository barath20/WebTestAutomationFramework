package framework;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import java.io.File;
import java.util.concurrent.TimeUnit;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InitialSetup {

	public WebDriver webDriver;
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

		// Driver is managed automatically by Selenium 4.x
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		webDriver = new ChromeDriver(chromeOptions);
		webDriver.get(url);
		webDriver.manage().window().maximize();
		webDriver.manage().deleteAllCookies();
		// Selenium 4 uses Duration for timeouts
		webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(45));
		return webDriver;
	}
}
