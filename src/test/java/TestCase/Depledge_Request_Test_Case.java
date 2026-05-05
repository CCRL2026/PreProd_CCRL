package TestCase;

import java.io.IOException;
import java.time.Duration;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import TestPages.BaseClass;
import TestPages.LoginPages;

public class Depledge_Request_Test_Case extends BaseClass {

	ExtentReports Report = new ExtentReports(
			"C:\\Users\\abhishekyt\\git\\repository\\Automation\\Reports\\ExtentReport"
					+ System.currentTimeMillis() + ".html",
			true);
	ExtentTest test = Report.startTest("Depledge_Request Report");

	// @Test
	void Depledge_Request() throws IOException {
		try {
			test.log(LogStatus.INFO, "Login for Depledge_Request start");
			LoginPages Login = new LoginPages(driver, Wait);
			//Login.PortalLogin("rp-bhanu", "sarthak", "121@test");
			//Login.PortalLogin("RP-KML", "user_A", "121@test");
			Login.PortalLogin("rp-Abhishek", "user51", "121@test");
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)));
			test.log(LogStatus.INFO, "Depledge_Request creation  start");
			TestPages.Depledge_Request Pledge = new TestPages.Depledge_Request(driver, Wait);
			try {
			Pledge.Depledge_Request_Maker();
			}catch(Exception e) {
				System.out.println("Depledge_Request_Maker not found: " + e.getMessage());
				
			}
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "Depledge_Request is success full");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			test.log(LogStatus.INFO, "LogOut for Depledge_Request Start");
			TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
			Log.Logout();
			test.log(LogStatus.INFO, "LogOut for Depledge_Request END");
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + "Depledge_Request Test failed",
					e.getMessage());
		}
		Report.endTest(test);
		Report.flush();
	}

	// @Test
	void Depledge_Checker() throws IOException {
		try {
			test.log(LogStatus.INFO, "Login for Depledge_Request_Checker start");
			LoginPages Login = new LoginPages(driver, Wait);
			//Login.PortalLogin("RP-KML", "user_B", "121@test");
			Login.PortalLogin("rp-Abhishek", "user52", "121@test");
			//Login.PortalLogin("rp-bhanu", "sarthakp", "121@test");
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)));
			test.log(LogStatus.INFO, "Depledge_Request_Checker creation  start");
			TestPages.Depledge_Request_Authoriz Pledge = new TestPages.Depledge_Request_Authoriz(driver, Wait);
			Pledge.Depledge_Request_Checker();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "Depledge_Request_Checker is success full");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			test.log(LogStatus.INFO, "LogOut for Depledge_Request_Checker Start");
			TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
			Log.Logout();
			test.log(LogStatus.INFO, "LogOut for Depledge_Request_Checker END");
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)) + "Depledge_Request Test failed",
					e.getMessage());
		}
		Report.endTest(test);
		Report.flush();
	}

	// @Test
	void DePledge_Confirm_By_Pledgee() throws IOException {
		try {
			test.log(LogStatus.INFO, "Logion for DePledge_Confirm_By_Pledgee start");
			LoginPages Login = new LoginPages(driver, Wait);
			Login.PortalLogin("rp-UCOBANK", "panvel1", "121@test");
			//Login.PortalLogin("rp-bhanu", "sarthak", "121@test");
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)));
			test.log(LogStatus.INFO, "DePledge_Confirm_By_Pledgee start");
			TestPages.DePledge_Confirm_By_Pledgee Exch = new TestPages.DePledge_Confirm_By_Pledgee(driver, Wait);
			Exch.DePledge_Confirm_By_Pledgee_Maker();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "DePledge_Confirm_By_Pledgee is success full");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			test.log(LogStatus.INFO, "LogOut for DePledge_Confirm_By_Pledgee start");
			TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
			Log.Logout();
			test.log(LogStatus.INFO, "LogOut for DePledge_Confirm_By_Pledgee END");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "DePledge_Confirm_By_Pledgee Test failed");
		}
		Report.endTest(test);
		Report.flush();
	}

	@Test
	void DePledge_Confirm_By_Pledgee_Authorized() throws IOException {
		try {
			test.log(LogStatus.INFO, "Logion for DePledge_Confirm_By_Pledgee_Authorized start");
			LoginPages Login = new LoginPages(driver, Wait);
			Login.PortalLogin("rp-UCOBANK", "panvel2", "121@test");
			//Login.PortalLogin("rp-bhanu", "sarthakp", "121@test");
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver)));
			test.log(LogStatus.INFO, "DePledge_Confirm_By_Pledgee_Authorized start");
			TestPages.Depledge_Request_Authoriz Exch = new TestPages.Depledge_Request_Authoriz(driver, Wait);
			Exch.DePledge_Confirm_By_Pledgee_Checker();
			test.log(LogStatus.PASS, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "DePledge_Confirm_By_Pledgee_Authorized is success full");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			test.log(LogStatus.INFO, "LogOut for DePledge_Confirm_By_Pledgee_Authorized start");
			TestPages.LogoutPage Log = new TestPages.LogoutPage(driver, Wait);
			Log.Logout();
			test.log(LogStatus.INFO, "LogOut for DePledge_Confirm_By_Pledgee_Authorized  END");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(TestPages.ScreenShort.CaptureScreen(driver))
					+ "DePledge_Confirm_By_Pledgee_Authorized Test failed");
		}

		Report.endTest(test);
		Report.flush();
	}

}
