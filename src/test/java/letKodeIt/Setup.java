package letKodeIt;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import framework.InitialSetup;
import framework.PageDriver;

public class Setup extends PageDriver {
	
	public static PageDriver pD;

	
  @BeforeSuite
  public void beforeSuite() {
	  
	  InitialSetup iS = new InitialSetup(); 
	  System.out.println("Inside suite");
	  pD = new PageDriver();
	  pD.Driver(iS.SetWebPage("https://learn.letskodeit.com/p/practice"));
	  
	  report = new ExtentReports("eReport.html");
	  test = report.startTest("Hello Report");

  }
  
  @AfterSuite
  public void afterSuite() {
	  report.endTest(test);
	  report.flush();
  }
}