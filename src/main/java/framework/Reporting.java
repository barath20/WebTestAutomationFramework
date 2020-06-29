package framework;

import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.relevantcodes.extentreports.LogStatus;

public class Reporting extends PageDriver implements ITestListener {
	
	public PageDriver pd;

	public void onTestStart(ITestResult result) {
		System.out.println("Inside OnTestStart");		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Inside OnTestSuccess");	
		String path = System.getProperty("user.dir") + "\\screenshots\\Error.png";
		extendTest.log(LogStatus.PASS, extendTest.addScreenCapture(path));
		
	}

	public void onTestFailure(ITestResult result)  {
		extendTest.log(LogStatus.FAIL, "Inside Fail...");
		try {
          //  String screenshotPath = ExtentReportsClass.getScreenshot(wd, result.getName());
            //To add it in the extent report
//            extendTest.log(LogStatus.FAIL, extendTest.addScreenCapture(System.getProperty("user.dir") + "//screenshots//Error.png"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		 extendReport
         .addSystemInfo("Host Name", "Regression testing server")
         .addSystemInfo("Environment", "Test build V1.0")
         .addSystemInfo("User Name", "Barath");
		 extendReport.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
	 }

	public void onFinish(ITestContext context) {
		System.out.println("Inside OnFinish");
		
	}

}
