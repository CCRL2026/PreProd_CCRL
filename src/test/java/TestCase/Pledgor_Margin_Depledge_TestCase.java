package TestCase;

import java.io.IOException;
import java.time.Duration;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import TestPages.BaseClass;
import TestPages.LoginPages;

public class Pledgor_Margin_Depledge_TestCase extends BaseClass {

	ExtentReports Report = new ExtentReports("C:\\Users\\abhishekyt\\git\\repository\\Automation\\Reports\\ExtentReport"
			+ System.currentTimeMillis() + ".html", true);
	ExtentTest test = Report.startTest("Margin_Depledge Report");

	/**********************************************
	 * Pledgor_CM_Margin_DePledge_Request_Maker
	 *****************************************************/
	 //@Test
	void Pledgor_CM_Margin_DePledge_Request_Maker() throws IOException {
		try {
			test.log(LogStatus.INFO, "Login for Pledgor_CM_Margin_DePledge_Request_Maker start");
			LoginPages Login = new LoginPages(driver, Wait);
			Login.PortalLogin("rp-kml", "user1", "121@test");
			//Login.PortalLogin("rp-abhishek", "user51", "121@test");
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)));
			test.log(LogStatus.INFO, "Pledgor_CM_Margin_DePledge_Request_Maker creation  start");
			TestPages.CM_Margin_DePledge_Request DePledge = new TestPages.CM_Margin_DePledge_Request(driver, Wait);
			DePledge.Pledgor_CM_Margin_DePledge_Request_Maker();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "Pledgor_CM_Margin_DePledge_Request_Maker is success full");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			test.log(LogStatus.INFO, "LogOut for Pledgor_CM_Margin_DePledge_Request_Maker  Start");
			TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
			Log.Logout();
			test.log(LogStatus.INFO, "LogOut for Pledgor_CM_Margin_DePledge_Request_Maker  END");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + e.getMessage()
					+ "Pledgor_CM_Margin_DePledge_Request_Maker Test failed");
		}
		Report.endTest(test);
		Report.flush();
	}

	// @Test
	void Pledgor_CM_Margin_DePledge_Request_Checker() throws IOException {
		try {
			test.log(LogStatus.INFO, "Login for Pledgor_CM_Margin_DePledge_Request_Checker start");
			LoginPages Login = new LoginPages(driver, Wait);
			//Login.PortalLogin("rp-abhishek", "user52", "121@test");
			Login.PortalLogin("rp-kml", "user2", "121@test");
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)));
			test.log(LogStatus.INFO, "Pledgor_CM_Margin_DePledge_Request_Checker creation  start");
			TestPages.Margin_Pledge_Checker DePledge = new TestPages.Margin_Pledge_Checker(driver, Wait);
			DePledge.Pledgor_CM_Margin_DePledge_Request_Checker();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "Pledgor_CM_Margin_DePledge_Request_Checker is success full");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			test.log(LogStatus.INFO, "LogOut for Pledgor_CM_Margin_DePledge_Request_Checker  Start");
			TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
			Log.Logout();
			test.log(LogStatus.INFO, "LogOut for Pledgor_CM_Margin_DePledge_Request_Checker  END");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + e.getMessage()
					+ "Pledgor_CM_Margin_DePledge_Request_Checker Test failed");
		}
		Report.endTest(test);
		Report.flush();
	}

	/**********************************************
	 * Pledgor_CC_Margin_DePledge_Request_Confirm_Maker
	 *****************************************************/

	// @Test
	void Pledgor_CC_Margin_DePledge_Request_Confirm_Maker() throws IOException {
		try {
			test.log(LogStatus.INFO, "Login for Pledgor_CM_Margin_DePledge_Request_Confirm_Maker start");
			LoginPages Login = new LoginPages(driver, Wait);
			Login.PortalLogin("cc8880013", "user1", "121@test");
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)));
			test.log(LogStatus.INFO, "Pledgor_CM_Margin_DePledge_Request_Confirm_Maker creation  start");
			TestPages.CM_Margin_DePledge_Confirm DePledge = new TestPages.CM_Margin_DePledge_Confirm(driver, Wait);
			DePledge.Pledgor_CM_Margin_DePledge_Request_Confirm_Maker();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "Pledgor_CM_Margin_DePledge_Request_Confirm_Maker is success full");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			test.log(LogStatus.INFO, "LogOut for Pledgor_CM_Margin_DePledge_Request_Confirm_Maker  Start");
			TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
			Log.Logout();
			test.log(LogStatus.INFO, "LogOut for Pledgor_CM_Margin_DePledge_Request_Confirm_Maker  END");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + e.getMessage()
					+ "Pledgor_CM_Margin_DePledge_Request_Confirm_Maker Test failed");
		}
		Report.endTest(test);
		Report.flush();
	}

	// @Test
	void Pledgor_CC_Margin_DePledge_Request_Confirm_Checker() throws IOException {
		try {
			test.log(LogStatus.INFO, "Login for Pledgor_CC_Margin_DePledge_Request_Confirm_Checker start");
			LoginPages Login = new LoginPages(driver, Wait);
			Login.PortalLogin("cc8880013", "user2", "test@121");
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)));
			test.log(LogStatus.INFO, "Pledgor_CC_Margin_DePledge_Request_Confirm_Checker creation  start");
			TestPages.Margin_Pledge_Checker DePledge = new TestPages.Margin_Pledge_Checker(driver, Wait);
			DePledge.Pledgor_CC_Margin_DePledge_Request_Confirm_Checker();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "Pledgor_CC_Margin_DePledge_Request_Confirm_Checker is success full");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			test.log(LogStatus.INFO, "LogOut for Pledgor_CC_Margin_DePledge_Request_Confirm_Checker  Start");
			TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
			Log.Logout();
			test.log(LogStatus.INFO, "LogOut for Pledgor_CC_Margin_DePledge_Request_Confirm_Checker  END");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + e.getMessage()
					+ "Pledgor_CC_Margin_DePledge_Request_Confirm_Checker Test failed");
		}
		Report.endTest(test);
		Report.flush();
	}

	/************************************************
	 * Pledgor_TM_Margin_DePledge_Request_Maker
	 ********************************************************/
	// @Test
	void Pledgor_TM_Margin_DePledge_Request_Maker() throws IOException {
		try {
			test.log(LogStatus.INFO, "Login for Pledgor_TM_Margin_DePledge_Request_Maker start");
			LoginPages Login = new LoginPages(driver, Wait);
			Login.PortalLogin("rp-xyz", "user1", "121@test");
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)));
			test.log(LogStatus.INFO, "Pledgor_TM_Margin_DePledge_Request_Maker creation  start");
			TestPages.TM_Margin_DePledge_Request DePledge = new TestPages.TM_Margin_DePledge_Request(driver, Wait);
			DePledge.Pledgor_TM_Margin_DePledge_Request_Maker();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "Pledgor_TM_Margin_DePledge_Request_Maker is success full");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			test.log(LogStatus.INFO, "LogOut for Pledgor_TM_Margin_DePledge_Request_Maker  Start");
			TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
			Log.Logout();
			test.log(LogStatus.INFO, "LogOut for Pledgor_TM_Margin_DePledge_Request_Maker  END");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + e.getMessage()
					+ "Pledgor_TM_Margin_DePledge_Request_Maker Test failed");
		}
		Report.endTest(test);
		Report.flush();
	}

	 //@Test
	void Pledgor_TM_Margin_DePledge_Request_Checker() throws IOException {
		try {
			test.log(LogStatus.INFO, "Login for Pledgor_TM_Margin_DePledge_Request_Checker start");
			LoginPages Login = new LoginPages(driver, Wait);
			Login.PortalLogin("rp-xyz", "user101", "test@121");
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)));
			test.log(LogStatus.INFO, "Pledgor_TM_Margin_DePledge_Request_Checker creation  start");
			TestPages.Margin_Pledge_Checker DePledge = new TestPages.Margin_Pledge_Checker(driver, Wait);
			DePledge.Pledgor_TM_Margin_DePledge_Request_Checker();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "Pledgor_TM_Margin_DePledge_Request_Checker is success full");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			test.log(LogStatus.INFO, "LogOut for Pledgor_TM_Margin_DePledge_Request_Checker  Start");
			TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
			Log.Logout();
			test.log(LogStatus.INFO, "LogOut for Pledgor_TM_Margin_DePledge_Request_Checker  END");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + e.getMessage()
					+ "Pledgor_TM_Margin_DePledge_Request_Checker Test failed");
		}
		Report.endTest(test);
		Report.flush();
	}

	/**********************************************
	 * Pledgor_TM_Margin_DePledge_Request_Confirm_Maker
	 *****************************************************/

	// @Test
	void Pledgor_CM_Margin_DePledge_Request_Confirm_Maker() throws IOException {
		try {
			test.log(LogStatus.INFO, "Login for Pledgor_TM_Margin_DePledge_Request_Confirm_Maker start");
			LoginPages Login = new LoginPages(driver, Wait);
			//Login.PortalLogin("rp-abhishek", "user51", "121@test");
			Login.PortalLogin("rp-kml", "user1", "121@test");
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)));
			test.log(LogStatus.INFO, "Pledgor_TM_Margin_DePledge_Request_Confirm_Maker creation  start");
			TestPages.TM_Margin_DePledge_Confirm DePledge = new TestPages.TM_Margin_DePledge_Confirm(driver, Wait);
			DePledge.Pledgor_TM_Margin_DePledge_Request_Confirm_Maker();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "Pledgor_TM_Margin_DePledge_Request_Confirm_Maker is success full");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			test.log(LogStatus.INFO, "LogOut for Pledgor_TM_Margin_DePledge_Request_Confirm_Maker  Start");
			TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
			Log.Logout();
			test.log(LogStatus.INFO, "LogOut for Pledgor_TM_Margin_DePledge_Request_Confirm_Maker  END");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + e.getMessage()
					+ "Pledgor_TM_Margin_DePledge_Request_Confirm_Maker Test failed");
		}
		Report.endTest(test);
		Report.flush();
	}

	// @Test
	void Pledgor_CM_Margin_DePledge_Request_Confirm_Checker() throws IOException {
		try {
			test.log(LogStatus.INFO, "Login for Pledgor_TM_Margin_DePledge_Request_Confirm_Checker start");
			LoginPages Login = new LoginPages(driver, Wait);
			//Login.PortalLogin("rp-abhishek", "user52", "121@test");
			Login.PortalLogin("rp-kml", "user2", "121@test");
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)));
			test.log(LogStatus.INFO, "Pledgor_TM_Margin_DePledge_Request_Confirm_Checker creation  start");
			TestPages.Margin_Pledge_Checker DePledge = new TestPages.Margin_Pledge_Checker(driver, Wait);
			DePledge.Pledgor_CM_Margin_DePledge_Request_Confirm_Checker();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "Pledgor_TM_Margin_DePledge_Request_Confirm_Checker is success full");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			test.log(LogStatus.INFO, "LogOut for Pledgor_TM_Margin_DePledge_Request_Confirm_Checker  Start");
			TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
			Log.Logout();
			test.log(LogStatus.INFO, "LogOut for Pledgor_TM_Margin_DePledge_Request_Confirm_Checker  END");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + e.getMessage()
					+ "CM_Margin_DePledge_Request_Maker Test failed");
		}
		Report.endTest(test);
		Report.flush();
	}

	/****************************************************
	 * Pledgor_RP_Margin_DePledge_Request_Maker
	 ***********************************/
	 //@Test
	void Pledgor_RP_Margin_DePledge_Request_Maker() throws IOException {
		try {
			test.log(LogStatus.INFO, "Login for Pledgor_RP_Margin_DePledge_Request_Maker start");
			LoginPages Login = new LoginPages(driver, Wait);
			Login.PortalLogin("rp-abhishek", "user51", "121@test");
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)));
			test.log(LogStatus.INFO, "Pledgor_RP_Margin_DePledge_Request_Maker creation  start");
			TestPages.RP_Margin_DePledge_Request Margin = new TestPages.RP_Margin_DePledge_Request(driver, Wait);
			Margin.RP_Margin_DePledge_Request_Maker();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "Pledgor_RP_Margin_DePledge_Request_Maker is success full");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			test.log(LogStatus.INFO, "LogOut for Pledgor_RP_Margin_DePledge_Request_Maker  Start");
			TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
			Log.Logout();
			test.log(LogStatus.INFO, "LogOut for Pledgor_RP_Margin_DePledge_Request_Maker  END");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + e.getMessage()
					+ "Pledgor_RP_Margin_DePledge_Request_Maker Test failed");
		}
		Report.endTest(test);
		Report.flush();
	}

	// @Test
	void Pledgor_RP_Margin_DePledge_Request_Checker() throws IOException {
		try {
			test.log(LogStatus.INFO, "Login for Pledgor_RP_Margin_DePledge_Request_Checker start");
			LoginPages Login = new LoginPages(driver, Wait);
			Login.PortalLogin("rp-abhishek", "user52", "121@test");
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)));
			test.log(LogStatus.INFO, "Pledgor_RP_Margin_DePledge_Request_Checker creation  start");
			TestPages.Margin_Pledge_Checker DePledge = new TestPages.Margin_Pledge_Checker(driver, Wait);
			DePledge.Pledgor_RP_Margin_DePledge_Request_();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "Pledgor_RP_Margin_DePledge_Request_Checker is success full");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			test.log(LogStatus.INFO, "LogOut for Pledgor_RP_Margin_DePledge_Request_Checker  Start");
			TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
			Log.Logout();
			test.log(LogStatus.INFO, "LogOut for Pledgor_RP_Margin_DePledge_Request_Checker  END");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + e.getMessage()
					+ "Pledgor_RP_Margin_DePledge_Request_Checker Test failed");
		}
		Report.endTest(test);
		Report.flush();
	}

	/**********************************************
	 * Pledgor_TM_Margin_DePledge_Request_Confirm_Maker
	 *****************************************************/
	// @Test
	void Pledgor_TM_Margin_DePledge_Request_Confirm_Maker() throws IOException {
		try {
			test.log(LogStatus.INFO, "Login for Pledgor_TM_Margin_DePledge_Request_Confirm_Maker start");
			LoginPages Login = new LoginPages(driver, Wait);
			Login.PortalLogin("rp-xyz", "user1", "121@test");
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)));
			test.log(LogStatus.INFO, "Pledgor_TM_Margin_DePledge_Request_Confirm_Maker creation  start");
			TestPages.TM_Margin_DePledge_Confirm DePledge = new TestPages.TM_Margin_DePledge_Confirm(driver, Wait);
			DePledge.Pledgor_RP_Margin_DePledge_Request_Confirm_Maker();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "Pledgor_TM_Margin_DePledge_Request_Confirm_Maker is success full");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			test.log(LogStatus.INFO, "LogOut for Pledgor_TM_Margin_DePledge_Request_Confirm_Maker  Start");
			TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
			Log.Logout();
			test.log(LogStatus.INFO, "LogOut for Pledgor_TM_Margin_DePledge_Request_Confirm_Maker  END");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + e.getMessage()
					+ "Pledgor_TM_Margin_DePledge_Request_Confirm_Maker Test failed");
		}
		Report.endTest(test);
		Report.flush();
	}

	 @Test
	void Pledgor_TM_Margin_DePledge_Request_Confirm_Checker() throws IOException {
		try {
			test.log(LogStatus.INFO, "Login for Pledgor_TM_Margin_DePledge_Request_Confirm_Checker start");
			LoginPages Login = new LoginPages(driver, Wait);
			Login.PortalLogin("rp-xyz", "user101", "test@121");
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)));
			test.log(LogStatus.INFO, "Pledgor_TM_Margin_DePledge_Request_Confirm_Checker creation  start");
			TestPages.Margin_Pledge_Checker DePledge = new TestPages.Margin_Pledge_Checker(driver, Wait);
			DePledge.Pledgor_TM_Margin_DePledge_Request_Confirm_Checker();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "Pledgor_TM_Margin_DePledge_Request_Confirm_Checker is success full");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			test.log(LogStatus.INFO, "LogOut for Pledgor_TM_Margin_DePledge_Request_Confirm_Checker  Start");
			TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
			Log.Logout();
			test.log(LogStatus.INFO, "LogOut for Pledgor_TM_Margin_DePledge_Request_Confirm_Checker  END");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + e.getMessage()
					+ "Pledgor_TM_Margin_DePledge_Request_Confirm_Checker Test failed");
		}
		Report.endTest(test);
		Report.flush();
	}

}
