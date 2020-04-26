package framework;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

public class LaunchWebPage extends PageFactory {

	
	public void SetWebPage() {
		System.setProperty("webdriver.chrome.driver", "S:\\Software\\chromedriver_win32\\chromedriver.exe");
		wd = new ChromeDriver();
		wd.get("https://learn.letskodeit.com/p/practice");
		wd.manage().window().maximize();
		wd.findElement(By.xpath("//input[@id='bmwradio']")).click();
	}
}
