package TestCase;

import java.io.IOException;
import java.time.Duration;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import TestPages.BaseClass;
import TestPages.Exports_Reports;
import TestPages.LoginPages;

public class CR0212_TestCase extends BaseClass {

	ExtentReports Report = new ExtentReports(
			"C:\\Users\\abhishekyt\\git\\repository\\Automation\\Reports\\ExtentReport_CR0212_TestCase_"
					+ System.currentTimeMillis() + ".html",
			true);
	ExtentTest test = Report.startTest("CR0212_TestCase");

	 @Test
	void Pledge_Creation_Test_Case1() throws IOException {
		try {
			test.log(LogStatus.INFO, "Pledge_Creation_Test_Case1 is  start");
			LoginPages Login = new LoginPages(driver, Wait);
			Login.PortalLogin("rp-Abhishek", "user51", "121@test");
			// Login.PortalLogin("", "admin", "121@test");
			Exports_Reports Test_Case1 = new Exports_Reports(driver, Wait);
			Test_Case1.CR212_Pledge_Creation_Test_Case1();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "Pledge_Creation_Test_Case1 is success full");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
			TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
			Log.Logout();
		} catch (Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "Pledge_Creation_Test_Case1 failed :" + e.getMessage());
		}
		Report.endTest(test);
		Report.flush();
	}

	// @Test
	void De_Pledge_Test_Case1() throws IOException {
		try {
			test.log(LogStatus.INFO, "De_Pledge_Test_Case1 is  start");
			LoginPages Login = new LoginPages(driver, Wait);
			Login.PortalLogin("rp-Abhishek", "user51", "121@test");
			// Login.PortalLogin("", "admin", "121@test");
			Exports_Reports Test_Case1 = new Exports_Reports(driver, Wait);
			Test_Case1.CR212_De_Pledge_Test_Case1();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "De_Pledge_Test_Case1 is success full");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
			//TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
			//Log.Logout();
		} catch (Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "De_Pledge_Test_Case1 failed :" + e.getMessage());
		}
		Report.endTest(test);
		Report.flush();
	}

	 
	// @Test
		void Pledge_Invocation_Test_Case1() throws IOException {
			try {
				test.log(LogStatus.INFO, "Pledge_Invocation_Test_Case1 is  start");
				LoginPages Login = new LoginPages(driver, Wait);
				Login.PortalLogin("rp-Abhishek", "user51", "121@test");
				// Login.PortalLogin("", "admin", "121@test");
				Exports_Reports Test_Case1 = new Exports_Reports(driver, Wait);
				Test_Case1.CR212_Pledge_Invocation_Test_Case1();
				test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
						+ "Pledge_Invocation_Test_Case1 is success full");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
				//TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
				//Log.Logout();
			} catch (Exception e) {
				test.log(LogStatus.FAIL, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
						+ "Pledge_Invocation_Test_Case1 failed :" + e.getMessage());
			}
			Report.endTest(test);
			Report.flush();
		}
}
