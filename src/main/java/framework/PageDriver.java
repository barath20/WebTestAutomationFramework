package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageDriver extends InitialSetup {
	
	public enum Locator {xpath, name, id, linkText, partialLinkText, className, tagName, cssSelector}
	
	public void Driver(WebDriver wd) {
		this.wd = wd;
	}

	//	locate() - return By according to the locator
	@SuppressWarnings("finally")
	public By locate(String element,Locator locator) throws Exception {
		try {
			if(locator == Locator.xpath) return By.xpath(element);
			else if(locator == Locator.name) return By.name(element);
			else if(locator == Locator.id) return By.id(element);
			else if(locator == Locator.linkText) return By.linkText(element);
			else if(locator == Locator.partialLinkText) return By.partialLinkText(element);
			else if(locator == Locator.className) return By.className(element);
			else if(locator == Locator.tagName) return By.tagName(element);
			else if(locator == Locator.cssSelector) return By.cssSelector(element);
			else throw new Exception();
		}
		catch(Exception e) {
			System.out.println("No such locator " + locator);
		}
		finally {
			return By.xpath(element);
		}
	}
	
	//	Click() - Expansion of Selenium click() - For radioButton and checkBox
	public void Click(String element,Locator locator) throws Exception {
		try {
			wd.findElement(locate(element,locator)).click();
		} catch (NoSuchElementException e) {
			System.out.println("No such element " + element);
		}
	}
	
	//	SendKeys() - Expansion of Selenium SendKeys()
	public void SendKeys(String element, String keys,Locator locator) {
		try {
			wd.findElement(locate(element,locator)).sendKeys(keys);
		} catch (Exception e) {
			System.out.println("No such element " + element);
		}	
	}
	
	//	Selects() - Expansion of Selenium Select()
	public void Selects(String element, int position,Locator locator) {
		try {
			Select sl = new Select(wd.findElement(locate(element,locator)));
			sl.selectByIndex(position);
		} catch (Exception e) {
			System.out.println("No such element " + element);
		}	
	}

	//	DropDown() - Expansion of Selenium DropDown()
//	public void MultiSelect(String element, int position,String locator) {
//		try {
//			Select sl = new Select(wd.findElement(locate(element,locator)));
//			sl.selectByIndex(position);
//		} catch (Exception e) {
//			System.out.println("No such element " + element);
//		}	
//	}
}
