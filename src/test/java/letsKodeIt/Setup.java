package letsKodeIt;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import framework.InitialSetup;
import framework.PageDriver;
import framework.Reporting;

public class Setup extends PageDriver {

	public static PageDriver pageDriver;
	public Reporting reporting;
	private LocalDateTime unFormatedDateTime;
	private String formatedDateTime;
	private String extendReportPathAndName;

	@BeforeSuite
	public void beforeSuite() {

		InitialSetup iS = new InitialSetup();
		pageDriver = new PageDriver();
		pageDriver.Driver(iS.SetWebPage("https://jqueryui.com/slider/"));
		reporting = new Reporting();
		reporting.Reportings(pageDriver);

		// Date and Time for Extend Report file name
		unFormatedDateTime = LocalDateTime.now();
		formatedDateTime = unFormatedDateTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm-ss"));

		extendReportPathAndName = System.getProperty("user.dir") + File.separator + "Report" + File.separator
				+ "eReport " + formatedDateTime + ".html";

		ExtentSparkReporter spark = new ExtentSparkReporter(extendReportPathAndName);
		extendReport = new ExtentReports();
		extendReport.attachReporter(spark);

		extendTest = extendReport.createTest("Hello Report");
	}

	@AfterSuite
	public void afterSuite() {
		// extendReport.endTest(extendTest);
		extendReport.flush();
	}
}