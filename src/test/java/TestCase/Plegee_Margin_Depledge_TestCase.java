package TestCase;

import java.io.IOException;
import java.time.Duration;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import TestPages.BaseClass;
import TestPages.LoginPages;

public class Plegee_Margin_Depledge_TestCase extends BaseClass {

	ExtentReports Report = new ExtentReports(
			"C:\\Users\\abhishekyt\\git\\repository\\Automation\\Reports\\ExtentReport"
					+ System.currentTimeMillis() + ".html",
			true);
	ExtentTest test = Report.startTest("Margin_Depledge Report");

	/****************************************************CC_Margin_DePledge_Request***********************************/
	
	//@Test
	void CC_Margin_DePledge_Request_Maker() throws IOException {
		try {
			test.log(LogStatus.INFO, "Login for CC_Margin_DePledge_Request_Maker start");
			LoginPages Login = new LoginPages(driver, Wait);
			Login.PortalLogin("CC8880013", "user1", "121@test");
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)));
			test.log(LogStatus.INFO, "CC_Margin_DePledge_Request_Maker creation  start");
			TestPages.CC_Margin_DePledge_Request DePledge = new TestPages.CC_Margin_DePledge_Request(driver, Wait);
			DePledge.CC_Margin_DePledge_Request_Maker();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "CC_Margin_DePledge_Request_Maker is success full");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			test.log(LogStatus.INFO, "LogOut for CC_Margin_DePledge_Request_Maker  Start");
			TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
			Log.Logout();
			test.log(LogStatus.INFO, "LogOut for CC_Margin_DePledge_Request_Maker  END");
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))+e.getMessage() + "CC_Margin_DePledge_Request_Maker Test failed");
		}
		Report.endTest(test);
		Report.flush();
	}
	//@Test
		void CC_Margin_DePledge_Request_Checker() throws IOException {
			try {
				test.log(LogStatus.INFO, "Login for CC_Margin_DePledge_Request_Checker start");
				LoginPages Login = new LoginPages(driver, Wait);
				Login.PortalLogin("CC8880013", "user2", "test@121");
				test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)));
				test.log(LogStatus.INFO, "CC_Margin_DePledge_Request_Maker creation  start");
				TestPages.Margin_Pledge_Checker DePledge = new TestPages.Margin_Pledge_Checker(driver, Wait);
				DePledge.CC_Margin_DePledge_Request_Checker();
				test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
						+ "CC_Margin_DePledge_Request_Maker is success full");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				test.log(LogStatus.INFO, "LogOut for CC_Margin_DePledge_Request_Maker  Start");
				TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
				Log.Logout();
				test.log(LogStatus.INFO, "LogOut for CC_Margin_DePledge_Request_Maker  END");
			} catch (Exception e) {
				test.log(LogStatus.FAIL,
						test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))+e.getMessage() + "CC_Margin_DePledge_Request_Maker Test failed");
			}
			Report.endTest(test);
			Report.flush();
		}
	
	/**********************************************CM_Margin_DePledge_Request*****************************************************/
	//@Test
		void CM_Margin_DePledge_Request_Maker() throws IOException {
			try {
				test.log(LogStatus.INFO, "Login for CM_Margin_DePledge_Request_Maker start");
				LoginPages Login = new LoginPages(driver, Wait);
				Login.PortalLogin("rp-abhishek", "user51", "121@test");
				test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)));
				test.log(LogStatus.INFO, "CM_Margin_DePledge_Request_Maker creation  start");
				TestPages.CM_Margin_DePledge_Request Margin = new TestPages.CM_Margin_DePledge_Request(driver, Wait);
				Margin.CM_Margin_DePledge_Request_Maker();
				test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
						+ "CM_Margin_DePledge_Request_Maker is success full");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				test.log(LogStatus.INFO, "LogOut for CM_Margin_DePledge_Request_Maker  Start");
				TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
				Log.Logout();
				test.log(LogStatus.INFO, "LogOut for CM_Margin_DePledge_Request_Maker  END");
			} catch (Exception e) {
				test.log(LogStatus.FAIL,
						test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))+e.getMessage() + "CM_Margin_DePledge_Request_Maker Test failed");
			}
			Report.endTest(test);
			Report.flush();
		}
		
		//@Test
				void CM_Margin_DePledge_Request_Checker() throws IOException {
					try {
						test.log(LogStatus.INFO, "Login for CM_Margin_DePledge_Request_Checker start");
						LoginPages Login = new LoginPages(driver, Wait);
						Login.PortalLogin("rp-abhishek", "user52", "121@test");
						test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)));
						test.log(LogStatus.INFO, "CM_Margin_DePledge_Request_Checker creation  start");
						TestPages.Margin_Pledge_Checker DePledge = new TestPages.Margin_Pledge_Checker(driver, Wait);
						DePledge.CM_Margin_DePledge_Request_Checker();
						test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
								+ "CM_Margin_DePledge_Request_Maker is success full");
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
						test.log(LogStatus.INFO, "LogOut for CM_Margin_DePledge_Request_Checker  Start");
						TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
						Log.Logout();
						test.log(LogStatus.INFO, "LogOut for CM_Margin_DePledge_Request_Checker  END");
					} catch (Exception e) {
						test.log(LogStatus.FAIL,
								test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))+e.getMessage() + "CM_Margin_DePledge_Request_Checker Test failed");
					}
					Report.endTest(test);
					Report.flush();
				}
		
	/************************************************TM_Margin_DePledge_Request_Maker********************************************************/	
		//@Test
		void TM_Margin_DePledge_Request_Maker() throws IOException {
			try {
				test.log(LogStatus.INFO, "Login for TM_Margin_DePledge_Request_Maker start");
				LoginPages Login = new LoginPages(driver, Wait);
				Login.PortalLogin("rp-abhishek", "user51", "121@test");
				test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)));
				test.log(LogStatus.INFO, "TM_Margin_DePledge_Request_Maker creation  start");
				TestPages.TM_Margin_DePledge_Request Margin = new TestPages.TM_Margin_DePledge_Request(driver, Wait);
				Margin.TM_Margin_DePledge_Request_Maker();
				test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
						+ "TM_Margin_DePledge_Request_Maker is success full");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				test.log(LogStatus.INFO, "LogOut for TM_Margin_DePledge_Request_Maker  Start");
				TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
				Log.Logout();
				test.log(LogStatus.INFO, "LogOut for TM_Margin_DePledge_Request_Maker  END");
			} catch (Exception e) {
				test.log(LogStatus.FAIL,
						test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))+e.getMessage() + "TM_Margin_DePledge_Request_Maker Test failed");
			}
			Report.endTest(test);
			Report.flush();
		}
		
		@Test
				void TM_Margin_DePledge_Request_Checker() throws IOException {
					try {
						test.log(LogStatus.INFO, "Login for TM_Margin_DePledge_Request_Maker start");
						LoginPages Login = new LoginPages(driver, Wait);
						Login.PortalLogin("rp-abhishek", "user52", "121@test");
						test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)));
						test.log(LogStatus.INFO, "TM_Margin_DePledge_Request_Maker creation  start");
						TestPages.Margin_Pledge_Checker DePledge = new TestPages.Margin_Pledge_Checker(driver, Wait);
						DePledge.TM_Margin_DePledge_Request_Checker();
						test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
								+ "TM_Margin_DePledge_Request_Maker is success full");
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
						test.log(LogStatus.INFO, "LogOut for TM_Margin_DePledge_Request_Maker  Start");
						TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
						Log.Logout();
						test.log(LogStatus.INFO, "LogOut for TM_Margin_DePledge_Request_Maker  END");
					} catch (Exception e) {
						test.log(LogStatus.FAIL,
								test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))+e.getMessage() + "TM_Margin_DePledge_Request_Maker Test failed");
					}
					Report.endTest(test);
					Report.flush();
				}
}
