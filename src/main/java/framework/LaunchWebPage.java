package framework;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

public class LaunchWebPage extends PageFactory {

	public WebDriver SetWebPage() {
		System.setProperty("webdriver.chrome.driver", "S:\\Software\\chromedriver_win32\\chromedriver.exe");
		wd = new ChromeDriver();
		wd.get("https://learn.letskodeit.com/p/practice");
		wd.manage().window().maximize();
		return wd;
	}
}
