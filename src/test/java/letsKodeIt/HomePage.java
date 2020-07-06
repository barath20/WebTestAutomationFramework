package letsKodeIt;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class HomePage extends Setup {
//	@Test(priority=0)
//	public void Radio() throws Throwable {
//		
//		  extendTest.log(LogStatus.INFO, "Inside Radio...");
//
//		  pageDriver.Click("//input[@id='bmwradio']",Locator.xpath);
//  }
//	@Test(priority=1)
//	public void Select1() throws Throwable {
//		
//		extendTest.log(LogStatus.INFO, "Inside Select1...");
//
//		pageDriver.Selects("//select[@id='carselect']",1,Locator.xpath);
//
//  }
//	@Test(priority=2)
//	public void Select2() throws Throwable {
//		
//		extendTest.log(LogStatus.INFO, "Inside Select2...");
//
//		pageDriver.Selects("//select[@id='multiple-select-example']",1,Locator.xpath);
//
//  }
//	@Test(priority=3)
//	public void Click2() throws Throwable {
//		
//		extendTest.log(LogStatus.INFO, "Inside Click2...");
//
//		pageDriver.Click("//input[@id='hondacheck']", Locator.xpath);
//
//  }
//	
//	@Test(priority=4)
//	public void MouseHover() throws Throwable {
//		
//		extendTest.log(LogStatus.INFO, "Inside MouseHover...");
//
//		javaScriptExecutor.executeScript("window.scrollBy(0,900)");
//		
//		pageDriver.MoveToElementPerform("//button[@id='mousehover']", Locator.xpath);
//		
//		Thread.sleep(3000);
//		
//		pageDriver.MoveToElementClick("//div[@class='mouse-hover-content']//a[text()='Top']",Locator.xpath);

//  }
	
//	@Test(priority=4) // https://jqueryui.com/droppable/
//	public void Dragdrop() throws Throwable {
//
//		pageDriver.DragAndDrop("//div[@id='draggable']", Locator.xpath, "//div[@id='droppable']", Locator.xpath);
//	}
	
	@Test(priority=4) // https://jqueryui.com/slider/
	public void slider() throws Throwable {

//		pageDriver.Slider("//div[@id='slider']/span", Locator.xpath);
	}
	
}