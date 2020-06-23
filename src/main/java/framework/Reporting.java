package framework;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class Reporting implements ITestListener {

	public void onTestStart(ITestResult result) {
		System.out.println("Inside OnTestStart");		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Inside OnTestSuccess");		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
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
