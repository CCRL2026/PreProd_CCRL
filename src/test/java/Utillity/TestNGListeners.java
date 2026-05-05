package Utillity;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.log.LogEntry;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.IExtentTestClass;
import TestPages.BaseClass;
import TestPages.ScreenShort;

import com.relevantcodes.extentreports.LogStatus;


public class TestNGListeners extends BaseClass implements ITestListener, ISuiteListener {

	//private static ExtentReports Report = ExtentManager.getExtentReports();
	//private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	ExtentReports Report = new ExtentReports(
			"C:\\Users\\abhishekyt\\git\\repository\\Automation\\Reports\\CR319_"
					+ System.currentTimeMillis() + ".html",
			true);
	ExtentTest test = Report.startTest("CR319-show completed transaction data");
	
	// TestNG Listeners are used only in XMl files not for normal class

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("********* Test started : " + result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("********* Test is sucessful : " + result.getName());
	}
	@Override 
	public void onTestFailure(ITestResult result) { 
		/// WebDriver driver = getDriver();
	      //  String testName = result.getMethod().getMethodName();
		
		// Take screenshot
        String screenshotPath = null;
		
	     
			try {
				screenshotPath = ScreenShort.CaptureScreen(driver);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	      //  String screenshotPath = ScreenshotUtil.captureScreen(driver);
	
	//	test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)).;
			 // Log to Extent Report
	       // ExtentTest test = ExtentTestManager.getTest();
	        test.log(LogStatus.FAIL, "Test Failed");
	        test.log(LogStatus.FAIL, result.getThrowable());
        //test.log(LogStatus.FAIL, test.addScreenCapture(screenshotPath));
		test.log(LogStatus.FAIL, test.addScreenCapture(screenshotPath));
		LogEntries logs=driver.manage().logs().get(LogType.BROWSER);
	    logs.getAll();
	
		
	
	/*
	 * test.log(LogStatus.FAIL, ((IExtentTestClass)
	 * test).addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) +
	 * "Test failed for Pledge_Creation_Confirmation_CR319: "+result.getName());
	 */
	  System.out.println("********* Test failed : " + result.getName());
	  
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("********* Test skipped : " + result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("********* Tests TestFailedButWithinSuccessPercentage : " + result.getName());

	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("********* Tests started : " + context.getName());
	}

	@Override
	public void onFinish(ITestContext context) {

		System.out.println("********* Tests Completed : " + context.getName());
		if (Report != null) {
			Report.flush(); // ✅ SAFE CALL
			Report.close();
		}

	}

	@Override
	public void onStart(ISuite suite) {

		System.out.println("********* Test started : " + suite.getName());

	}

	@Override
	public void onFinish(ISuite suite) {

		System.out.println("********* Test Finished : " + suite.getName());
		if (Report != null) {
			Report.flush(); // ✅ SAFE CALL
			Report.close();
		}

	}

}