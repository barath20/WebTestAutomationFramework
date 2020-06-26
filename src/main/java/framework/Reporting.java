package framework;

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
		test.log(LogStatus.PASS, "Inside Pass...");
	}

	public void onTestFailure(ITestResult result)  {
		test.log(LogStatus.FAIL, "Inside Fail...");
		try {
			System.out.println("Inside OnTestFailure");
//			pd.TakeScreenShot();
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
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		System.out.println("Inside OnFinish");
		
	}

}
