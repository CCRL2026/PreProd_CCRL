package TestCase;

import java.io.IOException;
import java.time.Duration;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import TestPages.BaseClass;
import TestPages.LoginPages;

public class Pay_In_Transfer_TestCase extends BaseClass {

	ExtentReports Report = new ExtentReports(
			"C:\\Users\\abhishekyt\\git\\repository\\Automation\\Reports\\ExtentReport"
					+ System.currentTimeMillis() + ".html",
			true);
	ExtentTest test = Report.startTest("Pay_In Report");

	@Test
	void Pay_In_Request_Maker() throws IOException {
		try {
			test.log(LogStatus.INFO, "Login for Pay_In_Request_Maker start");
			LoginPages Login = new LoginPages(driver, Wait);
			Login.PortalLogin("cc8880013", "user1", "121@test");
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)));
			test.log(LogStatus.INFO, "Pay_In_Request_Maker creation  start");
			TestPages.Pay_In_Request_Maker Pay_In = new TestPages.Pay_In_Request_Maker(driver, Wait);
			Pay_In.Pay_In_Request();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "Pay_In_Request_Maker is success full");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			test.log(LogStatus.INFO, "LogOut for Pay_In_Request_Maker  Start");
			TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
			Log.Logout();
			test.log(LogStatus.INFO, "LogOut for Pay_In_Request_Maker  END");
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + "Pay_In_Request_Maker Test failed");
		}
		Report.endTest(test);
		Report.flush();
	}

}
