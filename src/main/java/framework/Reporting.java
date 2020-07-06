package framework;

import java.io.File;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.relevantcodes.extentreports.LogStatus;

import utils.ConfigReader;

public class Reporting extends InitialSetup implements ITestListener {
	
	private static PageDriver rpageDriver;
	ConfigReader configReader = new ConfigReader();
	
	public void Reportings(PageDriver pageDriver) {
		rpageDriver = pageDriver;
	}
	
	public void onTestStart(ITestResult result) {
		
	}

	public void onTestSuccess(ITestResult result) {
		extendTest.log(LogStatus.PASS, "Pass " + result.getName());
		// read the value from config.properties file to decide about taking screenshot for pass test cases
		try {
			if(configReader.getPropValues("screenShot").equals("PASS"))  
			try {
				rpageDriver.TakeScreenShot(result.getName());
				String path = System.getProperty("user.dir") + "\\screenshots\\" + result.getName() + ".png";
				extendTest.log(LogStatus.PASS, extendTest.addScreenCapture(path));
			} catch (Exception e) {
				extendTest.log(LogStatus.ERROR, "Error in OnTestFailure-TakeScreenshot");
			}
		} catch (IOException e) {
			extendTest.log(LogStatus.ERROR, "IOException" + result.getName());
			e.printStackTrace();
		}
	}

	public void onTestFailure(ITestResult result)  {
		extendTest.log(LogStatus.FAIL, "Inside Fail...");
			try {
				rpageDriver.TakeScreenShot(result.getName());
				String path = System.getProperty("user.dir") + "\\screenshots\\" + result.getName() + ".png";
				extendTest.log(LogStatus.PASS, extendTest.addScreenCapture(path));
			} catch (Exception e) {
				extendTest.log(LogStatus.ERROR, "Error in OnTestFailure-TakeScreenshot");
			}
	}

	public void onTestSkipped(ITestResult result) {
		extendTest.log(LogStatus.SKIP, "Test skipped" + result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		 extendReport
         .addSystemInfo("Host Name", "Regression testing server")
         .addSystemInfo("Environment", "Test build V1.0")
         .addSystemInfo("User Name", "Barath");
		 extendReport.loadConfig(new File(System.getProperty("user.dir")+"\\Resources\\extent-config.xml"));
	 }

	public void onFinish(ITestContext context) {

		
	}

}
