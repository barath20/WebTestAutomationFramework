package framework;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

public class InitialSetup {
	
	public WebDriver wd;
	public int a;

	public WebDriver SetWebPage() {
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		wd = new ChromeDriver();
		wd.get("https://learn.letskodeit.com/p/practice");
		wd.manage().window().maximize();
		a = 10;
		return wd;
	}
}
