package makeMyTrip_test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import framework.InitialSetup;
import framework.PageDriver;
import makeMyTrip.SearchFlight;

public class Setup extends PageDriver {
	
	public static PageDriver pD;
	public SearchFlight searchFlight;
	
  @BeforeSuite
  public void beforeSuite() {
	  
	  InitialSetup iS = new InitialSetup(); 
	  System.out.println("Inside suite");
	  pD = new PageDriver();
	  pD.Driver(iS.SetWebPage("https://www.makemytrip.com/flights/"));
	  
	  extendReport = new ExtentReports("eReport.html");
	  extendTest = extendReport.startTest("Hello Report");

  }
  
  @AfterSuite
  public void afterSuite() {
	  extendReport.endTest(extendTest);
	  extendReport.flush();
  }
}