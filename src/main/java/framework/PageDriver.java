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

//	1. Browser Commands
//
//	Get command
//	Get Title command
//	Get Current URL command
//	Get Page Source Command
//	Close command
//	Quit command
//2. Navigation Commands
//
//	Navigate to command
//	Back command
//	Forward command
//	Refresh commands
//3. WebElement Commands
//
//	Clear command
//	Click command - Done
//	GetText command
//	IsSelected command
//	IsEnabled command
//	IsDisplayed command
//	getSize command
//	GetCssValue command
//	getLocation command
//	Submit command
//	getAttribute command
//	gefTagName command
//	SendKeys command - Done
//	Select command* - Done




	//	Click() - Expansion of Selenium click() - For radioButton and checkBox
	public void Click(WebElement element) throws Exception {
		try {
			element.click();
		} catch (NoSuchElementException e) {
			extendTest.log(LogStatus.ERROR,"Error in Click() " + element);
		}
	}
	
	//	SendKeys() - Expansion of Selenium SendKeys()
	public void SendKeys(WebElement element, String keys) {
		try {
			element.sendKeys(keys);
		} catch (Exception e) {
			extendTest.log(LogStatus.ERROR,"Error in SendKeys() " + element);
		}	
	}
	
	//	Selects() - Expansion of Selenium Select()
	public void Selects(WebElement element, int position) {
		try {
			Select sl = new Select(element);
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
	public void FindElements(WebElement element, WebElement innerElement, String string) {
//		try {
//			List<WebElement> we = ;
//			System.out.println("Size of list = " +we.size());
//			for(WebElement w : we) {
//				System.out.println("For:Clicked = " +w.getText());
//				if(w.getText().contains(string)) {
//					System.out.println("Clicked = " +w.getText());
//					w.click();
//				}
//			}	
//		} catch (Exception e) {
//			extendTest.log(LogStatus.ERROR,"Error in FindElements" + element);
//		}	
	}

	//Calendar() - Calendar selection - TODO
	public void GetAtt(WebElement element) {
		try {
			List<WebElement> we = element.findElements(By.tagName("li"));
			for(WebElement w : we)
			System.out.println(w.getText());
		} catch (Exception e) {
			System.out.println("GetAtt: No such element " + element);
		}	
	}
	
	//MoveToElemenPerform() - Action moveToElement - Perform 
	public void MoveToElementPerform(WebElement element) {
		try {
			actions.moveToElement(element).perform();;
		} catch (Exception e) {
			extendTest.log(LogStatus.ERROR,"Error in MoveToElementPerform() " + element);
		}	
	}
	
	//MoveToElementClick() - Action moveToElement  - Click
	public void MoveToElementClick(WebElement element) {
		try {
			actions.moveToElement(element).click().perform();
//			actions.click(FindElement(locate(element,locator)));
		} catch (Exception e) {
			extendTest.log(LogStatus.ERROR,"Error in MoveToElementClick() " + element);
		}	
	}
	
	//DragAndDrop() - Drag and drop
	public void DragAndDrop(WebElement fromElement, WebElement toElement) {
		try {
			Thread.sleep(3000);
			webDriver.switchTo().frame(0);
			actions.dragAndDrop(fromElement,toElement).build().perform();

		} catch (Exception e) {
			extendTest.log(LogStatus.ERROR,"Error in DragAndDrop() " + fromElement + toElement);
		}	
	}
	
	//Slider() - Slider
	public void Slider(WebElement element) {
		try {
			Thread.sleep(3000);
			webDriver.switchTo().frame(0);
			actions.dragAndDropBy(element, 100, 0).build().perform();

		} catch (Exception e) {
			extendTest.log(LogStatus.ERROR,"Error in DragAndDrop() " + element);
		}	
	}
}
