package framework;

import java.io.File;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.MediaEntityBuilder;

import utils.ConfigReader;

public class Reporting extends InitialSetup implements ITestListener {

	private static PageDriver reportingPageDriver;
	ConfigReader configReader = new ConfigReader();

	public void Reportings(PageDriver pageDriver) {
		reportingPageDriver = pageDriver;
	}

	public void onTestStart(ITestResult result) {
		extendTest = extendReport.createTest("Test Case: " + result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		extendTest.log(Status.PASS, "Pass " + result.getName());
		// read the value from config.properties file to decide about taking screenshot
		// for pass test cases
		try {
			if (configReader.getPropValues("screenShot").equals("PASS"))
				try {
					reportingPageDriver.TakeScreenShot(result.getName());
					String path = System.getProperty("user.dir") + File.separator + "screenshots" + File.separator
							+ result.getName() + ".png";
					extendTest.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromPath(path).build());
				} catch (Exception e) {
					extendTest.log(Status.FAIL, "Error in OnTestFailure-TakeScreenshot");
				}
		} catch (IOException e) {
			extendTest.log(Status.FAIL, "IOException" + result.getName());
			e.printStackTrace();
		}
	}

	public void onTestFailure(ITestResult result) {
		extendTest.log(Status.FAIL, "Inside Fail...");
		try {
			reportingPageDriver.TakeScreenShot(result.getName());
			String path = System.getProperty("user.dir") + File.separator + "screenshots" + File.separator
					+ result.getName() + ".png";
			extendTest.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		} catch (Exception e) {
			extendTest.log(Status.FAIL, "Error in OnTestFailure-TakeScreenshot");
		}
	}

	public void onTestSkipped(ITestResult result) {
		extendTest.log(Status.SKIP, "Test skipped" + result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// System info is now set on the reporter or via system properties, simplified
		// here or moved to Setup.
		extendReport.setSystemInfo("Host Name", "Regression testing server");
		extendReport.setSystemInfo("Environment", "Test build V1.0");
		extendReport.setSystemInfo("User Name", "Barath");
		// Extent 5 config loading is different (SparkReporter used in Setup). Skipping
		// XML load.
		// extendReport.loadConfig(new
		// File(System.getProperty("user.dir")+"\\Resources\\extent-config.xml"));
	}

	public void onFinish(ITestContext context) {

	}

}
