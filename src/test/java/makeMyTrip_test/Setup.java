package makeMyTrip_test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;

import framework.InitialSetup;
import framework.PageDriver;
import framework.Reporting;
import makeMyTrip.SearchFlight;

public class Setup extends PageDriver {
	
	public static PageDriver pageDriver;
	public SearchFlight searchFlight;
	public Reporting reporting;
	
  @BeforeSuite
  public void beforeSuite() {
	  
	  InitialSetup iS = new InitialSetup(); 
	  pageDriver = new PageDriver();
	  pageDriver.Driver(iS.SetWebPage("https://www.makemytrip.com/flights/"));
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