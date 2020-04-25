package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchWebPage {
	
	WebDriver wd = new ChromeDriver();

	public void SetAndLaunch() {
		
		System.setProperty("webdriver.chrome.driver", "S:\\Software\\chromedriver_win32\\chromedriver.exe");
		
		wd.get("https://www.edureka.co/");
		wd.manage().window().maximize();
	}
}
