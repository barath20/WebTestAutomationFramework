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
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class PageDriver extends InitialSetup {
	
	public enum Locator {xpath, name, id, linkText, partialLinkText, className, tagName, cssSelector}
	public static ExtentReports report;
	public static ExtentTest test;
	
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
			test.log(LogStatus.FAIL,"No such element ");
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
	
	// TakeScreenShot() - Takes screen shot
	public void TakeScreenShot()  {
		String filename = "Error.png";
		System.out.println("Inside tss");
		String directory = System.getProperty("user.dir") + "//screenshots//";
		System.out.println("Inside tss");
		try {
		File sourceFile =((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
		
			System.out.println("Inside tss");
			FileUtils.copyFile(sourceFile,new File(directory + filename));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//FindElements() - Expansion of Selenium findelements()
	public void FindElements(String element, int position,Locator locator) {
		try {
			List<WebElement> findEle = new ArrayList<WebElement>();
			findEle = wd.findElements(locate(element,locator));
			for(WebElement w : findEle) System.out.println("Find ele = " + w.getText()); 
		} catch (Exception e) {
			System.out.println("No such element " + element);
		}	
	}
}
