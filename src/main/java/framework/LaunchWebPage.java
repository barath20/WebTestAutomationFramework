package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchWebPage {

	public void SetAndLaunch() {
		
		System.setProperty("webdriver.chrome.driver", "S:\\Software\\chromedriver_win32\\chromedriver.exe");
		WebDriver wd = new ChromeDriver();
		wd.get("https://www.southwest.com/");
		wd.manage().window().maximize();
	}
}
