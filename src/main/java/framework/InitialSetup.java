package framework;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

public class InitialSetup {
	
	public WebDriver webDriver;

	public WebDriver SetWebPage(String url) {
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		webDriver = new ChromeDriver();
		webDriver.get(url);
		webDriver.manage().window().maximize();
		return webDriver;
	}
}
