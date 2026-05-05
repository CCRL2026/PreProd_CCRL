package TestCase;

import java.io.IOException;
import java.time.Duration;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import TestPages.BaseClass;
import TestPages.LoginPages;

public class Pay_In_Release_TestCase extends BaseClass {

	ExtentReports Report = new ExtentReports(
			"C:\\Users\\abhishekyt\\git\\repository\\Automation\\Reports\\ExtentReport"+" Pay_In_Release"+
					+ System.currentTimeMillis() + ".html",
			true);
	ExtentTest test = Report.startTest("Pay_In_Release Report");

	@Test
	void Pay_In_Release() throws IOException {
		try {
			test.log(LogStatus.INFO, "Login for Pay_In_Release start");
			LoginPages Login = new LoginPages(driver, Wait);
			Login.PortalLogin("cc8880013", "user1", "121@test");
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)));
			test.log(LogStatus.INFO, "Pay_In_Release   start");
			TestPages.Pay_In_Release Pledge = new TestPages.Pay_In_Release(driver, Wait);
			Pledge.Pay_In_Release_Request();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "Pay_Out_Request_Maker is success full");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			test.log(LogStatus.INFO, "LogOut for Pay_In_Release  Start");
			TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
			Log.Logout();
			test.log(LogStatus.INFO, "LogOut for Pay_In_Release  END");
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + "Pay_In_Release Test failed");
		}
		Report.endTest(test);
		Report.flush();
	}

}
 
