package framework;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class PageDriver extends InitialSetup {
	
	public enum Locator {xpath, name, id, linkText, partialLinkText, className, tagName, cssSelector}
	public static ExtentReports extendReport;
	public static ExtentTest extendTest;
	public static Actions action;
	
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
			extendTest.log(LogStatus.ERROR,"No such locator " + locator);
		}
		finally {
			return By.xpath(element);
		}
	}
	
//	FindElement() - Expansion of Selenium findElement()
	public WebElement FindElement(By by) {
		try {
			return wd.findElement(by);
		} catch (NoSuchElementException e) {
			extendTest.log(LogStatus.ERROR,"No such element " + by);
		}
		return null;
	}
	
	//	Click() - Expansion of Selenium click() - For radioButton and checkBox
	public void Click(String element,Locator locator) throws Exception {
		try {
			FindElement(locate(element,locator)).click();
		} catch (NoSuchElementException e) {
			extendTest.log(LogStatus.ERROR,"No such element " + element);
		}
	}
	
	//	SendKeys() - Expansion of Selenium SendKeys()
	public void SendKeys(String element, String keys,Locator locator) {
		try {
			FindElement(locate(element,locator)).sendKeys(keys);
		} catch (Exception e) {
			extendTest.log(LogStatus.ERROR,"No such element " + element);
		}	
	}
	
	//	Selects() - Expansion of Selenium Select()
	public void Selects(String element, int position,Locator locator) {
		try {
			Select sl = new Select(FindElement(locate(element,locator)));
			sl.selectByIndex(position);
		} catch (Exception e) {
			extendTest.log(LogStatus.ERROR,"No such element " + element);
		}	
	}

	// TakeScreenShot() - Takes screen shot
	public void TakeScreenShot()  {
		String filename = "Error.png";
		String directory = System.getProperty("user.dir") + "//screenshots//";
		try {
			File sourceFile =((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(sourceFile,new File(directory + filename));
		} catch (IOException e) {
			extendTest.log(LogStatus.ERROR,"Error during screenshot...");
		}
	}
	
	//FindElements() - Expansion of Selenium findelements()
	public void FindElements(String element, Locator locator, String innerElement, Locator innerLocator, String string) {
		try {
			List<WebElement> we = (FindElement(locate(element,locator))).findElements(locate(innerElement,innerLocator));
			for(WebElement w : we) 
				if(w.getText().contains(string)) {
					w.click();
					System.out.println("Clicked = " +w.getText());
				}
					
		} catch (Exception e) {
			extendTest.log(LogStatus.ERROR,"Error in FindElements" + element);
		}	
	}

	//Calendar() - Calendar selection - TODO
	public void GetAtt(String element,Locator locator) {
		try {
			List<WebElement> we = (wd.findElement(locate(element,locator))).findElements(By.tagName("li"));
			for(WebElement w : we)
			System.out.println(w.getText());
		} catch (Exception e) {
			System.out.println("GetAtt: No such element " + element);
		}	
	}
	
	//MoveToElement() - Action moveToElement  
	public void MoveToElement(String element,Locator locator) {
		try {
			action.moveToElement(FindElement(locate(element,locator))).perform();
		} catch (Exception e) {
			extendTest.log(LogStatus.ERROR,"Error in MoveToElement" + element);
		}	
	}
}
