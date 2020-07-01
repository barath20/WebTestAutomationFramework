package letsKodeIt;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;

import framework.InitialSetup;
import framework.PageDriver;
import framework.Reporting;

public class Setup extends PageDriver {
	
	public static PageDriver pageDriver;
	public Reporting reporting;

	
  @BeforeSuite
  public void beforeSuite() {
	  
	  InitialSetup iS = new InitialSetup(); 
	  pageDriver = new PageDriver();
	  pageDriver.Driver(iS.SetWebPage("https://learn.letskodeit.com/p/practice"));
	  reporting = new Reporting();
	  reporting.Reportings(pageDriver);
	  
	  extendReport = new ExtentReports("eReport.html");
	  extendTest = extendReport.startTest("Hello Report");
  }
  
  @AfterSuite
  public void afterSuite() {
	  extendReport.endTest(extendTest);
	  extendReport.flush();
  }
}