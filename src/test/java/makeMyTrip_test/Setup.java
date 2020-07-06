package makeMyTrip_test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import com.relevantcodes.extentreports.ExtentReports;

import framework.InitialSetup;
import framework.PageDriver;
import framework.Reporting;
import makeMyTrip_Pages.SearchFlight;
import utils.ConfigReader;

public class Setup extends InitialSetup {
	
	public static PageDriver pageDriver;
	public SearchFlight searchFlight;
	public Reporting reporting;
	private LocalDateTime unFormatedDateTime;
	private String formatedDateTime;
	private String extendReportPathAndName;
	private ConfigReader configReader;
	public static WebDriver webDriver;
	
  @BeforeSuite
  public void beforeSuite() throws IOException {
	  
	  InitialSetup iS = new InitialSetup(); 
	  pageDriver = new PageDriver();
	  reporting = new Reporting();
	  
	  //Get url from config.properties file
	  Path path = Paths.get("");
	  String currentRelativePath = path.toAbsolutePath().toString(); 
	  configReader = new ConfigReader(currentRelativePath);
	  configReader.getPropValues("url");
	  
	  // Launch the webpage
	  webDriver = iS.SetWebPage(configReader.getPropValues("url"));
	  
	  // Attach the webDriver to the pageDriver
	  pageDriver.Driver(webDriver);
	  
	  // Attach the pagedriver to the reporting
	  reporting.Reportings(pageDriver);
	  
	  // Date and Time for Extend Report file name
	  unFormatedDateTime = LocalDateTime.now();
	  formatedDateTime = unFormatedDateTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm-ss"));
	  
	  // Extend report name and initalize
	  extendReportPathAndName = System.getProperty("user.dir") + "\\Report\\eReport "+ formatedDateTime +".html";
	  extendReport = new ExtentReports(extendReportPathAndName);
	  extendTest = extendReport.startTest("Hello Report");	  
  }
  
  @AfterSuite
  public void afterSuite() {
	  extendReport.endTest(extendTest);
	  extendReport.flush();
  }
}