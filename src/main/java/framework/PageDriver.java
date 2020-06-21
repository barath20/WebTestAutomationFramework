package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class PageDriver extends InitialSetup {
	
	public void Driver(WebDriver wd) {
		this.wd = wd;
	}

	//	locate() - return By according to the locator
	@SuppressWarnings("finally")
	public By locate(String element,String locator) throws Exception {
		try {
			if(locator.equals("xpath")) return By.xpath(element);
			else if(locator.equals("name")) return By.name(element);
			else if(locator.equals("id")) return By.id(element);
			else if(locator.equals("linkText")) return By.linkText(element);
			else if(locator.equals("partialLinkText")) return By.partialLinkText(element);
			else if(locator.equals("className")) return By.className(element);
			else if(locator.equals("tagName")) return By.tagName(element);
			else if(locator.equals("cssSelector")) return By.cssSelector(element);
			else throw new Exception();
		}
		catch(Exception e) {
			System.out.println("No such locator " + locator);
		}
		finally {
			return By.xpath(element);
		}
		
	}
	
	//	click() - Expansion of Selenium click()
	public void click(String element,String locator) throws Exception {
		try {
			wd.findElement(locate(element,locator)).click();
		} catch (NoSuchElementException e) {
			System.out.println("No such element " + element);
		}
	}
	
	//	SendKeys() - Expansion of Selenium SendKeys()
	public void SendKeys(String element, String keys,String locator) {
		try {
			wd.findElement(locate(element,locator)).sendKeys(keys);
		} catch (Exception e) {
			System.out.println("No such element " + element);
		}	
	}

}
