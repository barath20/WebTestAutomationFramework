package framework;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;

public class PageDriver extends InitialSetup {
	
	public void Driver(WebDriver webDriver) {
		this.webDriver = webDriver;
		actions = new Actions(webDriver);
		javaScriptExecutor = (JavascriptExecutor) webDriver;
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
			return webDriver.findElement(by);
		} catch (NoSuchElementException e) {
			extendTest.log(LogStatus.ERROR,"Error in FindElement() " + by);
		}
		return null;
	}
	
	//	Click() - Expansion of Selenium click() - For radioButton and checkBox
	public void Click(String element,Locator locator) throws Exception {
		try {
			FindElement(locate(element,locator)).click();
		} catch (NoSuchElementException e) {
			extendTest.log(LogStatus.ERROR,"Error in Click() " + element);
		}
	}
	
	//	SendKeys() - Expansion of Selenium SendKeys()
	public void SendKeys(String element, String keys,Locator locator) {
		try {
			FindElement(locate(element,locator)).sendKeys(keys);
		} catch (Exception e) {
			extendTest.log(LogStatus.ERROR,"Error in SendKeys() " + element);
		}	
	}
	
	//	Selects() - Expansion of Selenium Select()
	public void Selects(String element, int position,Locator locator) {
		try {
			Select sl = new Select(FindElement(locate(element,locator)));
			sl.selectByIndex(position);
		} catch (Exception e) {
			extendTest.log(LogStatus.ERROR,"Error in Selects() " + element);
		}	
	}

	// TakeScreenShot() - Takes screen shot
	public void TakeScreenShot(String fileName)  {
		String filename = fileName + ".png";
		String directory = System.getProperty("user.dir") + "//screenshots//";
		try {
			File sourceFile =((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(sourceFile,new File(directory + filename));
		} catch (IOException e) {
			extendTest.log(LogStatus.ERROR,"Error during screenshot...");
		}
	}
	
	//FindElements() - Expansion of Selenium findelements()
	public void FindElements(String element, Locator locator, String innerElement, Locator innerLocator, String string) {
		try {
			List<WebElement> we = (FindElement(locate(element,locator))).findElements(locate(innerElement,innerLocator));
			System.out.println("Size of list = " +we.size());
			for(WebElement w : we) {
				System.out.println("For:Clicked = " +w.getText());
				if(w.getText().contains(string)) {
					System.out.println("Clicked = " +w.getText());
					w.click();
				}
			}	
		} catch (Exception e) {
			extendTest.log(LogStatus.ERROR,"Error in FindElements" + element);
		}	
	}

	//Calendar() - Calendar selection - TODO
	public void GetAtt(String element,Locator locator) {
		try {
			List<WebElement> we = (webDriver.findElement(locate(element,locator))).findElements(By.tagName("li"));
			for(WebElement w : we)
			System.out.println(w.getText());
		} catch (Exception e) {
			System.out.println("GetAtt: No such element " + element);
		}	
	}
	
	//MoveToElemenPerform() - Action moveToElement - Perform 
	public void MoveToElementPerform(String element,Locator locator) {
		try {
			actions.moveToElement(FindElement(locate(element,locator))).perform();;
		} catch (Exception e) {
			extendTest.log(LogStatus.ERROR,"Error in MoveToElementPerform() " + element);
		}	
	}
	
	//MoveToElementClick() - Action moveToElement  - Click
	public void MoveToElementClick(String element,Locator locator) {
		try {
			actions.moveToElement(FindElement(locate(element,locator))).click().perform();
//			actions.click(FindElement(locate(element,locator)));
		} catch (Exception e) {
			extendTest.log(LogStatus.ERROR,"Error in MoveToElementClick() " + element);
		}	
	}
	
	//DragAndDrop() - Drag and drop
	public void DragAndDrop(String fromElement,Locator fromLocator, String toElement,Locator toLocator) {
		try {
			Thread.sleep(3000);
			webDriver.switchTo().frame(0);
			actions.dragAndDrop(FindElement(locate(fromElement,fromLocator)), FindElement(locate(toElement,toLocator))).build().perform();

		} catch (Exception e) {
			extendTest.log(LogStatus.ERROR,"Error in DragAndDrop() " + fromElement + toElement);
		}	
	}
	
	//Slider() - Slider
	public void Slider(String element,Locator locator) {
		try {
			Thread.sleep(3000);
			webDriver.switchTo().frame(0);
			actions.dragAndDropBy(FindElement(locate(element,locator)), 100, 0).build().perform();

		} catch (Exception e) {
			extendTest.log(LogStatus.ERROR,"Error in DragAndDrop() " + element + locator);
		}	
	}
}
