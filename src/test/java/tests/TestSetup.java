package tests;

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

public class TestSetup extends InitialSetup {

    public static PageDriver pageDriver;
    public Reporting reporting;
    public static ExtentReports extendReport;

    @BeforeSuite
    public void setUp() {
        // Initialize Framework Components
        InitialSetup iS = new InitialSetup();
        pageDriver = new PageDriver();
        reporting = new Reporting();

        // Load Local Test Page
        String localPagePath = System.getProperty("user.dir") + "/src/test/resources/test_pages/login.html";
        String fileUrl = "file://" + localPagePath;

        webDriver = iS.SetWebPage(fileUrl);
        pageDriver.Driver(webDriver);
        reporting.Reportings(pageDriver);

        // Initialize ExtentReports
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss"));
        String reportPath = System.getProperty("user.dir") + "/Report/TestReport_" + timestamp + ".html";

        ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
        extendReport = new ExtentReports();
        extendReport.attachReporter(spark);

        // Link ExtentReport to InitialSetup so pages can access extendTest (if
        // inherited)
        InitialSetup.extendReport = extendReport;
    }

    @AfterSuite
    public void tearDown() {
        if (extendReport != null) {
            extendReport.flush();
        }
        if (webDriver != null) {
            // webDriver.quit(); // Optional: keep open for inspection or close
            webDriver.quit();
        }
    }
}
