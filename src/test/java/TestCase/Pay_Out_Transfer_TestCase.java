package TestCase;

import java.io.IOException;
import java.time.Duration;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import TestPages.BaseClass;
import TestPages.LoginPages;

public class Pay_Out_Transfer_TestCase extends BaseClass {

	ExtentReports Report = new ExtentReports(
			"C:\\Users\\abhishekyt\\git\\repository\\Automation\\Reports\\ExtentReport"
					+ System.currentTimeMillis() + ".html",
			true);
	ExtentTest test = Report.startTest("Pay_Out_Request_Maker Report");

	@Test
	void Pay_Out_Request() throws IOException {
		try {
			test.log(LogStatus.INFO, "Login for Pay_Out_Request_Maker start");
			LoginPages Login = new LoginPages(driver, Wait);
			Login.PortalLogin("cc8880013", "user1", "121@test");
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)));
			test.log(LogStatus.INFO, "Pledge_Creation creation  start");
			TestPages.Pay_Out_Request_Maker Pledge = new TestPages.Pay_Out_Request_Maker(driver, Wait);
			Pledge.Pay_Out_Request();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "Pay_Out_Request_Maker is success full");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			test.log(LogStatus.INFO, "LogOut for Pay_Out_Request_Maker  Start");
			TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
			Log.Logout();
			test.log(LogStatus.INFO, "LogOut for Pay_Out_Request_Maker  END");
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + "Pay_Out_Request_Maker Test failed");
		}
		Report.endTest(test);
		Report.flush();
	}

}
